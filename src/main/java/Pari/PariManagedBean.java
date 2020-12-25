package Pari;



import Cote.CoteBean;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.text.DecimalFormat;

@ManagedBean
@ApplicationScoped
public class PariManagedBean implements Serializable {

    @EJB
    private Pari pari ;

    private CoteBean coteConcerne ;
    private float mise ;

    public String gain()
    {
        float gain =  this.mise * this.coteConcerne.getMultiplicateur() ;
        return "Gain/ Perte : "+ (new DecimalFormat("#.##")).format(gain) +" Limcoins"  ;
    }
    public void creerPari()
    {
        this.pari.addPari(this.mise,null,this.coteConcerne);
    }
    public float getMise() {
        return mise;
    }

    public void setMise(float mise) {
        this.mise = mise;
    }

    public CoteBean getCoteConcerne() {
        return coteConcerne;
    }

    public void setCoteConcerne(CoteBean coteConcerne) {
        this.coteConcerne = coteConcerne;
    }
}
