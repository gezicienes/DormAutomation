package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.İSTEUtil.DBUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class YoneticininArızaController {
	
	public YoneticininArızaController() {
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
    private Label lbl_id;
    
    @FXML
    private TableColumn<Kayıtlar_Arıza, String> table_arıza;

    @FXML
    private TableColumn<Kayıtlar_Arıza, Integer> table_arızaid;

    @FXML
    private TableColumn<Kayıtlar_Arıza, String> table_kulad;

    @FXML
    private TableView<Kayıtlar_Arıza> tableview_arıza;
    
    @FXML
    private Button btn_cozuldu;
    
    public static void AlertGöster(Alert.AlertType alertTipi,String baslik,String kbaslik,String mesaj) {
        Alert alert = new Alert(alertTipi);
        alert.setTitle(baslik);
        alert.setHeaderText(kbaslik);
        alert.setContentText(mesaj);
        //alert.initOwner(owner);
        alert.showAndWait();
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
    void tableview_arıza_click(MouseEvent event) {
    	Kayıtlar_Arıza kayitlar=new Kayıtlar_Arıza();
    	kayitlar=(Kayıtlar_Arıza) tableview_arıza.getItems().get(tableview_arıza.getSelectionModel().getSelectedIndex());
    	lbl_id.setText(String.valueOf(kayitlar.getArıza_ID()));
    	
    	
    }
    
    @FXML
    void btn_cozuldu_click(ActionEvent event) {
    	sql="delete from arızalar where arıza_ID=?";
    	
    	try {
			sorguİfadesi=baglanti.prepareStatement(sql);
			sorguİfadesi.setString(1, lbl_id.getText().trim());
			
			sorguİfadesi.executeUpdate();
			AlertGöster(Alert.AlertType.INFORMATION,"Silme İşlemi","Arıza Silme","Arıza silme işlemi başarıyla gerçekleşti.");
			sql="select * from arızalar";
	    	DegerlerGetir(tableview_arıza, sql);
		

						
			
		} catch (Exception e) {
			
			
		}
    	
    	sql="select * from arızalar";
    	DegerlerGetir(tableview_arıza, sql);
    }

    @FXML
    void initialize() {
    	sql="select * from arızalar";
    	DegerlerGetir(tableview_arıza, sql);

    }

}
