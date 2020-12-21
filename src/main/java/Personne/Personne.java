package Personne;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
public abstract class Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;


    protected String nom ;
    protected String prenom ;
    protected float limcoinsPossede ;
    protected String birthDate ;
    protected String adresse ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
