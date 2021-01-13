package Personne;

import Bookmaker.BookmakerBean;
import Parieur.ParieurBean;


import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
@ApplicationScoped
public class PersonneCoManagedBean implements Serializable {

    private Personne personneCo ;


    public boolean isConnecte()
    {
        return personneCo != null;
    }
    public boolean isBookmaker()
    {
        return personneCo instanceof BookmakerBean;
    }
    public boolean isParieur()
    {
        return personneCo instanceof ParieurBean;
    }
    public void setDeconexion()
    {
        this.personneCo = null ;
    }

    //Getters et Setters

    public Personne getPersonneCo() {
        return personneCo;
    }
    public void setPersonneCo(Personne personneCo) {
        this.personneCo = personneCo;
    }

}
