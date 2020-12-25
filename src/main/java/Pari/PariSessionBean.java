package Pari;

import Cote.CoteBean;
import Parieur.ParieurBean;

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
        PariBean p = new PariBean(limcoinmise,parieur,  cote);
        em.persist(p);
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
