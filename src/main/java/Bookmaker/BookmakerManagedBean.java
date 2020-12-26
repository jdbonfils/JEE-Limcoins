package Bookmaker;

import Administrateur.AdministrateurBean;
import Confrontation.ConfrontationManagedBean;
import Cote.CoteBean;
import Pari.PariBean;
import Parieur.Parieur;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.IOException;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class BookmakerManagedBean {

    @EJB
    private Bookmaker bookmaker ;



    @ManagedProperty("#{confrontationManagedBean}")
    private ConfrontationManagedBean matchBean ;
    @ManagedProperty("#{classementBookmakerBean}")
    private ClassementBookmakerBean classementBookmaker ;

    private String nom ;
    private String prenom ;
    private String birthdate ;
    private String adresse ;
    private String tel ;
    private String email;
    private String mdp ;
    private String etat ;
    private BookmakerBean profilBookmaker ;
    private List<CoteBean> cotesList ;


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
        this.profilBookmaker = this.bookmaker.connect(this.email,this.mdp) ;
        BookmakerBean a = this.profilBookmaker ;

        if(a != null )
        {
            classementBookmaker.setPersonneConnecte(a) ;
            matchBean.setPersonneConnecte(a) ;
            return "listMatch.xhtml";
        }
        else
        {
            this.etat = "Email ou mot de passe incorrecte" ;
        }
        return null ;
    }
    public String LimToDollar(float val) throws IOException {
        return ClientRest.currency.getLimcoinCurrency("DOL",val)+""  ;
    }
    public String LimToEuro(float val) throws IOException {
        return ClientRest.currency.getLimcoinCurrency("EUR",val)+""  ;
    }
    public void onLoad()
    {
        this.cotesList = this.bookmaker.getCote(this.profilBookmaker.getEmail()) ;
    }
    public float calcGain(CoteBean cote)
    {
        if(cote.getEtat().equals("TERMINE"))
            return cote.calcGain() ;
        return 0 ;

    }

    public ClassementBookmakerBean getClassementBookmaker() {
        return classementBookmaker;
    }

    public void setClassementBookmaker(ClassementBookmakerBean classementBookmaker) {
        this.classementBookmaker = classementBookmaker;
    }


    public List<CoteBean> getCotesList() {
        return cotesList;
    }

    public void setCotesList(List<CoteBean> cotesList) {
        this.cotesList = cotesList;
    }

    public BookmakerBean getProfilBookmaker() {
        return profilBookmaker;
    }

    public void setProfilBookmaker(BookmakerBean profilBookmaker) {
        this.profilBookmaker = profilBookmaker;
    }

    public ConfrontationManagedBean getMatchBean() {
        return matchBean;
    }

    public void setMatchBean(ConfrontationManagedBean matchBean) {
        this.matchBean = matchBean;
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
