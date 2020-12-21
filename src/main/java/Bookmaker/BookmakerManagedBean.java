package Bookmaker;

import Parieur.Parieur;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class BookmakerManagedBean {

    @EJB
    private Bookmaker bookmaker ;

    private String nom ;
    private String prenom ;
    private String birthdate ;
    private String adresse ;
    private String tel ;

    public Bookmaker getBookmaker() {
        return bookmaker;
    }

    public void setBookmaker(Bookmaker bookmaker) {
        this.bookmaker = bookmaker;
    }

    public void addBookmaker(){
        this.bookmaker.addBookmaker(this.nom, this.prenom,  this.birthdate,this.adresse,this.tel );
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
