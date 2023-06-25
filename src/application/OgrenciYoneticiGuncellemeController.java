package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import com.İSTEUtil.DBUtil;
import java.sql.*;

public class OgrenciYoneticiGuncellemeController {

public OgrenciYoneticiGuncellemeController() {
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
    private Button btn_guncele;

    @FXML
    private TextField kulad_txt;

    @FXML
    private Label lbl_id;

    @FXML
    private Label lbl_kontrol;

    @FXML
    private PasswordField sifre_txt;

    @FXML
    private TableColumn<Kayıtlar_Kullanıcılar, Integer> table_blok;

    @FXML
    private TableColumn<Kayıtlar_Kullanıcılar, String> table_cinsiyet;

    @FXML
    private TableColumn<Kayıtlar_Kullanıcılar, Integer> table_kID;

    @FXML
    private TableColumn<Kayıtlar_Kullanıcılar, String> table_kulad;

    @FXML
    private TableColumn<Kayıtlar_Kullanıcılar, String> table_sifre;

    @FXML
    private TableColumn<Kayıtlar_Kullanıcılar, String> table_yetki;

    @FXML
    private TableView<Kayıtlar_Kullanıcılar> tableview_kullanıcı;
    
    @FXML
    void tableview_kullanıcı_click(MouseEvent event) {
    	Kayıtlar_Kullanıcılar kayitlar=new Kayıtlar_Kullanıcılar();
    	kayitlar=(Kayıtlar_Kullanıcılar) tableview_kullanıcı.getItems().get(tableview_kullanıcı.getSelectionModel().getSelectedIndex());
    	
    	kulad_txt.setText(kayitlar.getKul_ad());
    	sifre_txt.setText(kayitlar.getSifre());
    	
    	blok_txt.setText(String.valueOf(kayitlar.getBlok()));
    	lbl_id.setText(String.valueOf(kayitlar.getkID()));
    	
    }
    
    public void DegerlerGetir(TableView<Kayıtlar_Kullanıcılar> tablo, String sql) {
    	//sql="select * from islemler";
    	ObservableList<Kayıtlar_Kullanıcılar> liste=FXCollections.observableArrayList();
    	try {
    		sorguİfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguİfadesi.executeQuery();
    		while(getirilen.next()) {
    			liste.add(new Kayıtlar_Kullanıcılar(getirilen.getInt("kID"),getirilen.getString("kul_ad"),getirilen.getString("sifre"),getirilen.getString("yetki"),getirilen.getInt("blok"),getirilen.getString("cinsiyet")));
    		}
    		
    		table_kID.setCellValueFactory(new PropertyValueFactory<>("kID"));
    		table_kulad.setCellValueFactory(new PropertyValueFactory<>("kul_ad"));
    		table_sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
    		table_yetki.setCellValueFactory(new PropertyValueFactory<>("yetki"));
    		table_blok.setCellValueFactory(new PropertyValueFactory<>("blok"));
    		table_cinsiyet.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
    		

    		tableview_kullanıcı.setItems(liste);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage().toString());
		}
    	
    }

    @FXML
    void btn_guncele_click(ActionEvent event) {
    	sql="select * from login where kul_ad=?";
    	
    	sql="update login set kul_ad=?,sifre=?,blok=? where kID=?";
    	
    	try {
			sorguİfadesi=baglanti.prepareStatement(sql);
			sorguİfadesi.setString(1, kulad_txt.getText().trim());
			
			sorguİfadesi.setString(2, sifre_txt.getText().trim());

			sorguİfadesi.setString(3, blok_txt.getText().trim());

			sorguİfadesi.setString(4, lbl_id.getText().trim());

			sorguİfadesi.executeUpdate();
			
			sql="select * from login";
	    	DegerlerGetir(tableview_kullanıcı, sql);
			
	    		lbl_kontrol.setText(" Güncelleme gerçekleşti");
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			
		}
    }
    

    @FXML
    void initialize() {
    	sql="select * from login";
    	DegerlerGetir(tableview_kullanıcı, sql);

    }

}
