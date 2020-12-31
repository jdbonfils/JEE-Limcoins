package Parieur;

import Bookmaker.BookmakerBean;
import Cote.CoteBean;
import Pari.PariBean;
import Pari.PariManagedBean;
import Personne.Personne;

import javax.ejb.EJB;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


@ManagedBean
@ApplicationScoped
public class ParieurProfilManagedBean {

    @EJB
    private Parieur parieur ;

    @ManagedProperty("#{pariManagedBean}")
    private PariManagedBean pariBean ;
    private List<PariBean> listParis ;
    private ParieurBean parieurCo ;

    public String detailsCote(long id)
    {
        CoteBean c = null ;
        for(PariBean p : this.listParis)
        {
            if(p.getId() == id )
            {
                c = p.getCoteConcerne() ;
                pariBean.setCoteConcerne(c);
                pariBean.setPersonneConnecte((Personne)this.parieurCo);
                return "detailsCote.xhtml" ;
            }
        }
        return null ;
    }

    public List<PariBean> getListeParis()
    {
        listParis = this.parieur.getListParis(this.parieurCo.getEmail()) ;
        return listParis ;

    }

    public ParieurBean getParieurCo() {
        return parieurCo;
    }

    public void setParieurCo(ParieurBean personneConnecte) {
        this.parieurCo = personneConnecte;
    }

    public PariManagedBean getPariBean() {
        return pariBean;
    }

    public void setPariBean(PariManagedBean pariBean) {
        this.pariBean = pariBean;
    }
}
