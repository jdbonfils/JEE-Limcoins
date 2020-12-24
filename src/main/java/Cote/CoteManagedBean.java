package Cote;

import Bookmaker.BookmakerBean;
import Confrontation.ConfrontationBean;
import Equipe.*;

import javax.ejb.EJB;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.primefaces.component.datatable.DataTableBase.PropertyKeys.summary;

@ManagedBean
@ApplicationScoped
public class CoteManagedBean implements Serializable {
    @EJB
    private Cote cote ;

    private ConfrontationBean match ;
    private BookmakerBean bookmaker ;
    private Integer idGagnant ;
    private float multiplicateur ;
    private int score1 ;
    private int score2 ;
    private CoteBean coteSelected ;

    public void creerCote()
    {

        if(idGagnant == -0)
        {
            this.cote.addCote(this.multiplicateur,null ,this.bookmaker,this.match);
        }
        else if(this.idGagnant == 1)
        {
            this.cote.addCote(this.multiplicateur,this.getMatch().getE1() ,this.bookmaker,this.match);
        }
        else if(this.idGagnant == 2)
        {
            this.cote.addCote(this.multiplicateur,this.getMatch().getE2() ,this.bookmaker,this.match);
        }

    }

    public List<CoteBean> getCoteByMatch()
    {
        List<CoteBean> listeCoteMatch =  new ArrayList<>() ;
        List<CoteBean> listCote = this.cote.getListCote() ;
        for(CoteBean c : listCote)
        {
            if(c.getMatchConcerne().getId().equals(this.getMatch().getId()))
            {
                listeCoteMatch.add(c) ;
            }
        }
       return listeCoteMatch ;
    }
    public String detailsCote(long id)
    {

        this.coteSelected = this.cote.getCoteWithId(id) ;
        return "detailsCote.xhtml" ;
    }
    public boolean isBookmaker()
    {
        return !(Math.random() < 0.5);
    }
    //Getters and setters


    public CoteBean getCoteSelected() {
        return coteSelected;
    }

    public void setCoteSelected(CoteBean coteSelected) {
        this.coteSelected = coteSelected;
    }

    public float getMultiplicateur() {
        return multiplicateur;
    }

    public void setMultiplicateur(float multiplicateur) {
        this.multiplicateur = multiplicateur;
    }

    public ConfrontationBean getMatch() {
        return this.match;
    }

    public void setMatch(ConfrontationBean match) {
        this.match = match;
    }

    public BookmakerBean getBookmaker() {
        return bookmaker;
    }

    public void setBookmaker(BookmakerBean bookmaker) {
        this.bookmaker = bookmaker;
    }

    public Integer getIdGagnant() {
        return idGagnant;
    }

    public void setIdGagnant(Integer idGagnant) {
        this.idGagnant = idGagnant;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }
}
