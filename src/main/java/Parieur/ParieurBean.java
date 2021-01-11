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
    @OneToMany(fetch= FetchType.EAGER,cascade = CascadeType.MERGE)
    private List<PariBean> listPariEffectue ;
    private int nbParisGagne ;


    public ParieurBean(String email,String mdp, String nom,String prenom, String date, String addr,int nbParisGagne)
    {
        this.setEmail(email) ;
        this.setMdp(mdp);
        this.setNom(nom);
        this.setPrenom(prenom) ;
        this.setBirthDate(date);
        this.setAdresse(addr);
        this.listPariEffectue = new ArrayList<>() ;
        this.setLimcoinsPossede(1000);
        this.setNbParisGagne(nbParisGagne);
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

    public int getNbParisGagne() {
        return nbParisGagne;
    }

    public void setNbParisGagne(int nbParisGagne) {
        this.nbParisGagne = nbParisGagne;
    }
    public void incNbParisGagne()
    {
        this.nbParisGagne ++ ;
    }
    public void decNbParisGagne()
    {
        this.nbParisGagne -- ;
    }


}
