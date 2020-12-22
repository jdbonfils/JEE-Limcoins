package Equipe;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="allEquipe", query="select b from ConfrontationBean b")
public class EquipeBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String nom ;
    public String villeAssocie ;
    public int reputation ;

    @OneToMany(fetch= FetchType.EAGER, cascade = CascadeType.PERSIST)
    public List<Joueur> membres ;

    public EquipeBean(String nom, String villeAssocie, int reputation, List<Joueur> membres) {
        this.nom = nom;
        this.villeAssocie = villeAssocie;
        this.reputation = reputation;
        this.membres = membres;
    }

    public EquipeBean() {

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

    public List<Joueur> getMembres() {
        return membres;
    }

    public void setMembres(List<Joueur> membres) {
        this.membres = membres;
    }
}
