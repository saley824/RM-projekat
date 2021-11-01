package GUI;



public class PrimjedbaServer {
	
	private String polje;
	private String unos;
	private int id;
	private int negativniGlasovi;

	public PrimjedbaServer(String unos) {
		this.unos=unos;
		this.negativniGlasovi=0;
	}
	public String getPolje() {
		return polje;
	}
	public void setPolje(String polje) {
		this.polje = polje;
	}
	public String getUnos() {
		return unos;
	}
	public void setUnos(String unos) {
		this.unos = unos;
	}
	
	public int getNegativniGlasovi() {
		return negativniGlasovi;
	}
	public void setNegativniGlasovi(int negativniGlasovi) {
		this.negativniGlasovi = negativniGlasovi;
	}
	
	public String toString() {
		return unos+": "+ negativniGlasovi;
	}
	
	 
	
}
