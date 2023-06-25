package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class kullaniciController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_arıza;
    
    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_izin;

    @FXML
    private Button btn_sifre_guncelle;

    @FXML
    void bn_cikis_click(ActionEvent event) {
    	try {
		   	Stage stage2 = new Stage();
			AnchorPane anchor2 = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(anchor2);
			//Scene scene = new Scene(anchor1,400,400);//Boyutlandırma da yapılabilir.
			stage2.setScene(scene);
				stage2.show();
				
			} catch(Exception e) {
				
				e.printStackTrace();
			}
    	Stage stage = (Stage) btn_cikis.getScene().getWindow();
        // Formu gizle
        stage.hide();
    }
    
    @FXML
    void btn_arıza_click(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane anchor1 = (AnchorPane)FXMLLoader.load(getClass().getResource("ArızaFormu.fxml"));
			Scene scene = new Scene(anchor1);
			//Scene scene = new Scene(anchor1,400,400);//Boyutlandırma da yapılabilir.
			stage1.setScene(scene);
			stage1.show();
	        
		} catch(Exception e) {
			
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void btn_izin_click(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane anchor1 = (AnchorPane)FXMLLoader.load(getClass().getResource("OgrenciIzinAlmaFormu.fxml"));
			Scene scene = new Scene(anchor1);
			//Scene scene = new Scene(anchor1,400,400);//Boyutlandırma da yapılabilir.
			stage1.setScene(scene);
			stage1.show();
	        
		} catch(Exception e) {
			
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void btn_sifre_guncelle_click(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane anchor1 = (AnchorPane)FXMLLoader.load(getClass().getResource("SifreDegistirmeFormu.fxml"));
			Scene scene = new Scene(anchor1);
			//Scene scene = new Scene(anchor1,400,400);//Boyutlandırma da yapılabilir.
			stage1.setScene(scene);
			stage1.show();
	        
		} catch(Exception e) {
			
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void initialize() {
        assert btn_arıza != null : "fx:id=\"btn_arıza\" was not injected: check your FXML file 'KullaniciFormu.fxml'.";
        assert btn_izin != null : "fx:id=\"btn_izin\" was not injected: check your FXML file 'KullaniciFormu.fxml'.";
        assert btn_sifre_guncelle != null : "fx:id=\"btn_sifre_guncelle\" was not injected: check your FXML file 'KullaniciFormu.fxml'.";

    }

}
