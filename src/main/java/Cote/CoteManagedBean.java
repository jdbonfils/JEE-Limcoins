package Cote;

import Bookmaker.Bookmaker;
import Bookmaker.BookmakerBean;
import Confrontation.ConfrontationBean;
import Equipe.*;
import Pari.PariManagedBean;
import Personne.PersonneCoManagedBean;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.ejb.EJB;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.PhaseId;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.primefaces.component.datatable.DataTableBase.PropertyKeys.summary;

@ManagedBean
@ApplicationScoped
public class CoteManagedBean implements Serializable {
    @EJB
    private Cote cote ;

    @ManagedProperty("#{pariManagedBean}")
    private PariManagedBean pariBean ;

    @ManagedProperty("#{personneCoManagedBean}")
    private PersonneCoManagedBean personneCo ;


    private ConfrontationBean match ;
    private BookmakerBean bookmaker ;
    private Integer idGagnant ;
    private float multiplicateur ;
    private int score1 ;
    private int score2 ;
    private float mise ;
    private CoteBean coteSelected ;
    private StreamedContent image;



    public void onLoad() throws IOException {
        if(!personneCo.isConnecte())
        {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/" +"index.xhtml");
        }


        /*this.image = DefaultStreamedContent.builder()
            .contentType("image/jpeg")
            .stream(() -> this.getClass().getResourceAsStream("../images/joueur1.jpeg"))
            .build();
        System.out.println(image.getContentType()) ;*/
    }

    public void creerCote()
    {
        if(idGagnant == 0)
        {

            this.cote.addCote(this.multiplicateur,null ,(BookmakerBean) this.personneCo.getPersonneCo(),this.match);
        }
        else if(this.idGagnant == 1)
        {

            this.cote.addCote(this.multiplicateur,this.getMatch().getE1() ,(BookmakerBean) this.personneCo.getPersonneCo(),this.match);
        }
        else if(this.idGagnant == 2)
        {
            this.cote.addCote(this.multiplicateur,this.getMatch().getE2() ,(BookmakerBean) this.personneCo.getPersonneCo(),this.match);
        }
    }
    public StreamedContent getImage()
    {
            return this.image;
    }

    public void setImage(StreamedContent image) {
        this.image = image;
    }

    public List<CoteBean> getCoteByMatch()
    {
        List<CoteBean> listeCoteMatch =  new ArrayList<>() ;
        List<CoteBean> listCote = this.cote.getListCote() ;

            for (CoteBean c : listCote) {
                if(c.getMatchConcerne() != null) {
                    if (c.getMatchConcerne().getId().equals(this.getMatch().getId())) {
                        listeCoteMatch.add(c);
                    }
                }
            }

       return listeCoteMatch ;
    }
    public String detailsCote(long id)
    {
        pariBean.setCoteConcerne(this.cote.getCoteWithId(id));
        return "detailsCote.xhtml" ;
    }
    public void home() throws IOException {

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/" +"listMatch.xhtml");
    }
    //Getters and setters


    public boolean getIsbookmaker() {
        return personneCo.isBookmaker() ;
    }

    public PersonneCoManagedBean getPersonneCo() {
        return personneCo;
    }

    public void setPersonneCo(PersonneCoManagedBean personneCo) {
        this.personneCo = personneCo;
    }

    public PariManagedBean getPariBean() {
        return pariBean;
    }

    public void setPariBean(PariManagedBean pariBean) {
        this.pariBean = pariBean;
    }

    public float getMise() {
        return mise;
    }

    public void setMise(float mise) {
        this.mise = mise;
    }

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

    public String getDate(long m) {
        return outils.outils.getDate(new Date(m)) ;
    }

    public Boolean isBookmaker() {
        if( this.personneCo.isBookmaker())
        {
            return true ;
        }
        else
        {
            return false ;
        }
    }
}
