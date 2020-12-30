package Equipe;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

@Entity
public class JoueurBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nom ;
    private String prenom ;
    private int age ;
    private String imageLink ;


    public JoueurBean(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public JoueurBean() {

    }
    public JoueurBean(boolean random){
        if(random)
        {
            Random r = new Random() ;
            this.age = r.nextInt(65 ) + 10;
            this.nom = outils.outils.generateString(r.nextInt(9 ) + 3) ;
            this.prenom = outils.outils.generateString(r.nextInt(9 ) + 3) ;

           // this.imageLink = "../images/joueur"++"jpeg" ;
        }

    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
