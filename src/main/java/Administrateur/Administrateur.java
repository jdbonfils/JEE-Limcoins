package Administrateur;

import Bookmaker.BookmakerBean;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface Administrateur {
    public void addAdministrateur(String eamil,String mdp, String nom,String prenom, String addr,String tel);
    public void updateAdministrateur() ;
    public void deleteAdministrateur(String email);
    public List<AdministrateurBean> getListAdministrateur();
    public AdministrateurBean getAdmin(String email,String mdp);
}
