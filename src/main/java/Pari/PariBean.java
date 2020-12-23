package Pari;

import Bookmaker.BookmakerBean;
import Cote.CoteBean;
import Parieur.ParieurBean;

import javax.persistence.*;

@Entity
@NamedQuery(name="allParis", query="select b from CoteBean b")
public class PariBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private float limCoinMise ;
    private String etat ;

    @ManyToOne(cascade = CascadeType.ALL)
    private ParieurBean parieur ;

    @ManyToOne(cascade = CascadeType.ALL)
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
