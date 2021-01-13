package Bookmaker;

import Cote.CoteBean;
import Limcoin.Limcoin;
import Limcoin.LimcoinBean;
import Pari.PariBean;
import Personne.PersonneCoManagedBean;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class BookmakerProfilManagedBean {

    @EJB
    private Bookmaker b ;
    @EJB
    private Limcoin limcoin ;
    @ManagedProperty("#{personneCoManagedBean}")
    private PersonneCoManagedBean personneCo ;

    private BookmakerBean profil ;
    private float euroPossede ;
    private float dollarPossede ;

    public void onLoad() throws IOException {
        if(!personneCo.isConnecte())
        {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/" +"index.xhtml");
        }
        this.setProfil(b.getBookmaker(personneCo.getPersonneCo().getEmail())) ;

        LimcoinBean lim = limcoin.getLastLimcoin();
        this.euroPossede = (lim.getEuro() * this.getProfil().getLimcoinsPossede());
        this.dollarPossede = (lim.getDollar() * this.getProfil().getLimcoinsPossede());

    }

    public void home() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/" +"listMatch.xhtml");
    }

    public String getEtat(long idCote) {
        for(CoteBean cote : profil.getListCoteEffectue())
            if(cote.getId() == idCote)
                if(cote.getMatchConcerne().getTermine())
                    return "TERMINE" ;
        return "EN COURS" ;
    }

    public PersonneCoManagedBean getPersonneCo() {
        return personneCo;
    }

    public void setPersonneCo(PersonneCoManagedBean personneCo) {
        this.personneCo = personneCo;
    }

    public BookmakerBean getProfil() {
        return profil;
    }

    public void setProfil(BookmakerBean profil) {
        this.profil = profil;
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
