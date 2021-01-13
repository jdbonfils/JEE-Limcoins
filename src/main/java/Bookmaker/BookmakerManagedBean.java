package Bookmaker;

import Administrateur.AdministrateurBean;
import Confrontation.ConfrontationManagedBean;
import Cote.CoteBean;
import Pari.PariBean;
import Parieur.Parieur;
import Personne.PersonneCoManagedBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.el.MethodExpression;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.*;

@ManagedBean
@ApplicationScoped
public class BookmakerManagedBean {

    @EJB
    private Bookmaker bookmaker ;



    @ManagedProperty("#{personneCoManagedBean}")
    private PersonneCoManagedBean personneCo ;


    private String nom ;
    private String prenom ;

    private String adresse ;
    private String tel ;
    private String email;
    private String mdp ;
    private String etat ;
    private List<CoteBean> cotesList ;
    private Date birthdate ;

    public String createBookmaker(){

        if(tel == "" || mdp == "" || nom == ""  || email == "" || prenom == "" || birthdate == null)
        {
            FacesContext.getCurrentInstance().addMessage("messagesb", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Saisir les champs obligatoires"));
            birthdate = null ;
            return null ;
        }
        if(!tel.matches("\\d+"))
        {
            FacesContext.getCurrentInstance().addMessage("messagesb", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Telephone invalide"));
            birthdate = null ;
            return null ;
        }
        if(mdp.length() < 8)
        {
            FacesContext.getCurrentInstance().addMessage("messagesb", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Mot de passe trop court"));
            birthdate = null ;
            return null ;
        }
        boolean success = this.bookmaker.addBookmaker(this.email, this.mdp, this.nom, this.prenom, outils.outils.getDate(this.birthdate),this.adresse,this.tel );
        email = null ;
        mdp = null ;
        nom = null ;
        birthdate = null ;
        tel = null ;
        prenom = null ;
        adresse = null ;
        if(success)
        {
            return "index.xhtml" ;
        }
        FacesContext.getCurrentInstance().addMessage("messagesb", new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur", "Ce compte existe déjà"));
        return null ;
    }

    public String back()
    {
        return "index.xhtml" ;
    }

    public List<BookmakerBean> getListBookmaker()
    {
        return this.bookmaker.getListBookmaker() ;
    }

    public String connection()
    {
        this.bookmaker.connect(this.email,this.mdp) ;
        BookmakerBean a = this.bookmaker.connect(this.email,this.mdp) ;
        this.email = "" ;
        this.mdp = "" ;
        if(a != null )
        {
            personneCo.setPersonneCo(a);
            return "listMatch.xhtml";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage("bookmaker", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Mot de passe ou e-mail incorrect"));

        }
        return null ;
    }

    public PersonneCoManagedBean getPersonneCo() {
        return personneCo;
    }

    public void setPersonneCo(PersonneCoManagedBean personneCo) {
        this.personneCo = personneCo;
    }

    public String creerCompte() {
        return "creerBookmaker.xhtml" ;
    }

    public void onLoad()
    {
        this.cotesList = this.bookmaker.getCote(this.personneCo.getPersonneCo().getEmail()) ;
    }

    public List<CoteBean> getCotesList() {
        return cotesList;
    }

    public void setCotesList(List<CoteBean> cotesList) {
        this.cotesList = cotesList;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Bookmaker getBookmaker() {
        return bookmaker;
    }

    public void setBookmaker(Bookmaker bookmaker) {
        this.bookmaker = bookmaker;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


}
