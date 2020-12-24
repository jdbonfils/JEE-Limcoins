package Equipe;

import javax.ejb.EJB;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class EquipeManagedBean implements Serializable {

    @EJB
    private Equipe equipe ;

    private String nom ;
    private String villeAssocie ;
    private int rep ;
    private int nbJoueur ;
    private List<EquipeBean> listEquipe ;
    private List<JoueurBean> listJoueur ;
    public void addEquipe()
    {
        List<JoueurBean> listeJoueur = new ArrayList() ;
        for(int i = 0 ; i != this.nbJoueur ; i++)
        {
            listeJoueur.add(new JoueurBean(true)) ;
        }
        this.equipe.addEquipe(this.nom,this.villeAssocie,this.rep,listeJoueur);
    }

    public String details(int id)
    {
        this.nom = listEquipe.get(3).getNom() ;
        this.listJoueur = listEquipe.get(3).getMembres() ;
        return "equipeDetails.xhtml" ;
    }
    public List<EquipeBean> getListEquipe()
    {
        this.listEquipe = this.equipe.getListEquipe() ;
        return this.listEquipe ;
    }
    public String getNom() {
        return nom;
    }



    public List<JoueurBean> getListJoueur() {
        return listJoueur;
    }

    public void setListJoueur(List<JoueurBean> listJoueur) {
        this.listJoueur = listJoueur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVilleAssocie() {
        return villeAssocie;
    }

    public void setVilleAssocie(String VilleAssocie) {
        this.villeAssocie = VilleAssocie;
    }

    public void setListEquipe(List<EquipeBean> listEquipe) {
        this.listEquipe = listEquipe;
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
