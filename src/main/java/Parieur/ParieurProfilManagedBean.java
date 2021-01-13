package Parieur;

import Bookmaker.BookmakerBean;
import Cote.CoteBean;

import Limcoin.Limcoin;
import Limcoin.LimcoinBean;
import Pari.PariBean;
import Pari.PariManagedBean;
import Personne.PersonneCoManagedBean;


import javax.ejb.EJB;

import javax.el.MethodExpression;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


@ManagedBean
@ApplicationScoped
public class ParieurProfilManagedBean {


    @EJB
    private Parieur p ;
    @EJB
    private Limcoin limcoin ;
    @ManagedProperty("#{pariManagedBean}")
    private PariManagedBean pariBean ;
    @ManagedProperty("#{personneCoManagedBean}")
    private PersonneCoManagedBean personneCo ;

    private ParieurBean profil ;

    private float euroPossede ;
    private float dollarPossede ;

    public void onLoad() throws IOException {
        if(!personneCo.isConnecte())
        {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/" +"index.xhtml");
        }
        this.setProfil((ParieurBean) personneCo.getPersonneCo()) ;
        LimcoinBean lim = limcoin.getLastLimcoin();
        this.euroPossede = (lim.getEuro() * this.getProfil().getLimcoinsPossede());
        this.dollarPossede = (lim.getDollar() * this.getProfil().getLimcoinsPossede());
    }
    public String detailsCote(long id)
    {
        CoteBean c = null ;
        for(PariBean p : profil.getListPariEffectue())
        {
            if(p.getId() == id )
            {
                c = p.getCoteConcerne() ;
                pariBean.setCoteConcerne(c);
                return "detailsCote.xhtml" ;
            }
        }
        return null ;
    }

    public String getEtat(long idPari) {
        for(PariBean pari : profil.getListPariEffectue())
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

    public PersonneCoManagedBean getPersonneCo() {
        return personneCo;
    }
    public void setPersonneCo(PersonneCoManagedBean personneCo) {
        this.personneCo = personneCo;
    }

    public PariManagedBean getPariBean() {
        return pariBean;
    }

    public void setPariBean(PariManagedBean pariBean) {
        this.pariBean = pariBean;
    }

    public ParieurBean getProfil() {
        return profil;
    }

    public void setProfil(ParieurBean profil) {
        this.profil = profil;
    }

    public void home() throws IOException {

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/" +"listMatch.xhtml");
    }
}
