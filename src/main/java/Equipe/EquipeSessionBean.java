package Equipe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
@Stateless
public class EquipeSessionBean implements Serializable, Equipe {

    @PersistenceContext
    EntityManager em ;


    @Override
    public EquipeBean getEquipe(long id)
    {
        Query emQuery = em.createNativeQuery("SELECT * FROM EquipeBean p where p.ID = ?",EquipeBean.class);
        emQuery.setParameter(1, id);
        List<EquipeBean> equipeBean = (List<EquipeBean>) emQuery.getResultList() ;
        if(! equipeBean.isEmpty())
        {
            return equipeBean.get(0) ;
        }

        return null ;
    }
    @Override
    public void addEquipe(String nom, String ville, int rep, List<JoueurBean> membres) {

        EquipeBean p = new EquipeBean(nom, ville, rep, membres);

        em.persist(p);

    }

    @Override
    public void updateEquipe() {

    }

    @Override
    public void deleteEquipe(int id) {
        Query q = em.createNativeQuery("DELETE FROM EquipeBean p where p.ID = ?");
        q.setParameter(1, id);
        q.executeUpdate();
    }

    @Override
    public List<EquipeBean> getListEquipe() {
        Query emQuery = em.createNamedQuery("allEquipe") ;
        return (List<EquipeBean>) emQuery.getResultList() ;
    }
}
