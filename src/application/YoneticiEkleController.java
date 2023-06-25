package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.İSTEUtil.DBUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class YoneticiEkleController {
	
	public YoneticiEkleController() {
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
    private Button btn_sistemeekle;

    @FXML
    private TextField cinsiyet_txt;

    @FXML
    private TextField kulad_txt;

    @FXML
    private Label lbl_kontrol;

    @FXML
    private PasswordField sifre_txt;

    @FXML
    void btn_sistemeekle_click(ActionEvent event) {
    	sql ="insert into login(kul_ad, sifre, yetki, blok, cinsiyet,izinli_gun) values(?,?,?,?,?,?)";
		try {
			sorguİfadesi = baglanti.prepareStatement(sql);
			sorguİfadesi.setString(1,kulad_txt.getText().trim());
			sorguİfadesi.setString(2,sifre_txt.getText().trim());
			sorguİfadesi.setString(3,"Yönetici");
			sorguİfadesi.setString(4,"1");
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
