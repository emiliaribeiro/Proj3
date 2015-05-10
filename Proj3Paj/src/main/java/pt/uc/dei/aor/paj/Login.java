package pt.uc.dei.aor.paj;
import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
@Named
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = -2921010109456538382L;

	@Inject Mensagem chat;
	

	//Credenciais classe com o username e password do utilizador


	//conjunto de utilizadores inscritos
	private ArrayList<Credenciais> utilizadores;
	//2 utilizadores inscritos por defeito

	//private int numTentativas;
	private String user, password, mensagem;
	//private boolean logged=false;

	//construtor cria a ArrayList dos utilizadores e acrescenta os dois por defeito
	public Login() {
		super();
		this.utilizadores = new ArrayList<Credenciais>();
		Credenciais ut1=new Credenciais();
		Credenciais ut2=new Credenciais();
		ut1.setUsername("Emilia");
		ut1.setPassword("123");
		ut2.setUsername("Filipa");
		ut2.setPassword("1234");
		this.utilizadores.add(ut1);
		this.utilizadores.add(ut2);
		//this.numTentativas=0;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	//verifica se o utilizador com aquele username já existe ou nao
	public boolean verifyUser(String username){
		boolean existe=false;
		for(Credenciais p:utilizadores){
			if(p.getUsername().equals(username))
				existe=true;
		}
		return existe;
	}

	//verifica se o utilizador com aquele username já existe ou nao
	public boolean verifyPass(String pass, String username){
		boolean existe=false;
		for(Credenciais p:utilizadores){
			if(p.getUsername().equals(username) && p.getPassword().equals(pass))
				existe=true;
		}
		return existe;
	}

	//mensagem de loginSucess ou RegistoSucess
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	//logar para utilizador existente
	//estava void
	public String logar(){

		//if (this.numTentativas<=3){

			if(verifyPass(this.password, this.user)){
				this.mensagem = "Bem Vindo ao Sistema "+this.user+"!";
				chat.setUtilizador(this.user);
				this.user="";
				this.password="";
//				this.logged=true;
//				this.numTentativas=0;
				return "normal";
				
			}else{
			//	this.numTentativas++;
				this.mensagem = "Utilizador ou senha Inválidos!";
				this.user="";
				this.password="";
				return "login";
			}
	}

	//Acrescenta novo utilizador caso não exista
	public String novoUtilizador(){
		boolean existe=false;

		existe=verifyUser(this.user);
		if (!existe){
			Credenciais ut=new Credenciais();
			ut.setUsername(this.user);
			ut.setPassword(this.password);
			this.utilizadores.add(ut);
			chat.setUtilizador(this.user);
			this.mensagem="Utilizador registado com sucesso!";
			this.user="";
			this.password="";
			return "normal";
			//this.logged=true;
		}else{
			this.mensagem="Utilizador já existente, escolha novo username";
			this.user="";
			chat.setUtilizador(this.user);
			this.password="";
			return "login";
		}
	}


}
