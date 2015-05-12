package pt.uc.dei.aor.paj;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

@Named
@SessionScoped
public class PickListView implements Serializable {
	private static final long serialVersionUID = -1183677189929476404L;
	
	
	private ArrayList<String> hist;
	private ArrayList<Double> tempo;
	private ArrayList<String> resultado;

	public ArrayList<String> getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado.add(resultado);
	}

	@PostConstruct
	public void init() {
		hist = new ArrayList<String>(); 
		tempo=new ArrayList<Double>();
		resultado=new ArrayList<String>();
	}

	public void init(String exp){
		hist.add(exp);
	}

	public ArrayList<String> getHist() {
		return hist;
	}

	public void setHist(String exp) {
		this.hist.add(exp);
	} 
	
	public ArrayList<Double> getTempo() {
		return tempo;
	}

	public void setTempo(double time) {
		this.tempo.add(time);
	}
}
