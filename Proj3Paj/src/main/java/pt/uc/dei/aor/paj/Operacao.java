package pt.uc.dei.aor.paj;
public class Operacao {
	
	private int id;
	private String comando;
	private String resultado;
	
	
	public Operacao(int id, String comando, String resultado) {
		super();
		this.id = id;
		this.comando = comando;
		this.resultado = resultado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}