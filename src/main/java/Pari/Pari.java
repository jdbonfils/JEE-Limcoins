package Pari;

import Cote.CoteBean;
import Parieur.ParieurBean;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface Pari {

    public void addPari(float limcoinmise, ParieurBean parieur, CoteBean cote) ;
    public void updatePari() ;
    public void deletePari(long id);
    public List<PariBean> getListParis();

}
