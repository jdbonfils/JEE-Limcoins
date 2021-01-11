package Limcoin;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface Limcoin {

    public List<LimcoinBean> getLimcoinOrdered() ;
    public void deleteLastLimcoin() ;
    public LimcoinBean getLastLimcoin();
}
