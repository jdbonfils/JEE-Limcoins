package Confrontation;


import Bookmaker.BookmakerBean;
import Cote.CoteBean;
import Equipe.EquipeBean;
import Pari.PariBean;
import Parieur.ParieurBean;
import org.python.util.PythonInterpreter;

import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.*;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Stateless
@Startup
public class ConfrontationSessionBean implements Confrontation, Serializable {

    @PersistenceContext
    EntityManager em ;

    @Override
    public void addConfrontation(String nom, String lieu, long date, int minutes, EquipeBean e1, EquipeBean e2) {
        ConfrontationBean p = new ConfrontationBean(nom, lieu, date, minutes, e1, e2);

        em.persist(p);
    }

    //Met à jour les match terminés
    @Schedule(hour="*", minute="*/5", persistent=false)
    public void updateAll() throws IOException {
        Random random = new Random();

        List<ConfrontationBean>listeAmettreAjour = this.getListConfrontation() ;
        for(ConfrontationBean match : listeAmettreAjour)
        {
            //SI le match est terminé
            if( (match.getDate()+ TimeUnit.MINUTES.toMillis(match.getMinutes())) <= System.currentTimeMillis() && !match.getTermine())
            {
                //0 = egalite, 1 equipe 1, 2 equipe 2
                match.setScoreE1(random.nextInt(5));
                match.setScoreE2(random.nextInt(5));
                match.setTermine(true);

                if(match.getScoreE1() > match.getScoreE2())
                {
                    match.setGagnant(match.getE1());
                }
                else if(match.getScoreE1() < match.getScoreE2())
                {
                    match.setGagnant(match.getE2());
                }

                for(CoteBean c: match.getListeCote())
                {
                    float multi = 1 ;
                    BookmakerBean bookMakerAssocie = c.getCreateur() ;
                    if(c.getGagnant() == match.getGagnant()) {
                        multi = c.getMultiplicateur() ;
                    }else {
                        multi = (-1*c.getMultiplicateur()) ;
                    }
                    for (PariBean pari : c.getListPariAssocie()) {
                        System.out.println("La chanklaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") ;
                        ParieurBean parieur = pari.getParieur();
                        parieur.setLimcoinsPossede(parieur.getLimcoinsPossede() + (pari.getLimCoinMise() * multi ));
                        bookMakerAssocie.setLimcoinsPossede(bookMakerAssocie.getLimcoinsPossede() - (pari.getLimCoinMise() * multi ));
                        if(multi > 0){
                            parieur.incNbParisGagne();
                        }
                        em.merge(parieur) ;

                    }
                    em.merge(bookMakerAssocie) ;
                }

                System.out.println("Il faut maj se match") ;
            }
        }
    /**/
        System.out.println("MAJ done") ;
    }


    @Override
    public void updateConfrontation() {

    }

    @Override
    public void deleteConfrontation(int id) {
        Query q = em.createNativeQuery("DELETE FROM ConfrontationBean p where p.ID = ?");
        q.setParameter(1, id);
        q.executeUpdate();
    }

    @Override
    public List<ConfrontationBean> getListConfrontation() {
        Query emQuery = em.createNamedQuery("allMatch") ;
        return (List<ConfrontationBean>) emQuery.getResultList() ;
    }
}
