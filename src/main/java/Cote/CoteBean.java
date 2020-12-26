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
    private String etat ;
    private Integer scoreE1 ;
    private Integer scoreE2 ;
    @ManyToOne(fetch=FetchType.EAGER)
    private EquipeBean gagnant ;

    @OneToMany(fetch=FetchType.EAGER)
    private List<PariBean> listPariAssocie ;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "bookmakerbean_mail")
    private BookmakerBean createur ;
    @ManyToOne(fetch=FetchType.EAGER)
    private ConfrontationBean matchConcerne ;

    public CoteBean( float multi, EquipeBean gagnant, BookmakerBean createur, ConfrontationBean c1)
    {
        this.etat = "OUVERT" ;
        this.multiplicateur = multi ;
        this.createur = createur ;
        this.matchConcerne = c1 ;
        this.gagnant = gagnant ;
        this.scoreE1 = null ;
        this.scoreE2 = null ;

    }
    public CoteBean( float multi,EquipeBean gagnant, Integer s1, Integer s2, BookmakerBean createur, ConfrontationBean c1)
    {
        this.etat = "OUVERT" ;
        this.multiplicateur = multi ;
        this.createur = createur ;
        this.matchConcerne = c1 ;
        this.gagnant = gagnant ;
        this.scoreE1 = s1 ;
        this.scoreE2 = s2 ;

    }
    public CoteBean()
    {
    }

    public float calcGain()
    {
        float gain = 0 ;
        for(PariBean p : this.getListPariAssocie())
        {
            if(this.matchConcerne.getGagnant().getId().equals(this.getGagnant().getId()))
                gain += p.getLimCoinMise() * this.multiplicateur ;
            else
                gain -= p.getLimCoinMise() * this.multiplicateur ;
        }
        return gain ;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public EquipeBean getGagnant() {
        return gagnant;
    }

    public void setGagnant(EquipeBean gagnant) {
        this.gagnant = gagnant;
    }

    public Integer getScoreE1() {
        return scoreE1;
    }

    public void setScoreE1(Integer scoreE1) {
        this.scoreE1 = scoreE1;
    }

    public Integer getScoreE2() {
        return scoreE2;
    }

    public void setScoreE2(Integer scoreE2) {
        this.scoreE2 = scoreE2;
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
