package pt.uc.dei.aor.paj;

import java.io.Serializable;

public class Credenciais implements Serializable {

	private static final long serialVersionUID = -3165509143034007614L;

	private String username;

	private String password;



	public Credenciais() {
		super();
		this.username = "";
		this.password = "";
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

