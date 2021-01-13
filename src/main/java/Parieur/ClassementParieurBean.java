package Parieur;

import Bookmaker.Bookmaker;
import Personne.Personne;
import Personne.PersonneCoManagedBean;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class ClassementParieurBean {

    @EJB
    private Parieur parieur ;

    @ManagedProperty("#{personneCoManagedBean}")
    private PersonneCoManagedBean personneCo ;

    private List<ParieurBean> parieurList ;


    public void onLoad() throws IOException {
        if (!personneCo.isConnecte()) {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/" + "index.xhtml");
        } else {


            this.parieurList = this.parieur.getListParieur();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Connected", "Vous êtes connecté en tant que : " + this.getPersonneCo().getPersonneCo().getPrenom() + " " + this.getPersonneCo().getPersonneCo().getNom()));
        }
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

    public void home() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/" +"listMatch.xhtml");
    }

    public List<ParieurBean> getParieurList() {
        return parieurList;
    }

    public void setParieurList(List<ParieurBean> parieurList) {
        this.parieurList = parieurList;
    }


    public PersonneCoManagedBean getPersonneCo() {
        return personneCo;
    }

    public void setPersonneCo(PersonneCoManagedBean personneCo) {
        this.personneCo = personneCo;
    }
}
