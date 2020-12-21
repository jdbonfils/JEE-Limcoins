package Parieur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
public class ParieurSessionBean implements Parieur, Serializable {

    @PersistenceContext
    EntityManager em ;

    @Override
    public void addParieur(String nom,String prenom, String date, String addr) {
        ParieurBean p = new ParieurBean(nom,prenom,date,addr);
        em.persist(p);
    }

    @Override
    public void updateParieur() {

    }

    @Override
    public void deleteParieur(int id) {
        Query q = em.createNativeQuery("DELETE FROM ParieuBean p where p.ID = ?");
        q.setParameter(1, id);
        q.executeUpdate();
    }

    @Override
    public List<ParieurBean> getListParieur() {
        Query emQuery = em.createNamedQuery("allParieur") ;
        return (List<ParieurBean>) emQuery.getResultList() ;
    }
}
