package Equipe;

import Confrontation.Confrontation;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class EquipeManagedBean {

    @EJB
    private Equipe equipe ;

    private String nom ;
    private String lieu ;
    private int rep ;
    private int nbJoueur ;

    public void addEquipe()
    {
        List<Joueur> listeJoueur = new ArrayList() ;
        for(int i = 0 ; i != this.nbJoueur ; i++)
        {
            listeJoueur.add(new Joueur(true)) ;
        }
        this.equipe.addEquipe(this.nom,this.lieu,this.rep,listeJoueur);
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public int getNbJoueur() {
        return nbJoueur;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }
}
