package Parieur;

import Bookmaker.BookmakerBean;
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

    private ParieurBean parieurCo ;

    public List<PariBean> getListeParis()
    {
        return this.parieur.getListParis(this.parieurCo.getEmail()) ;
    }

    public ParieurBean getParieurCo() {
        return parieurCo;
    }

    public void setParieurCo(ParieurBean personneConnecte) {
        this.parieurCo = personneConnecte;
    }
}
