package Parieur;

import Pari.PariBean;
import Personne.Personne;

import javax.ejb.EJB;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


@ManagedBean
@ApplicationScoped
public class ParieurProfilManagedBean {

    @EJB
    private Parieur parieur ;

    private Personne personneConnecte ;

    public List<PariBean> getListeParis()
    {
        return this.parieur.getListParis(this.personneConnecte.getEmail()) ;
    }

    public Personne getPersonneConnecte() {
        return personneConnecte;
    }

    public void setPersonneConnecte(Personne personneConnecte) {
        this.personneConnecte = personneConnecte;
    }
}
