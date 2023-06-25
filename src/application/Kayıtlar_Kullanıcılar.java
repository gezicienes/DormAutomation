package application;

public class Kayıtlar_Kullanıcılar {

	public Kayıtlar_Kullanıcılar() {
		
	}
	
	
	public int getkID() {
		return kID;
	}

	public void setkID(int kID) {
		this.kID = kID;
	}

	public String getKul_ad() {
		return kul_ad;
	}

	public void setKul_ad(String kul_ad) {
		this.kul_ad = kul_ad;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getYetki() {
		return yetki;
	}

	public void setYetki(String yetki) {
		this.yetki = yetki;
	}

	public int getBlok() {
		return blok;
	}

	public void setBlok(int blok) {
		this.blok = blok;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	private int kID;
	private String kul_ad;
	private String sifre;
	private String yetki;
	private int blok;
	private String cinsiyet;
	
	Kayıtlar_Kullanıcılar(int kID,String kul_ad,String sifre,String yetki, int blok, String cinsiyet) {
		this.kID=kID;
		this.kul_ad=kul_ad;
		this.sifre=sifre;
		this.yetki=yetki;
		this.blok=blok;
		this.cinsiyet=cinsiyet;
	}
	
	
	
}
