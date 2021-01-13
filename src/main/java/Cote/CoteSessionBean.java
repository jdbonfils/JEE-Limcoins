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
    public void addCote( float multi, EquipeBean gagnant, BookmakerBean createur, ConfrontationBean c1) {
        String email = createur.getEmail() ;
        Long idMatch = c1.getId() ;

        CoteBean p = new CoteBean(multi,gagnant ,createur,c1);
        em.persist(p);

        BookmakerBean b = em.find(BookmakerBean.class,email);
        ConfrontationBean c = em.find(ConfrontationBean.class,idMatch) ;

        c.getListeCote().add(p) ;
        b.getListCoteEffectue().add(p) ;

        em.merge(c) ;
        em.merge(b) ;
        createur.getListCoteEffectue().add(p) ;
        em.merge(createur) ;
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
