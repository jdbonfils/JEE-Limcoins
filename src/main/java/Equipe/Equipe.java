package Equipe;

import java.util.List;

public interface Equipe {

    public void addEquipe(String nom, String ville, int reo, List<JoueurBean> membres);

    public void updateEquipe() ;
    public void deleteEquipe(int id);
    public List<EquipeBean> getListEquipe();
    public EquipeBean getEquipe(long id);
}
