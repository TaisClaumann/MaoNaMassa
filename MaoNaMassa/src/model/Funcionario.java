package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Funcionario extends Pessoa implements Comparable<Funcionario>{
	
	private BigDecimal salario;
	private String funcao;
	
	public Funcionario() {
	}
	
	public Funcionario(String nome, LocalDate dataNascimento ,BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}
	

	public BigDecimal getSalario() {
		return salario;
	} 

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		
		DecimalFormat def = new DecimalFormat("###,###.00");
		DecimalFormatSymbols defsym = new DecimalFormatSymbols();
		defsym.setGroupingSeparator('.');
		def.setDecimalFormatSymbols(defsym);
		
		String resposta = "";
		resposta += super.toString();
		resposta += ", Salario: R$" + def.format(salario) + ", Funcao: " + funcao + "\n";
		return resposta;
	}

	@Override
	public int compareTo(Funcionario fun1) {
		return this.getNome().compareTo(fun1.getNome());
	}
	
	
}
