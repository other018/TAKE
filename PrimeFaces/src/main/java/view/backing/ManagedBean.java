package view.backing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@Named(value = "managedBean")
//@RequestScoped
@ApplicationScoped
public class ManagedBean {

    private Integer number1;
    private Integer number2;
    private Integer sumResult;

    private List<Student> students;
    
    public ManagedBean() {
        prepareStudents();
    }

    public void sumNumbers() {
        sumResult = number1 + number2;
        FacesContext.
                getCurrentInstance().
                addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Calculate",
                        number1.toString() + "+" + number2.toString() + "=" + sumResult.toString()
                ));
    }    

    public Date getTime() {
        return new Date();
    }

    public Integer getNumber1() {
        return number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public Integer getSumResult() {
        return sumResult;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public void setSumResult(Integer sumResult) {
        this.sumResult = sumResult;
    }

    public LineChartModel getLineModel() {
        LineChartModel lineModel = new LineChartModel();

        LineChartSeries cosSerie = new LineChartSeries();
        cosSerie.setLabel("Cosine");
        LineChartSeries sinSerie = new LineChartSeries();
        sinSerie.setLabel("Sine");

        for (int i = 0; i <= 360; i=i+10) {
            Double rad = Math.toRadians(i);
            cosSerie.set(Integer.toString(i), Math.cos(rad));
            sinSerie.set(Integer.toString(i), Math.sin(rad));
        }

        lineModel.setZoom(true);
        lineModel.addSeries(cosSerie);
        lineModel.addSeries(sinSerie);
        
        lineModel.getAxis(AxisType.X).setMin(0);
        lineModel.getAxis(AxisType.X).setMax(360);

        lineModel.getAxis(AxisType.Y).setMin(-1.2);
        lineModel.getAxis(AxisType.Y).setMax(1.2);
        
        lineModel.setTitle("Sine and cosine");
        lineModel.setLegendPosition("se");

        return lineModel;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    private String[] firstNames = {"Anna", "Marysia", "Martyna", "Karolina", "Katarzyna", "Mateusz", "Marek", "Janusz", "Jan", "Kamil"};
    private String[] secondNames = {"Nowak", "Kowalska", "Wiśniewska", "Wójcik", "Kowalczyk",
        "Kamińska", "Lewandowska", "Zielińska", "Szymańska", "Woźniak"};
    private Double[] averages = {2.5, 3.4, 4.2, 2.75, 3.35, 4.5, 3.75, 5.0, 4.6, 2.7};

    private void prepareStudents() {
        students = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String firstName = firstNames[(int)(Math.random()*firstNames.length)%firstNames.length];
            String secondName = secondNames[(int)(Math.random()*secondNames.length)%secondNames.length];
            Double average = averages[(int)(Math.random()*averages.length)%averages.length];
            students.add(new Student(firstName, secondName, average));
        }
    }
}
