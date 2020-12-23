package Cote;

import Bookmaker.BookmakerBean;
import Confrontation.ConfrontationBean;
import Equipe.EquipeBean;
import Pari.PariBean;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="allCote", query="select b from CoteBean b")
public class CoteBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float multiplicateur ;
    private String etat ;
    @ManyToOne(cascade = CascadeType.ALL)
    private EquipeBean gagnant ;

    private Integer scoreE1 ;
    private Integer scoreE2 ;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PariBean> listPariAssocie ;
    @ManyToOne(cascade = CascadeType.ALL)
    private BookmakerBean createur ;
    @ManyToOne(cascade = CascadeType.ALL)
    private ConfrontationBean matchConcerne ;

    public CoteBean(EquipeBean gagnant,float multi,  Integer s1,Integer s2, BookmakerBean createur, ConfrontationBean c1)
    {
        this.etat = "OUVERT" ;
        this.multiplicateur = multi ;
        this.createur = createur ;
        this.matchConcerne = c1 ;
        this.gagnant = gagnant ;
        if(s1 != null && s2 != null) {
            if (s1 < s2) {
                this.gagnant = c1.getE1();
            } else if (s1 == s2) {
                this.gagnant = null;
            } else {
                this.gagnant = c1.getE2();
            }
            this.scoreE1 = s1 ;
            this.scoreE2 = s2 ;
        }
        else
        {
            this.scoreE1 = null ;
            this.scoreE2 = null ;
        }
    }

    public CoteBean()
    {

    }
}
