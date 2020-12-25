package Pari;

import Bookmaker.BookmakerBean;
import Cote.CoteBean;
import Parieur.ParieurBean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name="allParis", query="select b from PariBean b")
public class PariBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private float limCoinMise ;
    private String etat ;

    @ManyToOne
    private ParieurBean parieur ;

    @ManyToOne
    private CoteBean coteConcerne ;

    public PariBean(float limcoinmise, ParieurBean parieur, CoteBean cote)
    {
        this.etat = "EN COURS" ;
        this.limCoinMise = limcoinmise ;
        this.parieur = parieur ;
        this.coteConcerne = cote;
    }
    public PariBean()
    {

    }
}
