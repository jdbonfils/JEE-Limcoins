package Personne;

import javax.persistence.*;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


@MappedSuperclass
public class Personne implements Serializable {

    @Id
    private String email ;
    private String mdp ;
    private float limcoinsPossede ;
    protected String nom ;
    protected String prenom ;
    protected String adresse ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp(){
        return this.mdp;
    }

    public void setMdp(String mdp) {

        this.mdp = outils.outils.getHashFromPassword(mdp) ;
    }

    public float getLimcoinsPossede() {
        return limcoinsPossede;
    }

    public void setLimcoinsPossede(float limcoinsPossede) {
        this.limcoinsPossede = limcoinsPossede;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
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

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


}
