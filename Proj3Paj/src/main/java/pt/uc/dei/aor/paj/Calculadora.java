package pt.uc.dei.aor.paj;

import java.io.Serializable;
import java.util.EmptyStackException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;
import net.objecthunter.exp4j.operator.Operator;

@Named
@SessionScoped

public class Calculadora implements Serializable{
	private static final long serialVersionUID = 6030549976219071079L;
	private boolean expValida=true;
	private String exp;

	
	public Calculadora() {
		this.exp = "";
	}
	
//implementação da função factorial
	Operator factorial = new Operator("!", 1, true, Operator.PRECEDENCE_POWER + 1) {

	    @Override
	    public double apply(double... args) {
	        final int arg = (int) args[0];
	        if ((double) arg != args[0]) {
	            throw new IllegalArgumentException("O operando do factorial tem de ser inteiro");
	        }
	        if (arg < 0) {
	            throw new IllegalArgumentException("O operando do factorial não pode ser inferior a zero");
	        }
	        double result = 1;
	        for (int i = 1; i <= arg; i++) {
	            result *= i;
	        }
	        return result;
	    }
	};
	
// definição de novas funções para aplicar na expressao 'ExpressionBuilder'

		Function cosd = new Function("cosd", 1) {
			@Override
			public double apply(double... args) {
				return Math.cos(Math.toRadians(args[0]));
			}
		};

		Function sind = new Function("sind", 1) {
			@Override
			public double apply(double... args) {
				return Math.sin(Math.toRadians(args[0]));
			}
		};
		Function tand = new Function("tand", 1) {
			@Override
			public double apply(double... args) {
				return Math.tan(Math.toRadians(args[0]));
			}
		};
		Function coshd = new Function("coshd", 1) {
			@Override
			public double apply(double... args) {
				return Math.cosh(Math.toRadians(args[0]));
			}
		};

		Function sinhd = new Function("sinhd", 1) {
			@Override
			public double apply(double... args) {
				return Math.sinh(Math.toRadians(args[0]));
			}
		};
		Function tanhd = new Function("tanhd", 1) {
			@Override
			public double apply(double... args) {
				return Math.tanh(Math.toRadians(args[0]));
			}
		};
		Function asind = new Function("asind", 1) {
			@Override
			public double apply(double... args) {
				return Math.asin(Math.toRadians(args[0]));
			}
		};
		Function acosd = new Function("acosd", 1) {
			@Override
			public double apply(double... args) {
				return Math.acos(Math.toRadians(args[0]));
			}
		};
//calcula o resultado da expressão pela lib Exp4j, apanhando as excepções apresentadas durante a execução da lib 
	public String getExp(){
		String result;

		try {
			Expression e = new ExpressionBuilder(this.exp)
			.operator(factorial)
			.function(cosd)
			.function(sind).function(tand).function(sinhd)
			.function(coshd).function(tanhd).function(asind)
			.function(acosd)
			.build();
			
			double result1 = e.evaluate();
			result=result1+"";
		} catch (NumberFormatException nfe) {
			result="NumberFormatException";
			this.expValida=false;
		}catch(EmptyStackException ne){
			result="Parêntesis incorrectos";
			this.expValida=false;
		}catch(ArithmeticException ne){
			result="Divisao por zero";
			this.expValida=false;
		}catch(IllegalArgumentException ne){
			result="Argumentos inválidos";
			this.expValida=false;
		}
		
		setExp(result);
		if (result.equals("O operando do factorial tem de ser inteiro")|| 
				result.equals("O operando do factorial não pode ser inferior a zero"))
			this.expValida=false;
		
		return result;
	}

	public boolean isExpValida() {
		return expValida;
	}

	public void setExpValida(boolean expValida) {
		this.expValida = expValida;
	}

	//actualização do valor da expressão a calcular
	public void setExp(String exp) {
		this.exp = exp;
	}


}
