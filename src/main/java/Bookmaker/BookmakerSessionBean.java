package Bookmaker;

import Administrateur.AdministrateurBean;
import Parieur.Parieur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
public class BookmakerSessionBean implements Bookmaker, Serializable {

    @PersistenceContext
    EntityManager em ;


    @Override
    public void addBookmaker(String email,String mdp, String nom, String prenom, String date, String addr,String tel) {
        BookmakerBean p = new BookmakerBean(email,mdp, nom,prenom,date,addr,tel);
        em.persist(p);
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