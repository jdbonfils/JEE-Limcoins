package Confrontation;


import Equipe.Equipe;
import Equipe.EquipeBean;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.Date;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class ConfrontationManagedBean {

    @EJB
    private Confrontation confrontation ;

    @EJB
    private Equipe equipe ;

    protected String nom;
    protected String lieu;
    protected String date;
    protected int minutes;
    protected long e1id;
    protected long e2id ;
    public void addMatch()
    {

        Date d = new Date(1232132) ;
        EquipeBean e1 = this.equipe.getEquipe(this.e1id) ;
        EquipeBean e2 = this.equipe.getEquipe(this.e2id) ;

        System.out.print("issoususouosuosuou");
        this.confrontation.addConfrontation(this.nom,this.lieu,d,this.minutes,e1,e2);

    }
    public List<ConfrontationBean> getListMatch()
    {
        return this.confrontation.getListConfrontation() ;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public long getE1id() {
        return e1id;
    }

    public void setE1id(long e1id) {
        this.e1id = e1id;
    }

    public long getE2id() {
        return e2id;
    }

    public void setE2id(long e2id) {
        this.e2id = e2id;
    }
}
