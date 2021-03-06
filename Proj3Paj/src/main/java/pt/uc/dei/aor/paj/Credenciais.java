package pt.uc.dei.aor.paj;

import java.io.Serializable;

import javax.inject.Named;
@Named
public class Credenciais implements Serializable {

	private static final long serialVersionUID = -3165509143034007614L;

	private String username;
	private String password;
	private boolean isLogged;


	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Credenciais() {
		super();
		this.username = "";
		this.password = "";
		this.isLogged=false;
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

