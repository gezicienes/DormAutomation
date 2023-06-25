package application;

public class Kayıtlar_Arıza {

public Kayıtlar_Arıza() {
		
	}
private int arıza_ID;
private String arıza;

public int getArıza_ID() {
	return arıza_ID;
}


public void setArıza_ID(int arıza_ID) {
	this.arıza_ID = arıza_ID;
}


public String getArıza() {
	return arıza;
}


public void setArıza(String arıza) {
	this.arıza = arıza;
}


public String getKul_ad() {
	return kul_ad;
}


public void setKul_ad(String kul_ad) {
	this.kul_ad = kul_ad;
}
private String kul_ad;


Kayıtlar_Arıza(int arıza_ID,String arıza,String kul_ad) {
	this.arıza_ID=arıza_ID;
	this.arıza=arıza;
	this.kul_ad=kul_ad;
	
}
}
