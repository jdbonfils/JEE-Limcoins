package Parieur;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface Parieur {

    public void addParieur(String nom,String prenom, String date, String addr);
    public void updateParieur() ;
    public void deleteParieur(int id);
    public List<ParieurBean> getListParieur();

}
