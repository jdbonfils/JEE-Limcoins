package Parieur;

import Bookmaker.BookmakerBean;
import Pari.PariBean;

import javax.ejb.Remote;
import java.util.ArrayList;
import java.util.List;

@Remote
public interface Parieur {

    public Boolean addParieur(String email,String mdp,  String nom,String prenom, String date, String addr);
    public void deleteParieur(String email);
    public List<ParieurBean> getListParieur();
    public ParieurBean connect(String email, String mdp) ;
    public List<PariBean> getListParis(String email);

}
