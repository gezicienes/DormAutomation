package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;

import com.İSTEUtil.DBUtil;
import java.sql.*;



public class SampleController {
	public SampleController() {
		baglanti=DBUtil.Baglan();
		
	}

	Connection baglanti =null;
	PreparedStatement sorguİfadesi = null;
	ResultSet getirilen = null;
	String sql;
	
	 public static String kullanicimSession = "";
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_giris;

    @FXML
    private TextField txt_kul;

    @FXML
    private PasswordField txt_sifre;

   @FXML
    private RadioButton rbtn_kullanici;

    @FXML
    private RadioButton rbtn_yonetici;
    
    public int denemeSayısı = 0;
    
    public static void AlertGöster(Alert.AlertType alertTipi,String baslik,String kbaslik,String mesaj) {
        Alert alert = new Alert(alertTipi);
        alert.setTitle(baslik);
        alert.setHeaderText(kbaslik);
        alert.setContentText(mesaj);
        //alert.initOwner(owner);
        alert.showAndWait();
    }

    @FXML
    void login_buton_click(ActionEvent event) {
    	
    	LoginKontrol2(txt_kul.getText(), txt_sifre.getText());
    	
    }
    
 public void LoginKontrol2(String kullanıcı, String sifre) {
    	
    	Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("Giriş Yetkisi");
    	alert.setHeaderText("Personel Girişi");
    	
    	sql="select * from login where kul_ad=? and sifre=?";
    	
    	try {
			sorguİfadesi=baglanti.prepareStatement(sql);
			sorguİfadesi.setString(1, txt_kul.getText().trim());
			sorguİfadesi.setString(2, txt_sifre.getText().trim());
			//sorguIfadesi.setString(3,rbtn_yonetici.getText().trim());
			
			ResultSet getirilen=sorguİfadesi.executeQuery();
			if(!getirilen.next()) {
				
				alert.setContentText("Girilen kullanıcı adı veya Şİfresi hatalıdır\nLütfen bilgilerinizi kontrol ediniz!");
				alert.showAndWait();
				txt_kul.clear();
    			txt_sifre.clear();
    			
    			denemeSayısı++;
    			if(denemeSayısı==3) {
    				alert.setContentText("3 defa hatalı giriş yaptınız...");
    				alert.showAndWait();
    				System.exit(0);
    			}
			}
			else {
				
				getirilen.getString(1);
				if(!kullanıcı.isEmpty() && !sifre.isEmpty()) {
					if(kullanıcı.equals(getirilen.getString("kul_ad")) && (sifre.equals(getirilen.getString("sifre")))){
		    			if(rbtn_yonetici.isSelected() && rbtn_yonetici.getText().equals(getirilen.getString("yetki"))) {
		    				
		    				kullanicimSession=txt_kul.getText();
		    				AlertGöster(Alert.AlertType.INFORMATION,"Giriş Yetkisi","Personel Girişi","Tebrikler Başarılı giriş yaptınız...");
		    				try {
			    			   	Stage stage2 = new Stage();
			    				AnchorPane anchor2 = (AnchorPane)FXMLLoader.load(getClass().getResource("YoneticiFormu.fxml"));
			    				Scene scene = new Scene(anchor2);
			    				//Scene scene = new Scene(anchor1,400,400);//Boyutlandırma da yapılabilir.
			    				stage2.setScene(scene);
			   					stage2.show();
			   				} catch(Exception e) {
			    					
			  					e.printStackTrace();
			   				}
		    				
		    				Stage stage = (Stage) btn_giris.getScene().getWindow();
	    				    stage.hide();
		    				
		    			}
		    			else if(rbtn_kullanici.isSelected() && rbtn_kullanici.getText().equals(getirilen.getString("yetki"))) {
		    				kullanicimSession=txt_kul.getText();
		    				
		    				AlertGöster(Alert.AlertType.INFORMATION,"Giriş Yetkisi","Personel Girişi","Tebrikler Kullanıcı Başarılı giriş yaptınız...");
		    				try {
			    			   	Stage stage2 = new Stage();
			    				AnchorPane anchor2 = (AnchorPane)FXMLLoader.load(getClass().getResource("KullaniciFormu.fxml"));
			    				Scene scene = new Scene(anchor2);
			    				//Scene scene = new Scene(anchor1,400,400);//Boyutlandırma da yapılabilir.
			    				stage2.setScene(scene);
			   					stage2.show();
			   				} catch(Exception e) {
			    					
			  					e.printStackTrace();
			   				}
		    				
		    				Stage stage = (Stage) btn_giris.getScene().getWindow();
	    				    stage.hide();
		    			}
		    			else {
		    				AlertGöster(Alert.AlertType.INFORMATION,"Giriş Yetkisi","Personel Girişi","Kullanıcı veya Yönetici olduğunuza emin olun...");
		    			}
		    			
		    			
		    		}
		    		else {
		    			alert.setContentText("Girilen kullanıcı adı veya Şİfresi hatalıdır\nLütfen bilgilerinizi kontrol ediniz!");
		    			txt_kul.clear();
		    			txt_sifre.clear();
		    			alert.showAndWait();
		    			
		    			denemeSayısı++;
		    			if(denemeSayısı==3) {
		    				alert.setContentText("3 defa hatalı giriş yaptınız...");
		    				alert.showAndWait();
		    				System.exit(0);
		    			}
		    		
		    		}	
		    	}
		    	else {
		    		alert.setContentText("Kullanıcı adı veya Şifre boş geçilemez.");
		    		txt_kul.clear();
					txt_sifre.clear();
		    		alert.showAndWait();
		    	}
			}
		} catch (Exception e) {
			
			alert.setContentText(e.getMessage().toString());
		}
    }

    @FXML
    void initialize() {
        

    }

}
