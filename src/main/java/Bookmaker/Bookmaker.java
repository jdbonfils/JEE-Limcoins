package Bookmaker;

import Administrateur.AdministrateurBean;
import Parieur.ParieurBean;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface Bookmaker {
    public boolean addBookmaker(String email,String mdp  ,  String nom,String prenom, String date, String addr,String tel);
    public void updateBookmaker() ;
    public void deleteBookmaker(String email);
    public List<BookmakerBean> getListBookmaker();
    public BookmakerBean connect(String email, String mdp) ;

}
