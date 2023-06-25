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

public class yoneticiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ogrenci_ekle;

    @FXML
    private Button btn_cikis;
    
    @FXML
    private Button btn_ogrenci_guncelle;

    @FXML
    private Button btn_ogrenci_sil;

    @FXML
    private Button btn_yonetici_ekle;

    @FXML
    private Button btn_İstatistik;
    
    @FXML
    private Button btn_bildirilen_arıza;
    
    @FXML
    void btn_cikis_click(ActionEvent event) {
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
    void btn_bildirilen_arıza_click(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane anchor1 = (AnchorPane)FXMLLoader.load(getClass().getResource("YoneticininArızaFormu.fxml"));
			Scene scene = new Scene(anchor1);
			//Scene scene = new Scene(anchor1,400,400);//Boyutlandırma da yapılabilir.
			stage1.setScene(scene);
			stage1.show();
	        
		} catch(Exception e) {
			
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void btn_ogrenci_ekle_click(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane anchor1 = (AnchorPane)FXMLLoader.load(getClass().getResource("KullanıcıEkleFormu.fxml"));
			Scene scene = new Scene(anchor1);
			//Scene scene = new Scene(anchor1,400,400);//Boyutlandırma da yapılabilir.
			stage1.setScene(scene);
			stage1.show();
	        
		} catch(Exception e) {
			
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void btn_ogrenci_guncelle_click(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane anchor1 = (AnchorPane)FXMLLoader.load(getClass().getResource("OgrenciYoneticiGuncellemeFormu.fxml"));
			Scene scene = new Scene(anchor1);
			//Scene scene = new Scene(anchor1,400,400);//Boyutlandırma da yapılabilir.
			stage1.setScene(scene);
			stage1.show();
	        
		} catch(Exception e) {
			
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void btn_ogrenci_sil_click(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane anchor1 = (AnchorPane)FXMLLoader.load(getClass().getResource("OgrenciSilmeFormu.fxml"));
			Scene scene = new Scene(anchor1);
			//Scene scene = new Scene(anchor1,400,400);//Boyutlandırma da yapılabilir.
			stage1.setScene(scene);
			stage1.show();
	        
		} catch(Exception e) {
			
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void btn_yonetici_ekle_click(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane anchor1 = (AnchorPane)FXMLLoader.load(getClass().getResource("YoneticiEkleFormu.fxml"));
			Scene scene = new Scene(anchor1);
			//Scene scene = new Scene(anchor1,400,400);//Boyutlandırma da yapılabilir.
			stage1.setScene(scene);
			stage1.show();
	        
		} catch(Exception e) {
			
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void btn_İstatistik_click(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane anchor1 = (AnchorPane)FXMLLoader.load(getClass().getResource("ChartFormu.fxml"));
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
     

    }

}
