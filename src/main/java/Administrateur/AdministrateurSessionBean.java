package Administrateur;

import Bookmaker.BookmakerBean;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
public class AdministrateurSessionBean implements Administrateur, Serializable {

    @PersistenceContext
    EntityManager em ;

    @Override
    public AdministrateurBean getAdmin(String email,String mdp)
    {
        Query q = em.createNativeQuery("select * from AdministrateurBean p where p.EMAIL = ? AND p.MDP = ?", AdministrateurBean.class);
        q.setParameter(1, email);
        q.setParameter(2, outils.outils.getHashFromPassword(mdp));
        if(q.getResultList().isEmpty()){
            return null ;
        }
        return (AdministrateurBean) q.getResultList().get(0)  ;
    }
    @Override
    public void addAdministrateur(String email, String mdp, String nom, String prenom, String addr, String tel) {
        AdministrateurBean p = new AdministrateurBean(email,mdp, nom,prenom,addr,tel);
        em.persist(p);
    }

    @Override
    public void updateAdministrateur() {

    }

    @Override
    public void deleteAdministrateur(String email) {
        Query q = em.createNativeQuery("DELETE FROM AdministrateurBean p where p.EMAIL = ?");
        q.setParameter(1, email);
        q.executeUpdate();
    }

    @Override
    public List<AdministrateurBean> getListAdministrateur() {
        Query emQuery = em.createNamedQuery("allAdmins") ;
        return (List<AdministrateurBean>) emQuery.getResultList() ;
    }
}
