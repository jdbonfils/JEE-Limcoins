package Cote;

import Bookmaker.BookmakerBean;
import Confrontation.ConfrontationBean;
import Equipe.EquipeBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
public class CoteSessionBean implements Cote, Serializable {

    @PersistenceContext
    EntityManager em ;


    @Override
    public CoteBean getCoteWithId(long id)
    {
        Query emQuery = em.createNativeQuery("SELECT * FROM CoteBean p where p.ID = ?",CoteBean.class);
        emQuery.setParameter(1, id);
        List<CoteBean> coteBean = (List<CoteBean>) emQuery.getResultList() ;
        if(! coteBean.isEmpty())
        {
            return coteBean.get(0) ;
        }
        return null ;
    }
    @Override
    public void addCote( float multi, Integer s1, Integer s2, BookmakerBean createur, ConfrontationBean c1) {
        if(s1 < s2)
        {
            CoteBean p = new CoteBean(multi,c1.getE1(),s1,s2 ,createur,c1);
            em.persist(p);
        }
        else if(s2 > s1)
        {
            CoteBean p = new CoteBean(multi,c1.getE2(),s1,s2 ,createur,c1);
            em.persist(p);
        }
        else
        {
            CoteBean p = new CoteBean(multi,null,s1,s2 ,createur,c1);
            em.persist(p);
        }
    }
    @Override
    public void addCote( float multi, EquipeBean gagnant, BookmakerBean createur, ConfrontationBean c1) {
        CoteBean p = new CoteBean(multi,gagnant ,createur,c1);
        em.persist(p);
    }

    @Override
    public void updateCote() {

    }

    @Override
    public void deleteCote(long id) {

    }

    @Override
    public CoteBean geCote(long id) {
        return null;
    }

    @Override
    public List<CoteBean> getListCote() {
        Query emQuery = em.createNamedQuery("allCote") ;
        return (List<CoteBean>) emQuery.getResultList() ;
    }
}
