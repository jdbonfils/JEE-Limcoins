package Parieur;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name="allParieur", query="select p from ParieurBean p")
public class ParieurBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nom ;
    private String prenom ;
    private float limcoinsPossede ;
    private String birthDate ;
    private String adresse ;

    public ParieurBean(String nom,String prenom, String date, String addr)
    {
        this.nom = nom ;
        this.prenom = prenom ;
        this.limcoinsPossede = 1000 ;
        this.birthDate = date ;
        this.adresse = addr ;
    }
    public ParieurBean() {
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public float getLimcoinsPossede() {
        return limcoinsPossede;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAdresse() {
        return adresse;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLimcoinsPossede(float limcoinsPossede) {
        this.limcoinsPossede = limcoinsPossede;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
