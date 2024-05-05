package Noleggio;

public class Persona {
protected String nominativo;
//protected String cognome;
protected String username;
protected String password;
//protected String tipo;

	public Persona(String nominativo, String username, String password) {
	super();
	this.nominativo = nominativo;
	this.username = username;
	this.password = password;
}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}