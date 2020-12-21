package Bookmaker;

import Parieur.ParieurBean;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface Bookmaker {
    public void addBookmaker(String nom,String prenom, String date, String addr,String tel);
    public void updateBookmaker() ;
    public void deleteBookmaker(int id);
    public List<BookmakerBean> getListBookmaker();
}
