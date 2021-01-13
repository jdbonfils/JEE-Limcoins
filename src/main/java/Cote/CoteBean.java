package Cote;

import Bookmaker.BookmakerBean;
import Confrontation.ConfrontationBean;
import Equipe.EquipeBean;
import Pari.PariBean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name="allCote", query="select b from CoteBean b")
public class CoteBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float multiplicateur ;

    @ManyToOne(fetch=FetchType.EAGER)
    private EquipeBean gagnant ;

    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.MERGE)
    private List<PariBean> listPariAssocie ;

    @ManyToOne(fetch=FetchType.EAGER,  cascade = CascadeType.MERGE)
    private BookmakerBean createur ;

    @ManyToOne(fetch=FetchType.EAGER)
    private ConfrontationBean matchConcerne ;

    public CoteBean( float multi, EquipeBean gagnant, BookmakerBean createur, ConfrontationBean c1)
    {
        this.multiplicateur = multi ;
        this.createur = createur ;
        this.matchConcerne = c1 ;
        this.gagnant = gagnant ;
    }
    public CoteBean( float multi,EquipeBean gagnant, Integer s1, Integer s2, BookmakerBean createur, ConfrontationBean c1)
    {
        this.multiplicateur = multi ;
        this.createur = createur ;
        this.matchConcerne = c1 ;
        this.gagnant = gagnant ;
    }
    public CoteBean()
    {
    }


    //Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getMultiplicateur() {
        return multiplicateur;
    }

    public void setMultiplicateur(float multiplicateur) {
        this.multiplicateur = multiplicateur;
    }


    public EquipeBean getGagnant() {
        return gagnant;
    }

    public void setGagnant(EquipeBean gagnant) {
        this.gagnant = gagnant;
    }


    public List<PariBean> getListPariAssocie() {
        return listPariAssocie;
    }

    public void setListPariAssocie(List<PariBean> listPariAssocie) {
        this.listPariAssocie = listPariAssocie;
    }

    public BookmakerBean getCreateur() {
        return createur;
    }

    public void setCreateur(BookmakerBean createur) {
        this.createur = createur;
    }

    public ConfrontationBean getMatchConcerne() {
        return matchConcerne;
    }

    public void setMatchConcerne(ConfrontationBean matchConcerne) {
        this.matchConcerne = matchConcerne;
    }
}
