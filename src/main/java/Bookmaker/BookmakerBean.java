package Bookmaker;

import Pari.PariBean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name="allBookmaker", query="select b from BookmakerBean b")
public class BookmakerBean extends Personne.Personne implements Serializable {

    protected float limcoinsPossede ;
    protected String birthDate ;
    protected String tel ;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PariBean> listPariEffectue ;

    public BookmakerBean(String mail,String mdp, String nom, String prenom, String date, String addr,String tel)
    {
        this.setEmail(mail) ;
        this.setMdp(mdp);
        this.setNom(nom);
        this.setPrenom(prenom) ;
        this.setBirthDate(date);
        this.setAdresse(addr);
        this.setTel(tel);
        this.limcoinsPossede = 1000 ;
        this.listPariEffectue = new ArrayList<>();

    }
    public BookmakerBean() {
    }

    public List<PariBean> getListPariEffectue() {
        return listPariEffectue;
    }

    public void setListPariEffectue(List<PariBean> listPariEffectue) {
        this.listPariEffectue = listPariEffectue;
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
