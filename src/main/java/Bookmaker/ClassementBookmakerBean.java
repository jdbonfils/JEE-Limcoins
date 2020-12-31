package Bookmaker;

import Cote.CoteBean;
import Cote.CoteByBookmakerManagedBean;
import Personne.Personne;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class ClassementBookmakerBean {

    @EJB
    private Bookmaker bookmaker ;

    private List<BookmakerBean> bookmakersList ;
    protected Personne personneConnecte ;

    @ManagedProperty("#{coteByBookmakerManagedBean}")
    private CoteByBookmakerManagedBean coteByBookmakerManagedBean ;

    public void onLoad()
    {
        this.bookmakersList = this.bookmaker.getListBookmaker() ;
        FacesContext context = FacesContext.getCurrentInstance();
        if(personneConnecte != null)
            context.addMessage(null, new FacesMessage("Connected",  "Vous êtes connecté en tant que : "+ this.getPersonneConnecte().getPrenom() +" "+this.getPersonneConnecte().getNom())) ;
    }
    public void voirCote(String email) throws IOException {
        for(BookmakerBean b : this.bookmakersList)
        {

            if(b.getEmail().equals(email))
            {
                coteByBookmakerManagedBean.setCreePar(b);
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect(ec.getRequestContextPath() + "/" +"listCote.xhtml");
            }
        }
    }

    public CoteByBookmakerManagedBean getCoteByBookmakerManagedBean() {
        return coteByBookmakerManagedBean;
    }

    public void setCoteByBookmakerManagedBean(CoteByBookmakerManagedBean coteByBookmakerManagedBean) {
        this.coteByBookmakerManagedBean = coteByBookmakerManagedBean;
    }

    public List<BookmakerBean>getClassement(int mode)
    {
        System.out.println("issou") ;

        System.out.println(this.bookmakersList.size()) ;
        if(mode == 1) {
            this.bookmakersList.sort(new Comparator<BookmakerBean>() {
                public int compare(BookmakerBean s1, BookmakerBean s2) {
                    return Float.compare(s1.getLimcoinsPossede(), s2.getLimcoinsPossede());
                }
            });
        }
        else
        {
            this.bookmakersList.sort(new Comparator<BookmakerBean>() {
                public int compare(BookmakerBean s1, BookmakerBean s2) {
                    return Integer.compare(s2.getListCoteEffectue().size(), s1.getListCoteEffectue().size());
                }
            });
        }
        return this.bookmakersList ;
    }
    public List<BookmakerBean> getBookmakersList() {
        return bookmakersList;
    }
    public void setBookmakersList(List<BookmakerBean> bookmakersList) {
        this.bookmakersList = bookmakersList;
    }

    public Personne getPersonneConnecte() {
        return personneConnecte;
    }

    public void setPersonneConnecte(Personne personneConnecte) {
        this.personneConnecte = personneConnecte;
    }
}
