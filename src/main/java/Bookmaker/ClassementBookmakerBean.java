package Bookmaker;

import Cote.CoteBean;
import Personne.Personne;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
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

    public void onLoad()
    {
        this.bookmakersList = this.bookmaker.getListBookmaker() ;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Connected",  "Vous êtes connecté en tant que : "+ this.getPersonneConnecte().getPrenom() +" "+this.getPersonneConnecte().getNom())) ;
    }
    public List<BookmakerBean>getClassement(int mode)
    {
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
