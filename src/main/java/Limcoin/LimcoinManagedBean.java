package Limcoin;

import org.primefaces.model.chart.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ManagedBean
@RequestScoped
public class LimcoinManagedBean implements Serializable {

    @EJB
    Limcoin limcoin ;

    private LineChartModel lineModel2;

    @PostConstruct
    public void init() {
        createLineModels();
    }

    private void createLineModels() {


        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Cours du Limcoins");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Date"));

        Axis yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Valeur");
        yAxis.setMin(0.65);
        yAxis.setMax(0.95);
    }

    private LineChartModel initCategoryModel() {

        LineChartModel model = new LineChartModel();
        List<LimcoinBean> valeurs = limcoin.getLimcoinOrdered() ;
        ChartSeries euro = new ChartSeries();
        ChartSeries dollar = new ChartSeries();
        euro.setLabel("Euro");
        dollar.setLabel("Dollar");
        Calendar calendar = Calendar.getInstance();
        for(LimcoinBean l : valeurs)
        {
            calendar.setTimeInMillis(l.getDate());
            euro.set( calendar.get(Calendar.MINUTE) ,l.getEuro()) ;
            dollar.set( calendar.get(Calendar.MINUTE) ,l.getDollar()) ;
        }
        model.addSeries(euro);
        model.addSeries(dollar);

        return model;
    }

    public LineChartModel getLineModel2() {
        return lineModel2;
    }

    public void setLineModel2(LineChartModel lineModel2) {
        this.lineModel2 = lineModel2;
    }


}
