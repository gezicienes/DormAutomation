package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class ChartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<String, Number> bar_chart;

    @FXML
    private PieChart pie_chart;
    
    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    void initialize() {
    	
    	pie_chart.setTitle("Bloklarda Barınan Cinsiyetlerin Oranlaması");
    	// Pie Chart veri serilerini oluşturma
        PieChart.Data data1 = new PieChart.Data("Erkek", 40);  //erkek
        PieChart.Data data2 = new PieChart.Data("Kadın", 30);  //kız


        // Pie Chart'a veri serilerini ekleme
        pie_chart.getData().add(data1);
        pie_chart.getData().add(data2);
       
        
    	// BarChart'ı doldurma örneği
        xAxis.setLabel("Bloklar");
        yAxis.setLabel("Değerler");

        bar_chart.setTitle("Bloklarda Barınan Kişilerin Oranlaması");
        
        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
        dataSeries.getData().add(new XYChart.Data<>("1. Blok", 30));  //1. blok
        dataSeries.getData().add(new XYChart.Data<>("2. Blok", 20));  //2. blok
        dataSeries.getData().add(new XYChart.Data<>("3. Blok", 25));  // 3. blok
        

        // Veri serisini BarChart'a ekle
        bar_chart.getData().add(dataSeries);
    }

}
