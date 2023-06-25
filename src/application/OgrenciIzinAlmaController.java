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
import javafx.scene.control.TextField;

import com.İSTEUtil.DBUtil;
import java.sql.*;

public class OgrenciIzinAlmaController {
	
	public OgrenciIzinAlmaController() {
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
    private Label lbl_kontrol;

    @FXML
    private TextField txt_izingun;

    @FXML
    private TextField txt_kulad;

    @FXML
    void btn_kaydet_click(ActionEvent event) {
    	sql ="update login set izinli_gun=? where kul_ad=?";
		try {
			sorguİfadesi = baglanti.prepareStatement(sql);
			sorguİfadesi.setString(1,txt_izingun.getText().trim());
			sorguİfadesi.setString(2,txt_kulad.getText().trim());
			sorguİfadesi.executeUpdate();
			lbl_kontrol.setText(" Güncelleme gerçekleşti");
			
		} catch(Exception e) {
			lbl_kontrol.setText(e.getMessage().toString());
	}
    }

    @FXML
    void initialize() {
       

    }

}
