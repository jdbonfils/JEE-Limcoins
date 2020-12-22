package Confrontation;


import Equipe.EquipeBean;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.Date;

@ManagedBean
@ApplicationScoped
public class ConfrontationManagedBean {

    @EJB
    private Confrontation confrontation ;

    protected String nom;
    protected String lieu;
    protected Date date;
    protected int minutes;
    protected EquipeBean e1;
    protected EquipeBean e2 ;

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
}
