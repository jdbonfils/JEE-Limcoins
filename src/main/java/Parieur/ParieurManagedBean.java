package Parieur;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean
@ApplicationScoped
public class ParieurManagedBean implements Serializable {
    @EJB
    private Parieur parieur ;

    private String nom ;
    private String prenom ;
    private String birthdate ;
    private String adresse ;

    public Parieur getParieur() {
        return parieur;
    }

    public void setParieur(Parieur parieur) {
        this.parieur = parieur;
    }

    public void addLivre(){
        this.parieur.addParieur(this.nom, this.prenom,  this.birthdate,this.adresse);
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
