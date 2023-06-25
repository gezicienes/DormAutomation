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


public class OgrenciSilmeController {

	public OgrenciSilmeController() {
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
    private Button btn_silme;

    @FXML
    private TextField kulad_txt;

    @FXML
    private Label lbl_kontrol;

    @FXML
    private PasswordField sifre_txt;

    @FXML
    void btn_silme_click(ActionEvent event) {
    	sql ="delete from login where kul_ad=? and sifre=?";
		try {
			sorguİfadesi = baglanti.prepareStatement(sql);
			sorguİfadesi.setString(1,kulad_txt.getText().trim());
			sorguİfadesi.setString(2,sifre_txt.getText().trim());
			
			sorguİfadesi.executeUpdate();
			lbl_kontrol.setText(" Silme gerçekleşti");
			
		} catch(Exception e) {
			lbl_kontrol.setText(e.getMessage().toString());
	}
    }

    @FXML
    void initialize() {
       

    }

}
