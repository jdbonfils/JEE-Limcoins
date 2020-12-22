package Equipe;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name="allEquipe", query="select b from EquipeBean b")
public class EquipeBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    public String nom ;
    public String villeAssocie ;
    public int reputation ;

    @OneToMany(cascade = CascadeType.ALL)
    public List<JoueurBean> membres ;

    public EquipeBean(String nom, String villeAssocie, int reputation, List<JoueurBean> membres) {
        this.nom = nom;
        this.villeAssocie = villeAssocie;
        this.reputation = reputation;
        this.membres = membres;
    }

    public EquipeBean() {

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVilleAssocie() {
        return villeAssocie;
    }

    public void setVilleAssocie(String villeAssocie) {
        this.villeAssocie = villeAssocie;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public List<JoueurBean> getMembres() {
        return membres;
    }

    public void setMembres(List<JoueurBean> membres) {
        this.membres = membres;
    }
}
