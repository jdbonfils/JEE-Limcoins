package Parieur;

import Bookmaker.BookmakerBean;
import Cote.CoteBean;

import Limcoin.Limcoin;
import Limcoin.LimcoinBean;
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

    @EJB
    private Limcoin limcoin ;

    @ManagedProperty("#{pariManagedBean}")
    private PariManagedBean pariBean ;
    private List<PariBean> listParis ;
    private ParieurBean parieurCo ;

    private float euroPossede ;
    private float dollarPossede ;

    public void onLoad()
    {
        LimcoinBean lim = limcoin.getLastLimcoin();
        this.euroPossede = (lim.getEuro() * this.parieurCo.getLimcoinsPossede());
        this.dollarPossede = (lim.getDollar() * this.parieurCo.getLimcoinsPossede());
    }
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

    public String getEtat(long idPari) {
        for(PariBean pari : this.getListeParis())
            if(pari.getId() == idPari)
                if(pari.getCoteConcerne().getMatchConcerne().getTermine())
                    return "TERMINE" ;
        return "EN COURS" ;
    }

    public float getEuroPossede() {
        return euroPossede;
    }

    public void setEuroPossede(float euroPossede) {
        this.euroPossede = euroPossede;
    }

    public float getDollarPossede() {
        return dollarPossede;
    }

    public void setDollarPossede(float dollarPossede) {
        this.dollarPossede = dollarPossede;
    }
}
