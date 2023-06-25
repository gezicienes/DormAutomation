package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import com.İSTEUtil.DBUtil;
import java.sql.*;



public class ArızaContoller {
	
	public ArızaContoller() {
		baglanti=DBUtil.Baglan();
	}
	
	Connection baglanti =null;
	PreparedStatement sorguİfadesi = null;
	ResultSet getirilen = null;
	String sql;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_kaydet;

    @FXML
    private TableColumn<Kayıtlar_Arıza, String> table_arıza;

    @FXML
    private TableColumn<Kayıtlar_Arıza, Integer> table_arızaid;

    @FXML
    private TableColumn<Kayıtlar_Arıza, String> table_kulad;

    @FXML
    private TableView<Kayıtlar_Arıza> tableview_arıza;

    @FXML
    private TextArea txt_arıza;

    @FXML
    private TextField txt_kulad;
    
    @FXML
    void tableview_arıza_click(MouseEvent event) {
    	Kayıtlar_Arıza kayitlar=new Kayıtlar_Arıza();
    	kayitlar=(Kayıtlar_Arıza) tableview_arıza.getItems().get(tableview_arıza.getSelectionModel().getSelectedIndex());
    	
    	txt_kulad.setText(kayitlar.getKul_ad());
    	txt_arıza.setText(kayitlar.getArıza());
    	
    	
    }

    public void DegerlerGetir(TableView<Kayıtlar_Arıza> tablo, String sql) {
    	//sql="select * from islemler";
    	ObservableList<Kayıtlar_Arıza> liste=FXCollections.observableArrayList();
    	try {
    		sorguİfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguİfadesi.executeQuery();
    		while(getirilen.next()) {
    			liste.add(new Kayıtlar_Arıza(getirilen.getInt("arıza_ID"),getirilen.getString("arıza"),getirilen.getString("kul_ad")));
    		}
    		
    		table_arızaid.setCellValueFactory(new PropertyValueFactory<>("arıza_ID"));
    		table_kulad.setCellValueFactory(new PropertyValueFactory<>("kul_ad"));
    		table_arıza.setCellValueFactory(new PropertyValueFactory<>("arıza"));
    		

    		tableview_arıza.setItems(liste);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage().toString());
		}
    	
    }
    
    @FXML
    void btn_kaydet_click(ActionEvent event) {
sql="insert into arızalar(kul_ad,arıza) values(?,?)";
    	
    	try {
			sorguİfadesi=baglanti.prepareStatement(sql);
			sorguİfadesi.setString(1, txt_kulad.getText().trim());
			sorguİfadesi.setString(2, txt_arıza.getText().trim());
			
			
			
			sorguİfadesi.executeUpdate();
			sql="select * from arızalar";
	    	DegerlerGetir(tableview_arıza, sql);
			
		
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void initialize() {
    	sql="select * from arızalar";
    	DegerlerGetir(tableview_arıza, sql);

    }

}
