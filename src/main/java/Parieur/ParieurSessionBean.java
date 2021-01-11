package Parieur;

import Bookmaker.BookmakerBean;
import Pari.PariBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ParieurSessionBean implements Parieur, Serializable {

    @PersistenceContext
    EntityManager em ;

    @Override
    public void addParieur(String email,String mdp,  String nom,String prenom, String date, String addr) {
        ParieurBean p = new ParieurBean(email,mdp,  nom,prenom,date,addr,0);
        em.persist(p);
    }

    @Override
    public void updateParieur() {

    }

    @Override
    public void deleteParieur(String email) {
        Query q = em.createNativeQuery("DELETE FROM ParieuBean p where p.ID = ?");
        q.setParameter(1, email);
        q.executeUpdate();
    }

    @Override
    public List<ParieurBean> getListParieur() {
        Query emQuery = em.createNamedQuery("allParieur") ;
        return (List<ParieurBean>) emQuery.getResultList() ;
    }

    @Override
    public ParieurBean connect(String email, String mdp) {
        Query q = em.createNativeQuery("select * from ParieurBean p where p.EMAIL = ? AND p.MDP = ?", ParieurBean.class);
        q.setParameter(1, email);
        q.setParameter(2, outils.outils.getHashFromPassword(mdp));
        if(q.getResultList().isEmpty()){
            return null ;
        }
        return (ParieurBean) q.getResultList().get(0)  ;
    }

    @Override
    public List<PariBean> getListParis(String email) {
        return  em.find(ParieurBean.class,email).getListPariEffectue();
    }
}
