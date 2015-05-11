package pt.uc.dei.aor.paj;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named 
@SessionScoped
public class Basica implements Serializable {

	private static final long serialVersionUID = 3730437403554200689L;

	@Inject Calculadora calc;
	@Inject Estatistica est;
	@Inject PickListView pickHist;


	private String display;
	private String firstdigit;
	private String btnradio;
	private String resultado;
	private String txt;
	private String panel1;
	private double tempo_inicial;
	private double tempo_final;  
	private double diferencatempo;  
	
	public Basica() {
		this.display = "";
		this.resultado = "0";
		this.btnradio = "rad";
		this.panel1="false";
		this.txt="";
	}

	public String getPanel1() {
		return panel1;
	}

	public void setPanel1(String panel1) {
		this.panel1 = panel1;
	}

	//obtem o valor seleccionado no botao e apresenta no ecra
	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	//Getter e Setter associados à variável graus/radianos
	public String getBtnradio() {
		return btnradio;
	}
	public void setBtnradio(String btnradio) {
		this.btnradio = btnradio;
	}

	//botoes com ajax
	public void keyAdd(AjaxBehaviorEvent event) {

		switch (event.getComponent().getId()) {

		case "btn0":
			txt = "0";
			this.display+=txt;
			break;
		case "btn1":
			txt = "1";
			this.display+=txt;
			break;
		case "btn2":
			txt = "2";
			this.display+=txt;
			break;
		case "btn3":
			txt = "3";
			this.display+=txt;
			break;
		case "btn4":
			txt = "4";
			this.display+=txt;
			break;
		case "btn5":
			txt = "5";
			this.display+=txt;
			break;
		case "btn6":
			txt = "6";
			this.display+=txt;
			break;
		case "btn7":
			txt = "7";
			this.display+=txt;
			break;
		case "btn8":
			txt = "8";
			this.display+=txt;
			break;
		case "btn9":
			txt = "9";
			this.display+=txt;
			break;
		case "btnopen":
			txt = "(";
			this.display+=txt;
			break;
		case "btnclose":
			txt = ")";
			this.display+=txt;
			break;
		case "btnabs":
			txt = "abs";
			this.display+=txt;
			break;
		case "btnacos":
			if (this.btnradio=="rad")
				txt = "acos(";
			else
				txt = "acosd(";

			this.display+=txt;
			break;
		case "btnasin":
			if (this.btnradio=="rad")
				txt = "sin(";
			else
				txt = "sind(";
			this.display+=txt;
			break;
		case "btnatan":
			if (this.btnradio=="rad")
				txt = "atan(";
			else
				txt = "atand(";
			this.display+=txt;
			break;
		case "btncbrt":
			txt = "cbrt";
			this.display+=txt;
			break;
		case "btnceil":
			txt = "ceil";
			this.display+=txt;
			break;
		case "btncos":
			if (this.btnradio=="rad")
				txt = "cos(";
			else
				txt = "cosd(";
			this.display+=txt;
			break;
		case "btncosh":
			txt = "cosh";
			if (this.btnradio=="rad")
				txt = "cosh(";
			else
				txt = "coshd(";
			this.display+=txt;
			break;
		case "btnexp":
			txt = "exp^";
			this.display+=txt;
			break;
		case "btnfloor":
			txt = "floor";
			this.display+=txt;
			break;
		case "btnlog2":
			txt = "log2(";
			this.display+=txt;
			break;
		case "btnlog":
			txt = "log(";
			this.display+=txt;
			break;
		case "btnlog10":
			txt = "log10(";
			this.display+=txt;
			break;
		case "btnsin":
			if (this.btnradio=="rad")
				txt = "sin(";
			else
				txt = "sind(";
			this.display+=txt;
			break;
		case "btnsinh":
			if (this.btnradio=="rad")
				txt = "sinh(";
			else
				txt = "sinhd(";
			this.display+=txt;
			break;
		case "btnsqrt":
			txt = "sqrt(";
			this.display+=txt;
			break;
		case "btntan":
			if (this.btnradio=="rad")
				txt = "tan(";
			else
				txt = "tand(";
			this.display+=txt;
			break;
		case "btntanh":
			if (this.btnradio=="rad")
				txt = "tanh(";
			else
				txt = "tanhd(";
			this.display+=txt;
			break;
		case "btnfact":
			txt = "!";
			this.display+=txt;
			break;
		case "btn-x-power-y":
			txt = "^";
			this.display+=txt;
			break;
		case "btn-x-root-y":
			txt = "^(1/";
			this.display+=txt;
			break;
		case "btnpi":
			txt = "3.141592653589793238";
			this.display+= txt;
			break;
		case "btnplus":
			txt = "+";
			this.display+= txt;
			break;
		case "btnminus":
			txt = "-";
			this.display+= txt;
			break;
		case "btntimes":
			txt = "*";
			this.display+= txt;
			break;
		case "btndivby":
			txt = "/";
			this.display+= txt;
			break;
		case "btncoma":
			txt = ".";
			this.display+= txt;
			break;
		case "btnclear":
			txt = "";
			this.display="";
			break;
		}
		
	}

	//função de interface entre o cliente e o servidor
	public void btnequal() {
		String aux, aux3;
		this.tempo_inicial = System.nanoTime();
		this.tempo_final = 0;  
		this.diferencatempo=0;  
		//envia o valor da expressão introduzida para efectuar o calculo
		calc.setExp(this.display);
		//o resultado toma o valor devolvido após calculo da expressao
		this.tempo_final=System.nanoTime(); 
		this.diferencatempo=(tempo_final-tempo_inicial)/1000;
		this.resultado=calc.getExp();
		//this.display=this.resultado;

		if (calc.isExpValida()){
			//envia o valor da expressão introduzida para o historico
			pickHist.setHist(this.display);
			//envia o resultado do calculo da expressão para o historico
			pickHist.setResultado(this.resultado);
			//envia o valor do tempo do cálculo da expressão para o histórico
			pickHist.setTempo(this.diferencatempo);
			//envio para os dados estatisticos
			est.setResultado(this.display);
			this.display=this.resultado;
		} else{
			//envia o valor da expressão introduzida para o historico mas nao contabiliza na estatistica
			pickHist.init(this.display);
			//envia o valor do tempo do cálculo da expressão para o histórico
			pickHist.setTempo(this.diferencatempo);
		}

	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}
}
