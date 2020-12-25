package Pari;

import Cote.CoteBean;
import Parieur.ParieurBean;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
public class PariSessionBean implements Serializable,Pari {
    @Override
    public void addPari(float limcoinmise, ParieurBean parieur, CoteBean cote) {

    }

    @Override
    public void updatePari() {

    }

    @Override
    public void deletePari(long id) {

    }

    @Override
    public List<PariBean> getListParis() {
        return null;
    }
}
