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

    @ManyToOne
    private ParieurBean parieur ;

    @ManyToOne
    private CoteBean coteConcerne ;

    public PariBean(float limcoinmise, ParieurBean parieur, CoteBean cote)
    {
        this.limCoinMise = limcoinmise ;
        this.parieur = parieur ;
        this.coteConcerne = cote;
    }
    public PariBean()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getLimCoinMise() {
        return limCoinMise;
    }

    public void setLimCoinMise(float limCoinMise) {
        this.limCoinMise = limCoinMise;
    }

    public ParieurBean getParieur() {
        return parieur;
    }

    public void setParieur(ParieurBean parieur) {
        this.parieur = parieur;
    }

    public CoteBean getCoteConcerne() {
        return coteConcerne;
    }

    public void setCoteConcerne(CoteBean coteConcerne) {
        this.coteConcerne = coteConcerne;
    }
}
