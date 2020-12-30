package Bookmaker;

import Cote.CoteBean;
import Pari.PariBean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name="allBookmaker", query="select b from BookmakerBean b")
public class BookmakerBean extends Personne.Personne implements Serializable {


    protected String birthDate ;
    protected String tel ;

    @OneToMany(fetch= FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<CoteBean> listCoteEffectue ;

    public BookmakerBean(String mail,String mdp, String nom, String prenom, String date, String addr,String tel)
    {
        this.setEmail(mail) ;
        this.setMdp(mdp);
        this.setNom(nom);
        this.setPrenom(prenom) ;
        this.setBirthDate(date);
        this.setAdresse(addr);
        this.setTel(tel);
        this.setLimcoinsPossede(1000);
        this.listCoteEffectue = new ArrayList<>();

    }
    public BookmakerBean() {
    }



    public List<CoteBean> getListCoteEffectue() {
        return listCoteEffectue;
    }

    public void setListCoteEffectue(List<CoteBean> listCoteEffectue) {
        this.listCoteEffectue = listCoteEffectue;
    }



    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    public String getBirthDate() {
        return birthDate;
    }


}
