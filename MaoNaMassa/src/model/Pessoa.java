package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Pessoa {
	
	private String nome;
	private LocalDate dataNascimento;
	
	public Pessoa () {
	}
	
	public Pessoa(String nome, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Nome: " + nome + ", Data de Nascimento: " + dataNascimento.format(formatar);
	}

	public int compareTo(Funcionario fun1, Funcionario fun2) {
		return 0;
	}
	
	
}
