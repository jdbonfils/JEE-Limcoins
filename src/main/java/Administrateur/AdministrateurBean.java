package Administrateur;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

@Entity
@NamedQuery(name="allAdmins", query="select b from AdministrateurBean b")
public class AdministrateurBean extends Personne.Personne implements Serializable {

    protected String tel ;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public AdministrateurBean(String mail,String mdp, String nom, String prenom, String addr, String tel){
        this.setEmail(mail) ;
        this.setMdp(mdp);
        this.setNom(nom);
        this.setPrenom(prenom) ;
        this.setTel(tel);
        this.setAdresse(addr);

    }
    public AdministrateurBean() {
    }
}
