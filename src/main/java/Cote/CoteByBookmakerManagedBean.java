package Cote;



import Bookmaker.Bookmaker;
import Bookmaker.BookmakerBean;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class CoteByBookmakerManagedBean {

    @EJB
    private Bookmaker bookmaker ;

    private BookmakerBean creePar ;
    private List<CoteBean> listCote ;

    public void onLoad()
    {
        this.listCote = this.bookmaker.getCote(this.creePar.getEmail()) ;
        System.out.println("Creer par"+ this.creePar.getEmail());
        System.out.println(this.listCote.size()+"Taille ");
    }
    public BookmakerBean getCreePar() {
        return creePar;
    }

    public void setCreePar(BookmakerBean creePar) {
        this.creePar = creePar;
    }

    public List<CoteBean> getListCote() {
        return listCote;
    }

    public void setListCote(List<CoteBean> listCote) {
        this.listCote = listCote;
    }
}
