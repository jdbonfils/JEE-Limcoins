package Confrontation;


import Cote.CoteBean;
import Equipe.EquipeBean;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Entity
@NamedQuery(name="allMatch", query="select b from ConfrontationBean b")
public class ConfrontationBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected String nom;
    protected String lieu;
    protected Boolean termine ;
    protected long date;

    protected int minutes;

    @ManyToOne(fetch=FetchType.EAGER)
    protected EquipeBean e1;

    private int ScoreE1 ;
    private int ScoreE2 ;

    @ManyToOne(fetch=FetchType.EAGER)
    protected EquipeBean e2 ;

    @ManyToOne(fetch=FetchType.EAGER)
    protected EquipeBean gagnant ;

    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.MERGE)
    protected List<CoteBean> listeCote ;


    public ConfrontationBean(String nom, String lieu, long date, int minutes, EquipeBean e1, EquipeBean e2)
    {
        if(nom == null)
            this.nom = e1.getNom()+e2.getNom() + (new Date(TimeUnit.SECONDS.toMillis(date)).getDay()) ;
        else
            this.nom = nom ;
       this.lieu = lieu ;
       this.date = date ;
       this.minutes = minutes ;
       this.e1 = e1 ;
       this.e2 = e2 ;
       this.listeCote = new ArrayList<>() ;
       this.gagnant = null ;
       this.termine = false ;
    }
    public ConfrontationBean() {
    }

    public EquipeBean getGagnant() {
        return gagnant;
    }

    public void setGagnant(EquipeBean gagnant) {
        this.gagnant = gagnant;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public EquipeBean getE1() {
        return e1;
    }

    public void setE1(EquipeBean e1) {
        this.e1 = e1;
    }

    public EquipeBean getE2() {
        return e2;
    }

    public void setE2(EquipeBean e2) {
        this.e2 = e2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CoteBean> getListeCote() {
        return listeCote;
    }

    public void setListeCote(List<CoteBean> listeCote) {
        this.listeCote = listeCote;
    }

    public Boolean getTermine() {
        return termine;
    }

    public void setTermine(Boolean termine) {
        this.termine = termine;
    }

    public int getScoreE1() {
        return ScoreE1;
    }

    public void setScoreE1(int scoreE1) {
        ScoreE1 = scoreE1;
    }

    public int getScoreE2() {
        return ScoreE2;
    }

    public void setScoreE2(int scoreE2) {
        ScoreE2 = scoreE2;
    }
}
