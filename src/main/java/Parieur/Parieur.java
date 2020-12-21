package Parieur;

import Bookmaker.BookmakerBean;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface Parieur {

    public void addParieur(String email,String mdp,  String nom,String prenom, String date, String addr);
    public void updateParieur() ;
    public void deleteParieur(String email);
    public List<ParieurBean> getListParieur();
    public ParieurBean connect(String email, String mdp) ;

}
