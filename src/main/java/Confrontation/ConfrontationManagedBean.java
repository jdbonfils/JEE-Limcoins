package Confrontation;


import Cote.CoteManagedBean;
import Equipe.Equipe;
import Equipe.EquipeBean;

import javax.ejb.EJB;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import java.sql.Date;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class ConfrontationManagedBean {

    @EJB
    private Confrontation confrontation ;

    @EJB
    private Equipe equipe ;

    @ManagedProperty("#{coteManagedBean}")
    private CoteManagedBean coteBean;

    protected String nom;
    protected String lieu;
    protected String date;
    protected int minutes;
    protected long e1id;
    protected long e2id ;
    protected List<ConfrontationBean> listMatch ;

    public void addMatch()
    {

        Date d = new Date(1232132) ;
        EquipeBean e1 = this.equipe.getEquipe(this.e1id) ;
        EquipeBean e2 = this.equipe.getEquipe(this.e2id) ;

        System.out.print("issoususouosuosuou");
        this.confrontation.addConfrontation(this.nom,this.lieu,d,this.minutes,e1,e2);

    }
    public String newCote(long id )
    {
        for(ConfrontationBean c : this.listMatch)
        {
            if(c.getId() == id)
            {
                coteBean.setMatch(c);
            }
        }
        return "newCote.xhtml" ;
    }
    public List<ConfrontationBean> getListMatch()
    {
        this.listMatch = this.confrontation.getListConfrontation() ;
        return this.listMatch ;
    }

    //Getters et Setters

    public void setListMatch(List<ConfrontationBean> listMatch) {
        this.listMatch = listMatch;
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

    public CoteManagedBean getCoteBean() {
        return coteBean;
    }

    public void setCoteBean(CoteManagedBean coteBean) {
        this.coteBean = coteBean;
    }
}
