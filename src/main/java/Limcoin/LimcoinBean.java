package Limcoin;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class LimcoinBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long date ;
    private float euro ;
    private float dollar ;

    public LimcoinBean(long date,float dollar,float euro) {
        this.date = date ;
        this.euro = euro ;
        this.dollar = dollar ;
    }

    public LimcoinBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public float getEuro() {
        return euro;
    }

    public void setEuro(float euro) {
        this.euro = euro;
    }

    public float getDollar() {
        return dollar;
    }

    public void setDollar(float dollar) {
        this.dollar = dollar;
    }
}
