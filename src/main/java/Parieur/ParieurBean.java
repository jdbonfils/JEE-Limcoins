package Parieur;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name="allParieur", query="select p from ParieurBean p")
public class ParieurBean extends Personne.Personne implements Serializable {




    public ParieurBean(String nom,String prenom, String date, String addr)
    {
        this.setNom(nom);
        this.setPrenom(prenom) ;
        this.setBirthDate(date);
        this.setAdresse(addr);
    }
    public ParieurBean() {

    }


}
