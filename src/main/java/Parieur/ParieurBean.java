package Parieur;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name="allParieur", query="select p from ParieurBean p")
public class ParieurBean extends Personne.Personne implements Serializable {

    protected float limcoinsPossede ;
    protected String birthDate ;

    public ParieurBean(String email,String mdp, String nom,String prenom, String date, String addr)
    {
        this.setEmail(email) ;
        this.setMdp(mdp);
        this.setNom(nom);
        this.setPrenom(prenom) ;
        this.setBirthDate(date);
        this.setAdresse(addr);
    }
    public ParieurBean() {
    }

    public void setLimcoinsPossede(float limcoinsPossede) {
        this.limcoinsPossede = limcoinsPossede;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public float getLimcoinsPossede() {
        return limcoinsPossede;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
