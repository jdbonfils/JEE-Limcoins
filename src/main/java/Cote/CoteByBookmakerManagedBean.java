package Cote;



import Bookmaker.Bookmaker;
import Bookmaker.BookmakerBean;
import Personne.PersonneCoManagedBean;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class CoteByBookmakerManagedBean {

    @EJB
    private Bookmaker bookmaker ;

    @ManagedProperty("#{personneCoManagedBean}")
    private PersonneCoManagedBean personneCo ;

    private BookmakerBean creePar ;
    private List<CoteBean> listCote ;

    public void onLoad() throws IOException {
        if(!personneCo.isConnecte())
        {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/" +"index.xhtml");
        }
        else {
            this.listCote = this.bookmaker.getCote(this.creePar.getEmail());
            System.out.println("Creer par" + this.creePar.getEmail());
            System.out.println(this.listCote.size() + "Taille ");
        }
    }

    public void home() throws IOException {

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/" +"listMatch.xhtml");
    }

    public BookmakerBean getCreePar() {
        return creePar;
    }

    public void setCreePar(BookmakerBean creePar) {
        this.creePar = creePar;
    }

    public List<CoteBean> getListCote() {
        return listCote;
    }

    public void setListCote(List<CoteBean> listCote) {
        this.listCote = listCote;
    }

    public PersonneCoManagedBean getPersonneCo() {
        return personneCo;
    }

    public void setPersonneCo(PersonneCoManagedBean personneCo) {
        this.personneCo = personneCo;
    }
}
