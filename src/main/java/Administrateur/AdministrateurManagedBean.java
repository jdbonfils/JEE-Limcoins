package Administrateur;

import Bookmaker.Bookmaker;
import Bookmaker.BookmakerBean;

import Equipe.Equipe;
import Equipe.EquipeBean;
import Equipe.JoueurBean;
import Parieur.Parieur;
import Parieur.ParieurBean;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.PostLoad;
import java.io.IOException;
import java.io.Serializable;

import java.util.*;

@ManagedBean
@ApplicationScoped
public class AdministrateurManagedBean implements Serializable {

    @EJB
    Administrateur admin ;

    @EJB
    Bookmaker b ;
    @EJB
    Parieur p ;
    @EJB
    Equipe e ;

    private AdministrateurBean adminCo ;

    private String nom ;
    private String prenom ;
    private String adresse ;
    private String tel ;
    private String email;
    private String mdp ;
    private String etat ;

    private String nomEquipe;
    private int rep ;
    private String villeAssocie ;
    private int nbJoueur ;


    private List<BookmakerBean> bookmakerList ;
    private List<ParieurBean> parieurList ;
    private List<EquipeBean> equipeList ;


    public void onLoad() throws IOException {
        nomEquipe = "" ;
        rep = 0 ;
        villeAssocie = "" ;
        nbJoueur = 0 ;
        if(adminCo == null)
        {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/" +"connexionAdmin.xhtml");
        }
        bookmakerList = b.getListBookmaker() ;
        parieurList = p.getListParieur() ;
        equipeList = e.getListEquipe() ;
    }

    public String addEquipe()
    {
        List<JoueurBean> listeJoueur = new ArrayList() ;
        for(int i = 0 ; i != this.nbJoueur ; i++)
        {
            listeJoueur.add(new JoueurBean(true)) ;
        }

        if(this.nomEquipe == "" || this.villeAssocie == "" || this.nomEquipe == null || this.villeAssocie == null)
        {
            FacesContext.getCurrentInstance().addMessage("messagesb", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Informations incorrectes"));
            return null ;
        }
        this.e.addEquipe(this.nomEquipe,this.villeAssocie,this.rep,listeJoueur);
        nomEquipe = "" ;
        rep = 0 ;
        villeAssocie = "" ;
        nbJoueur = 0 ;
        return "admin.xhtml" ;
    }

    public String connection()
    {
        AdministrateurBean a = this.admin.getAdmin(this.email,this.mdp) ;
        email = "" ;
        mdp = "" ;
        if(a != null )
        {
            this.setAdminCo(a);
          return "admin.xhtml";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage("messagesb", new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur", "Connexion refusée"));
        }
        return null ;
    }
    public String back()
    {
        return "admin.xhtml";
    }

    public void addAdministrateur(){
        this.admin.addAdministrateur(this.email,this.mdp, this.nom, this.prenom,this.adresse,this.tel );
    }
    public void supprParieur(String email)
    {
        //context.getExternalContext().getRealPath("") ;
        p.deleteParieur(email);
    }
    public void supprBookmaker(String email)
    {
        b.deleteBookmaker(email);
    }
    public String creerMatch()
    {
        return "newMatch.xhtml";
    }
    public String creerEquipe()
    {
        return "newEquipe.xhtml" ;
    }

    public void deconnexion() throws IOException {
        adminCo = null ;
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/" +"connexionAdmin.xhtml");
    }
    public String getEtat() {
        return etat;
    }
    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public String getVilleAssocie() {
        return villeAssocie;
    }

    public void setVilleAssocie(String villeAssocie) {
        this.villeAssocie = villeAssocie;
    }

    public int getNbJoueur() {
        return nbJoueur;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
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

    public AdministrateurBean getAdminCo() {
        return adminCo;
    }


    public List<BookmakerBean> getBookmakerList() {
        return bookmakerList;
    }

    public void setBookmakerList(List<BookmakerBean> bookmakerList) {
        this.bookmakerList = bookmakerList;
    }

    public List<ParieurBean> getParieurList() {
        return parieurList;
    }

    public void setParieurList(List<ParieurBean> parieurList) {
        this.parieurList = parieurList;
    }

    public List<EquipeBean> getEquipeList() {
        return equipeList;
    }

    public void setEquipeList(List<EquipeBean> equipeList) {
        this.equipeList = equipeList;
    }

    public void setAdminCo(AdministrateurBean adminCo) {
        this.adminCo = adminCo;
    }
}
