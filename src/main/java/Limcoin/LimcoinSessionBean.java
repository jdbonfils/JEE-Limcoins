package Limcoin;



import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.List;

@Stateless
@Startup
public class LimcoinSessionBean implements Serializable,Limcoin {

    @PersistenceContext
    EntityManager em ;

    @Schedule(hour="*", minute="*/5",persistent=false)
    public void majLimcoin() throws URISyntaxException, IOException {
        String c = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() ;
        c.split("/Limcoins/",2);
        String chemin = c.split("/Limcoins/",2)[0] + "/Limcoins/src/main/webapp/resources/currency.py" ;
        if(this.getLimcoinOrdered().size() > 10)
        {
            System.out.println("Supression de la donnée la plus ancienne") ;
            this.deleteLastLimcoin();
        }
    try {
            Process p = Runtime.getRuntime().exec("python3 "+chemin);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            float euro = Float.parseFloat(stdInput.readLine()) ;
            float dollar = Float.parseFloat(stdInput.readLine()) ;
            LimcoinBean l = new LimcoinBean(System.currentTimeMillis(),dollar%1,euro%1) ;
            em.persist(l);
            System.out.println("Limcoin MAJ") ;

      }catch(Exception e)
        {
            System.out.println("La MAJ du limcoin a échoué") ;
        }

    }

    @Override
    public List<LimcoinBean> getLimcoinOrdered() {
        Query emQuery = em.createNativeQuery("SELECT * FROM LimcoinBean l ORDER BY date", LimcoinBean.class);
        return (List<LimcoinBean>) emQuery.getResultList() ;
    }

    @Override
    public void deleteLastLimcoin() {
        List<LimcoinBean> listLimcoins = this.getLimcoinOrdered() ;
        em.remove(listLimcoins.get(0)) ;
    }

    @Override
    public LimcoinBean getLastLimcoin()
    {
        Query emQuery = em.createNativeQuery("SELECT * FROM LimcoinBean l ORDER BY date DESC FETCH FIRST ROW ONLY", LimcoinBean.class);
        List<LimcoinBean> result = (List<LimcoinBean>) emQuery.getResultList() ;
        if(!result.isEmpty())
        {
            return result.get(0) ;
        }
        return null ;
    }
}
