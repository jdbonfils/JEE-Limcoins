package Pari;

import Bookmaker.BookmakerBean;
import Cote.CoteBean;
import Parieur.ParieurBean;

import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class PariSessionBean implements Serializable,Pari {

    @PersistenceContext
    EntityManager em ;

    @Override
    public void addPari(float limcoinmise, ParieurBean parieur, CoteBean cote) {
        String email = parieur.getEmail();
        Long idCote = cote.getId() ;

        PariBean pari = new PariBean(limcoinmise,parieur,  cote);
        em.persist(pari);

        ParieurBean b = em.find(ParieurBean.class,email);
        CoteBean c = em.find(CoteBean.class,idCote);

        b.getListPariEffectue().add(pari) ;
        c.getListPariAssocie().add(pari);

        em.merge(c) ;
        em.merge(b) ;
    }



    @Override
    public void updatePari() {

    }

    @Override
    public void deletePari(long id) {

    }

    @Override
    public List<PariBean> getListParis() {
        return null;
    }
}
