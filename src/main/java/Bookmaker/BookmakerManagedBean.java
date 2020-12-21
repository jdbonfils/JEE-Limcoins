package Bookmaker;

import Administrateur.AdministrateurBean;
import Parieur.Parieur;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

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
    private String email;
    private String mdp ;
    private String etat ;



    public String createBookmaker(){
        boolean success = this.bookmaker.addBookmaker(this.email, this.mdp, this.nom, this.prenom,  this.birthdate,this.adresse,this.tel );
        if(success)
        {
            return "index.xhtml" ;
        }
        this.etat = "Ce compte existe deja" ;
        return null ;
    }
    public List<BookmakerBean> getListBookmaker()
    {
        return this.bookmaker.getListBookmaker() ;
    }

    public String connection()
    {
        BookmakerBean a = this.bookmaker.connect(this.email,this.mdp) ;

        if(a != null )
        {
            return "profilBookmaker.xhtml";
        }
        else
        {
            this.etat = "Email ou mot de passe incorrecte" ;
        }
        return null ;
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
