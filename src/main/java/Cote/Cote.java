package Cote;

import Bookmaker.BookmakerBean;
import Confrontation.ConfrontationBean;
import Equipe.EquipeBean;

import javax.ejb.Remote;
import java.sql.Date;
import java.util.List;
@Remote
public interface Cote {
    public void addCote( float multi, Integer s1, Integer s2, BookmakerBean createur, ConfrontationBean c1) ;
    public void addCote( float multi, EquipeBean gagnant, BookmakerBean createur, ConfrontationBean c1) ;
    public void updateCote() ;
    public void deleteCote(long id);
    public CoteBean geCote(long id) ;
    public List<CoteBean> getListCote();
    public CoteBean getCoteWithId(long id) ;
}
