package Equipe;

import Confrontation.ConfrontationBean;

import java.sql.Date;
import java.util.List;

public interface Equipe {

    public void addEquipe(String nom, String ville, int reo, List<Joueur> membres);
    public void updateEquipe() ;
    public void deleteEquipe(int id);
    public List<EquipeBean> getListEquipe();
}
