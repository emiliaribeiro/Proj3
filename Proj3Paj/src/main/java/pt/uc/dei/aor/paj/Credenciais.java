package pt.uc.dei.aor.paj;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Credenciais {

	private String username;

	private String password;



	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = username; }



	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }



}