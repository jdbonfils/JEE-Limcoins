package Bookmaker;

import Parieur.Parieur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
public class BookmakerSessionBean implements Bookmaker, Serializable {

    @PersistenceContext
    EntityManager em ;


    @Override
    public void addBookmaker(String nom, String prenom, String date, String addr,String tel) {

    }

    @Override
    public void updateBookmaker() {

    }

    @Override
    public void deleteBookmaker(int id) {

    }

    @Override
    public List<BookmakerBean> getListBookmaker() {
        return null;
    }
}