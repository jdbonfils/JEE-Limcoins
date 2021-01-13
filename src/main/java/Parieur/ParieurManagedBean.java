package Parieur;

import Bookmaker.BookmakerBean;
import Bookmaker.ClassementBookmakerBean;

import Confrontation.ConfrontationManagedBean;
import Pari.PariBean;
import Personne.PersonneCoManagedBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

@ManagedBean
@ApplicationScoped
public class ParieurManagedBean implements Serializable {
    @EJB
    private Parieur parieur ;

    @ManagedProperty("#{confrontationManagedBean}")
    private ConfrontationManagedBean matchBean ;
    @ManagedProperty("#{classementParieurBean}")
    private ClassementParieurBean classementParieurBean ;
    @ManagedProperty("#{personneCoManagedBean}")
    private PersonneCoManagedBean personneCo ;

    private String nom ;
    private String prenom ;
    private Date birthdate ;
    private String adresse ;
    private String email ;
    private String mdp ;
    private String etat ;


    public String addParieur(){
        if(mdp == "" || nom == ""  || email == "" || prenom == "" || birthdate == null)
        {
            FacesContext.getCurrentInstance().addMessage("messagesp", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Saisir les champs obligatoires"));
            birthdate = null ;
            return null ;
        }
        if(mdp.length() < 8)
        {
            FacesContext.getCurrentInstance().addMessage("messagesp", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Mot de passe trop court"));
            birthdate = null ;
            return null ;
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(this.birthdate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String dateNaiss = day +" / "+month +" / "+ year ;
        Boolean success = this.parieur.addParieur(this.email,this.mdp, this.nom, this.prenom,  dateNaiss,this.adresse);
        email = null ;
        mdp = null ;
        nom = null ;
        birthdate = null ;

        prenom = null ;
        adresse = null ;
        if(success)
        {
            return "index.xhtml" ;
        }
        FacesContext.getCurrentInstance().addMessage("messagesp", new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur", "Ce compte existe déjà"));
        return null ;

    }
    public List<ParieurBean> getListParieur()
    {
        return this.parieur.getListParieur() ;
    }

    public String back()
    {
        return "index.xhtml" ;
    }
    public String connection()
    {
        ParieurBean a = this.parieur.connect(this.email,this.mdp) ;
        System.out.println("MDP"+ this.mdp) ;
        if(a != null )
        {
            this.personneCo.setPersonneCo(a);
             return "listMatch.xhtml";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage("parieur", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Mot de passe ou e-mail incorrect"));
            this.email = "" ;
            this.mdp = "" ;
        }
        return null ;
    }

    public String creerCompte() {
        return "creerParieur.xhtml" ;
    }

    public ConfrontationManagedBean getMatchBean() {
        return matchBean;
    }

    public void setMatchBean(ConfrontationManagedBean matchBean) {
        this.matchBean = matchBean;
    }

    public ClassementParieurBean getClassementParieurBean() {
        return classementParieurBean;
    }

    public void setClassementParieurBean(ClassementParieurBean classementParieurBean) {
        this.classementParieurBean = classementParieurBean;
    }

    public PersonneCoManagedBean getPersonneCo() {
        return personneCo;
    }

    public void setPersonneCo(PersonneCoManagedBean personneCo) {
        this.personneCo = personneCo;
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

    public Parieur getParieur() {
        return parieur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setParieur(Parieur parieur) {
        this.parieur = parieur;
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
}
