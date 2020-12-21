package Bookmaker;

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
    public void addBookmaker(String nom, String prenom, String date, String addr,String tel) {
        BookmakerBean p = new BookmakerBean(nom,prenom,date,addr,tel);
        em.persist(p);
    }

    @Override
    public void updateBookmaker() {

    }

    @Override
    public void deleteBookmaker(int id) {
        Query q = em.createNativeQuery("DELETE FROM BookmakerBean p where p.ID = ?");
        q.setParameter(1, id);
        q.executeUpdate();
    }

    @Override
    public List<BookmakerBean> getListBookmaker() {
        Query emQuery = em.createNamedQuery("allBookmaker") ;
        return (List<BookmakerBean>) emQuery.getResultList() ;
    }
}