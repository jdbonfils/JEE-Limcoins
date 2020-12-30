package Confrontation;


import Bookmaker.BookmakerBean;
import Equipe.EquipeBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
@Stateless
public class ConfrontationSessionBean implements Confrontation, Serializable {

    @PersistenceContext
    EntityManager em ;

    @Override
    public void addConfrontation(String nom, String lieu, Date date, int minutes, EquipeBean e1, EquipeBean e2) {
        ConfrontationBean p = new ConfrontationBean(nom, lieu, date, minutes, e1, e2);

        em.persist(p);
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
