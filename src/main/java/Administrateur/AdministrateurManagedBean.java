package Administrateur;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.PostLoad;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

@ManagedBean
@ApplicationScoped
public class AdministrateurManagedBean {

    @EJB
    Administrateur admin ;

    private String nom ;
    private String prenom ;
    private String adresse ;
    private String tel ;
    private String email;
    private String mdp ;
    private String etat ;



    public static void main (String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest("tata".getBytes(StandardCharsets.UTF_8));
        Base64.Encoder enc = Base64.getEncoder();
        System.out.println(enc.encodeToString(encodedhash));
    }

    public String connection()
    {
        AdministrateurBean a = this.admin.getAdmin(this.email,this.mdp) ;

        if(a != null )
        {
          return "manage.xhtml";
        }
        else
        {
            this.etat = "Email ou mot de passe incorrecte" ;
        }
        return null ;
    }

    public void addAdministrateur(){
        this.admin.addAdministrateur(this.email,this.mdp, this.nom, this.prenom,this.adresse,this.tel );
    }
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }



    public Administrateur getAdmin() {
        return admin;
    }

    public void setAdmin(Administrateur admin) {
        this.admin = admin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
}
