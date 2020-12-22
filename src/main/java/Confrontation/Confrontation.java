package Confrontation;

import Equipe.EquipeBean;

import javax.ejb.Remote;
import java.sql.Date;
import java.util.List;
@Remote
public interface Confrontation {

    public void addConfrontation(String nom, String lieu, Date date, int minutes, EquipeBean e1,EquipeBean e2);
    public void updateConfrontation() ;
    public void deleteConfrontation(int id);
    public List<ConfrontationBean> getListConfrontation();

}
