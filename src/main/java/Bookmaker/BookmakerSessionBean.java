package Bookmaker;

import Administrateur.AdministrateurBean;
import Cote.CoteBean;
import Parieur.Parieur;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Stateless
public class BookmakerSessionBean implements Bookmaker, Serializable {

    @PersistenceContext
    EntityManager em ;


    @Override
    public boolean addBookmaker(String email,String mdp, String nom, String prenom, String date, String addr,String tel) {
        Query q = em.createNativeQuery("select * from BookmakerBean p where p.EMAIL = ? ", BookmakerBean.class);
        q.setParameter(1, email);
        if(q.getResultList().isEmpty()) {
            BookmakerBean p = new BookmakerBean(email, mdp, nom, prenom, date, addr, tel);
            em.persist(p);
            return true;
        }
            return false ;

    }

    @Override
    public BookmakerBean connect(String email, String mdp)
    {
        Query q = em.createNativeQuery("select * from BookmakerBean p where p.EMAIL = ? AND p.MDP = ?", BookmakerBean.class);
        q.setParameter(1, email);
        q.setParameter(2, outils.outils.getHashFromPassword(mdp));
        if(q.getResultList().isEmpty()){
            return null ;
        }
        return (BookmakerBean) q.getResultList().get(0)  ;
    }
    @Override
    public List<CoteBean> getCote(String email)
    {
        Query q = em.createNativeQuery("select * from BookmakerBean p where p.EMAIL = ?", BookmakerBean.class);
        q.setParameter(1, email);
        if(q.getResultList().isEmpty()){
            return null ;
        }
        BookmakerBean b = (BookmakerBean) q.getResultList().get(0)  ;
        System.out.print(b.getListCoteEffectue().get(b.getListCoteEffectue().size()-1).getMultiplicateur()) ;
        return b.getListCoteEffectue() ;
    }

    @Override
    public void updateBookmaker() {

    }

    @Override
    public void deleteBookmaker(String email) {
        Query q = em.createNativeQuery("DELETE FROM BookmakerBean p where p.EMAIL = ?");
        q.setParameter(1, email);
        q.executeUpdate();
    }

    @Override
    public List<BookmakerBean> getListBookmaker() {
        Query emQuery = em.createNamedQuery("allBookmaker") ;
        return (List<BookmakerBean>) emQuery.getResultList() ;
    }
}