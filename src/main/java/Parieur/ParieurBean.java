package Parieur;

import Pari.PariBean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name="allParieur", query="select p from ParieurBean p")
public class ParieurBean extends Personne.Personne implements Serializable {


    protected String birthDate ;
    @OneToMany
    private List<PariBean> listPariEffectue ;


    public ParieurBean(String email,String mdp, String nom,String prenom, String date, String addr)
    {
        this.setEmail(email) ;
        this.setMdp(mdp);
        this.setNom(nom);
        this.setPrenom(prenom) ;
        this.setBirthDate(date);
        this.setAdresse(addr);
        this.listPariEffectue = new ArrayList<>() ;
        this.setLimcoinsPossede(1000);
    }
    public ParieurBean() {
    }

    public List<PariBean> getListPariEffectue() {
        return listPariEffectue;
    }

    public void setListPariEffectue(List<PariBean> listPariEffectue) {
        this.listPariEffectue = listPariEffectue;
    }


    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    public String getBirthDate() {
        return birthDate;
    }
}
