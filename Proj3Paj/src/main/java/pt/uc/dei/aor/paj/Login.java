package pt.uc.dei.aor.paj;

import java.util.ArrayList;

import javax.inject.Inject;

public class Login {

	@Inject Credenciais utilizador;
	private ArrayList<Credenciais> utilizadores;
	private Credenciais uti1, uti2;
	public Login() {
		super();
		this.utilizadores = new ArrayList<Credenciais>();
		this.uti1.setPassword("123");
		this.uti1.setUsername("Emilia");
		this.uti2.setPassword("1234");
		this.uti2.setUsername("Filipa");

	}

	public void novoUtilizador(String username, String password){
		boolean existe=false;
		
		existe=verifyUser(username);
		if (!existe){
			utilizador.setUsername(username);
			utilizador.setPassword(password);
			this.utilizadores.add(utilizador);
		}
	}
	public boolean verifyUser(String username){
		boolean existe=false;
		for(Credenciais p:utilizadores){
			if(p.getUsername().equals(username))
				existe=true;
		}
		return existe;
	}
	public void setUtilizadores(String username, String password) {
		utilizador.setUsername(username);
		utilizador.setPassword(password);
		this.utilizadores.add(utilizador);
	}





}
