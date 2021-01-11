package Parieur;

import Bookmaker.BookmakerBean;
import Bookmaker.ClassementBookmakerBean;

import Confrontation.ConfrontationManagedBean;
import Pari.PariBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class ParieurManagedBean implements Serializable {
    @EJB
    private Parieur parieur ;

    @ManagedProperty("#{confrontationManagedBean}")
    private ConfrontationManagedBean matchBean ;
    @ManagedProperty("#{classementParieurBean}")
    private ClassementParieurBean classementParieurBean ;

    private String nom ;
    private String prenom ;
    private String birthdate ;
    private String adresse ;
    private String email ;
    private String mdp ;
    private String etat ;


    public void addParieur(){
        this.parieur.addParieur(this.email,this.mdp, this.nom, this.prenom,  this.birthdate,this.adresse);
    }
    public List<ParieurBean> getListParieur()
    {
        return this.parieur.getListParieur() ;
    }


    public String connection()
    {
        ParieurBean a = this.parieur.connect(this.email,this.mdp) ;

        if(a != null )
        {
            this.classementParieurBean.setPersonneConnecte(a);
            matchBean.setPersonneConnecte(a) ;
             return "listMatch.xhtml";
        }
        else
        {
            this.etat = "Email ou mot de passe incorrecte" ;
        }
        return null ;
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

    public void setBirthdate(String birthdate) {
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

    public String getBirthdate() {
        return birthdate;
    }

    public String getAdresse() {
        return adresse;
    }
}
