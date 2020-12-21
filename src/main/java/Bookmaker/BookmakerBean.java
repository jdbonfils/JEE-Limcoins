package Bookmaker;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@NamedQuery(name="allBookmaker", query="select b from BookmakerBean b")
public class BookmakerBean extends Personne.Personne implements Serializable {

    protected float limcoinsPossede ;
    protected String birthDate ;
    protected String tel ;


    public BookmakerBean(String nom, String prenom, String date, String addr,String tel)
    {
        this.setNom(nom);
        this.setPrenom(prenom) ;
        this.setBirthDate(date);
        this.setAdresse(addr);
        this.setTel(tel);
    }
    public BookmakerBean() {
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
