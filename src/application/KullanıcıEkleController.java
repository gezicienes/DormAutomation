package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.İSTEUtil.DBUtil;
import java.sql.*;



public class KullanıcıEkleController {
	
	public KullanıcıEkleController() {
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
    private TextField blok_txt;

    @FXML
    private Button btn_sistemeekle;

    @FXML
    private TextField cinsiyet_txt;

    @FXML
    private TextField kulad_txt;

    @FXML
    private PasswordField sifre_txt;
    
    @FXML
    private Label lbl_kontrol;

    @FXML
    void btn_sistemeekle_click(ActionEvent event) {
    	sql ="insert into login(kul_ad, sifre, yetki, blok, cinsiyet,izinli_gun) values(?,?,?,?,?,?)";
		try {
			sorguİfadesi = baglanti.prepareStatement(sql);
			sorguİfadesi.setString(1,kulad_txt.getText().trim());
			sorguİfadesi.setString(2,sifre_txt.getText().trim());
			sorguİfadesi.setString(3,"Kullanıcı");
			sorguİfadesi.setString(4,blok_txt.getText().trim());
			sorguİfadesi.setString(5,cinsiyet_txt.getText().trim());
			sorguİfadesi.setString(6,"0");
			
			sorguİfadesi.executeUpdate();
			lbl_kontrol.setText(" Ekleme gerçekleşti");
			
		} catch(Exception e) {
			lbl_kontrol.setText(e.getMessage().toString());
	}
    }

    @FXML
    void initialize() {
       

    }

}
