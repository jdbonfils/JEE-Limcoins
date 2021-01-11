package Confrontation;


import Bookmaker.BookmakerBean;
import Bookmaker.BookmakerManagedBean;
import Cote.CoteManagedBean;
import Equipe.Equipe;
import Equipe.EquipeBean;
import Parieur.ParieurBean;
import Parieur.ParieurProfilManagedBean;
import Personne.Personne;



import javax.ejb.EJB;


import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

@ManagedBean
@ApplicationScoped
public class ConfrontationManagedBean {

    @EJB
    private Confrontation confrontation ;

    @EJB
    private Equipe equipe ;

    @ManagedProperty("#{coteManagedBean}")
    private CoteManagedBean coteBean;

    @ManagedProperty("#{parieurProfilManagedBean}")
    private ParieurProfilManagedBean parieurProfil;

    protected Personne personneConnecte ;

    protected List<ConfrontationBean> listMatch ;
    private List<ConfrontationBean> filteredMatch;



    public String newCote(long id )
    {
        for(ConfrontationBean c : this.listMatch)
        {
            if(c.getId() == id)
            {
                coteBean.setMatch(c);
                coteBean.setPersonneConnecte(personneConnecte) ;
            }
        }
        return "newCote.xhtml" ;
    }
    public void onLoad()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Connected",  "Vous êtes connecté en tant que : "+ this.getPersonneConnecte().getPrenom() +" "+this.getPersonneConnecte().getNom())) ;
        this.listMatch = this.confrontation.getListConfrontation() ;
    }
    public List<ConfrontationBean> getListMatch()
    {
        return this.listMatch ;
    }

    public String afficherSolde()
    {
        return "Solde : "+this.personneConnecte.getLimcoinsPossede()+" Limcoins" ;
    }

    public String profil()
    {
        if (this.personneConnecte instanceof BookmakerBean)
        {
            return "profilBookmaker.xhtml" ;
        }
        else {
            parieurProfil.setParieurCo((ParieurBean) this.personneConnecte);
            return "profilParieur.xhtml";
        }

    }
    public void classementBookmaker() throws IOException {

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/" +"classementBookmaker.xhtml");

    }
    public void classementParieur() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/" +"classementParieur.xhtml");

    }

    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        ConfrontationBean match = (ConfrontationBean) value;
        return  match.getLieu().toLowerCase().contains(filterText)
                || (new Date(match.getDate())).toString().toLowerCase().contains(filterText)
                || match.getE1().getNom().toLowerCase().contains(filterText)
                || match.getE2().getNom().toLowerCase().contains(filterText)
                || match.getNom().toLowerCase().contains(filterText)
                || (match.getListeCote().size()+"").contains(filterText) ;

    }

    //Getters et Setters



    public List<ConfrontationBean> getFilteredMatch() {
        return filteredMatch;
    }

    public void setFilteredMatch(List<ConfrontationBean> filteredMatch) {
        this.filteredMatch = filteredMatch;
    }

    public ParieurProfilManagedBean getParieurProfil() {
        return parieurProfil;
    }

    public void setParieurProfil(ParieurProfilManagedBean parieurProfil) {
        this.parieurProfil = parieurProfil;
    }

    public Personne getPersonneConnecte() {
        return personneConnecte;
    }

    public void setPersonneConnecte(Personne personneConnecte) {
        this.personneConnecte = personneConnecte;
    }

    public void setListMatch(List<ConfrontationBean> listMatch) {
        this.listMatch = listMatch;
    }


    public CoteManagedBean getCoteBean() {
        return coteBean;
    }

    public void setCoteBean(CoteManagedBean coteBean) {
        this.coteBean = coteBean;
    }



}
