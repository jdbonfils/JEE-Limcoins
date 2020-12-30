package Equipe;

import javax.ejb.Remote;
import java.util.List;
@Remote
public interface Equipe {

    public void addEquipe(String nom, String ville, int rep, List<JoueurBean> membres);

    public void updateEquipe() ;
    public void deleteEquipe(int id);
    public List<EquipeBean> getListEquipe();
    public EquipeBean getEquipe(long id);
}
