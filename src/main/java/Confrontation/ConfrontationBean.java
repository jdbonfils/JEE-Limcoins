package Confrontation;


import Cote.CoteBean;
import Equipe.EquipeBean;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name="allMatch", query="select b from ConfrontationBean b")
public class ConfrontationBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected String nom;
    protected String lieu;

    protected Date date;

    protected int minutes;

    @ManyToOne(fetch=FetchType.EAGER)
    protected EquipeBean e1;

    @ManyToOne(fetch=FetchType.EAGER)
    protected EquipeBean e2 ;

    @OneToMany(fetch=FetchType.EAGER)
    protected List<CoteBean> listeCote ;


    public ConfrontationBean(String nom, String lieu, Date date, int minutes, EquipeBean e1, EquipeBean e2)
    {
        if(nom == null)
            this.nom = e1.getNom()+e2.getNom() + date.toString() ;
        else
            this.nom = nom ;
       this.lieu = lieu ;
       this.date = date ;
       this.minutes = minutes ;
       this.e1 = e1 ;
       this.e2 = e2 ;
       this.listeCote = new ArrayList<>() ;
    }
    public ConfrontationBean() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
