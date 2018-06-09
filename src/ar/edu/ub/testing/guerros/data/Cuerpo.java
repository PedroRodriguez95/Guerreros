package ar.edu.ub.testing.guerros.data;

public class Cuerpo {
	
	private String cabeza =     "o";
	private String brazo_izq = "/";
	private String torso =  "|";
	private String brazo_der = "\\";
	private String pierna_izq =   "/";
	private String pierna_der = "\\";
	
	
	public String getCabeza() {
		return cabeza;
	}
	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}
	public String getBrazo_izq() {
		return brazo_izq;
	}
	public void setBrazo_izq(String brazo_izq) {
		this.brazo_izq = brazo_izq;
	}
	public String getTorso() {
		return torso;
	}
	public void setTorso(String torso) {
		this.torso = torso;
	}
	public String getBrazo_der() {
		return brazo_der;
	}
	public void setBrazo_der(String brazo_der) {
		this.brazo_der = brazo_der;
	}
	public String getPierna_izq() {
		return pierna_izq;
	}
	public void setPierna_izq(String pierna_izq) {
		this.pierna_izq = pierna_izq;
	}
	public String getPierna_der() {
		return pierna_der;
	}
	public void setPierna_der(String pierna_der) {
		this.pierna_der = pierna_der;
	}
	
	public void setCuerpoMuerto() {
		this.setCabeza("o");
		this.setTorso ("X");
		this.setBrazo_der(" ");
		this.setPierna_der(" ");
		this.setBrazo_izq(" ");
		this.setPierna_izq(" ");
	}
}
