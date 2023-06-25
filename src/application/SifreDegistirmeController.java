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

public class SifreDegistirmeController {
	
	public SifreDegistirmeController() {
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
    private Button btn_sifredegis;

    @FXML
    private Label lbl_kontrol;

    @FXML
    private PasswordField tx_mevcutsifre;

    @FXML
    private TextField txt_kulad;

    @FXML
    private PasswordField txt_yenisifre;

    @FXML
    private PasswordField txt_yenisifre_tekrar;

    @FXML
    void btn_sifredegis_click(ActionEvent event) {
    	sql ="update login set sifre=? where kul_ad=?";
		try {
			sorguİfadesi = baglanti.prepareStatement(sql);
			sorguİfadesi.setString(1,txt_yenisifre.getText().trim());
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
