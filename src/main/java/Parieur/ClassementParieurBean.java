package Parieur;

import Bookmaker.Bookmaker;
import Personne.Personne;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Comparator;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class ClassementParieurBean {

    @EJB
    private Parieur parieur ;

    private List<ParieurBean> parieurList ;
    protected Personne personneConnecte ;

    public void onLoad()
    {
        this.parieurList = this.parieur.getListParieur() ;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Connected",  "Vous êtes connecté en tant que : "+ this.getPersonneConnecte().getPrenom() +" "+this.getPersonneConnecte().getNom())) ;
    }
    public List<ParieurBean>getClassement(int mode)
    {
        if(this.parieurList != null) {
            if (mode == 1) {
                this.parieurList.sort(new Comparator<ParieurBean>() {
                    public int compare(ParieurBean s1, ParieurBean s2) {
                        return Float.compare(s1.getLimcoinsPossede(), s2.getLimcoinsPossede());
                    }
                });
            }
            return this.parieurList;
        }
        return null ;
    }

    public List<ParieurBean> getParieurList() {
        return parieurList;
    }

    public void setParieurList(List<ParieurBean> parieurList) {
        this.parieurList = parieurList;
    }

    public Personne getPersonneConnecte() {
        return personneConnecte;
    }

    public void setPersonneConnecte(Personne personneConnecte) {
        this.personneConnecte = personneConnecte;
    }
}
