package Pari;



import Cote.CoteBean;
import Parieur.ParieurBean;
import Personne.PersonneCoManagedBean;


import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

@ManagedBean
@ApplicationScoped
public class PariManagedBean implements Serializable {

    @EJB
    private Pari pari ;

    @ManagedProperty("#{personneCoManagedBean}")
    private PersonneCoManagedBean personneCo ;

    private CoteBean coteConcerne ;
    private float mise ;

    public void onLoad() throws IOException {
        if (!personneCo.isConnecte()) {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/" + "index.xhtml");
        }
    }
    public String getDate(long m) {
        return outils.outils.getDate(new Date(m)) ;
    }
    public String gain()
    {
        float gain =  this.mise * this.coteConcerne.getMultiplicateur() ;
        return "Gain/ Perte : "+ (new DecimalFormat("#.##")).format(gain) +" Limcoins"  ;
    }
    public void creerPari() throws IOException {
        if(this.personneCo.isParieur() )
        {
            this.pari.addPari(this.mise, (ParieurBean) this.personneCo.getPersonneCo(),this.coteConcerne);
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/" + "listMatch.xhtml");
        }

    }
    public boolean getIsParieur() {
        if(coteConcerne.getMatchConcerne().getTermine() || !personneCo.isParieur())
            return false ;
        return true ;
    }

    public float getMise() {
        return mise;
    }

    public void setMise(float mise) {
        this.mise = mise;
    }

    public CoteBean getCoteConcerne() {
        return coteConcerne;
    }

    public void setCoteConcerne(CoteBean coteConcerne) {
        this.coteConcerne = coteConcerne;
    }

    public PersonneCoManagedBean getPersonneCo() {
        return personneCo;
    }

    public void setPersonneCo(PersonneCoManagedBean personneCo) {
        this.personneCo = personneCo;
    }
}
