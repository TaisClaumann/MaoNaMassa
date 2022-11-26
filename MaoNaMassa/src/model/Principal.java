package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal implements Comparator<Funcionario>{

	public static void main(String[] args) {
		
		Principal main = new Principal();
		List<Funcionario> funcionarios = main.inserirFuncionarios();
		JOptionPane.showMessageDialog(null, main.mostrarDados(funcionarios));
	}
	
	public List<Funcionario> inserirFuncionarios() {
		List<Funcionario> lista = new ArrayList<>();
		lista.add(inserirFuncionario("Maria", LocalDate.of(2000, 10, 18), 2009.44, "Operador"));
		lista.add(inserirFuncionario("João", LocalDate.of(1990, 05, 12), 2284.38, "Operador"));
		lista.add(inserirFuncionario("Caio", LocalDate.of(1961, 05, 02), 9836.14, "Coordenador"));
		lista.add(inserirFuncionario("Miguel", LocalDate.of(1988, 10, 14), 19119.88, "Diretor"));
		lista.add(inserirFuncionario("Alice", LocalDate.of(1955, 01, 05), 2234.68, "Recepcionista"));
		lista.add(inserirFuncionario("Heitor", LocalDate.of(1999, 11, 19), 1582.72, "Operador"));
		lista.add(inserirFuncionario("Arthur", LocalDate.of(1993, 03, 31), 4071.84, "Operador"));
		lista.add(inserirFuncionario("Heitor", LocalDate.of(1999, 11, 19), 1582.72, "Contador"));
		lista.add(inserirFuncionario("Laura", LocalDate.of(1994, 07, 8), 3017.45, "Gerente"));
		lista.add(inserirFuncionario("Heloísa", LocalDate.of(2003, 05, 24), 1582.72, "Eletricista"));
		lista.add(inserirFuncionario("Helena", LocalDate.of(1996, 9, 02), 1582.72, "Gerente"));
		JOptionPane.showMessageDialog(null, mostrarDados(lista));
		
		//Removendo João
		for(int i = 0; i < lista.size(); i++) {
			Funcionario f = lista.get(i);
				if(f.getNome().equals("João")) {
					lista.remove(f);
					break;
				}
		}
		
		aumentoSalario(lista);
		aniversario(lista);
		buscarFuncionarioMaisVelho(lista);
		imprimirOrdemAlfabetica(lista);
		totalSalarioFuncionarios(lista);
		salarioMinimoPorFuncionario(lista);
		
		return lista;
	}
	
	public Funcionario inserirFuncionario(String nome, LocalDate dataNascimento, Double salario, String funcao) {
		Funcionario f = new Funcionario(nome, dataNascimento, BigDecimal.valueOf(salario), funcao);
		return f;
	}
	
	public List<Funcionario> aumentoSalario(List<Funcionario> funcionarios) {
		List<Funcionario> listaAumento = new ArrayList<>();
		double porcentagem = 0.10;
		
		for (Funcionario f : funcionarios) {
			Double salario = f.getSalario().doubleValue();
			salario = salario + (porcentagem * salario);
			f.setSalario(BigDecimal.valueOf(salario));
			
			funcionarios = listaAumento;
		}
		
		return listaAumento;
	}
	
	public List<Funcionario> aniversario(List<Funcionario> funcionarios) {
		List<Funcionario> funAniversarios = new ArrayList<>();
		
		for (Funcionario f : funcionarios) {
			LocalDate aniversario = f.getDataNascimento();
			
			if(aniversario.getMonth() == Month.OCTOBER || aniversario.getMonth() == Month.DECEMBER ) {
				f.setDataNascimento(aniversario);
				funAniversarios.add(f);
			} 
		}
		
		JOptionPane.showMessageDialog(null, mostrarDados(funAniversarios));
		return funAniversarios;
	}
	
	public String buscarFuncionarioMaisVelho(List<Funcionario> funcionarios) {
		Funcionario funcionario = new Funcionario();
		funcionario.setDataNascimento(LocalDate.now());
		String msg = "";
	
		for (Funcionario f : funcionarios) {
			if(f.getDataNascimento().isBefore(funcionario.getDataNascimento())) {
				funcionario = f;
			}
		}
		msg = "Nome " + funcionario.getNome() + ", Idade: " + LocalDate.now().compareTo(funcionario.getDataNascimento());
		
		return msg;
	}
	
	public List<Funcionario> imprimirOrdemAlfabetica(List<Funcionario> funcionarios) {
		funcionarios.sort(null);
		mostrarDados(funcionarios);
		
		return funcionarios;
	}
	
	public String totalSalarioFuncionarios(List<Funcionario> funcionarios) {
		DecimalFormat def = new DecimalFormat("###,###.00");
		DecimalFormatSymbols defsym = new DecimalFormatSymbols();
		defsym.setGroupingSeparator('.');
		def.setDecimalFormatSymbols(defsym);
		
		double soma = funcionarios.stream().map(f -> f.getSalario()).mapToDouble(BigDecimal::doubleValue).sum();
		String msg = "Salario total dos funcionarios: R$" + def.format(soma);
		
		JOptionPane.showMessageDialog(null, msg);
		return msg;
	}
	
	public String salarioMinimoPorFuncionario(List<Funcionario> funcionarios) {
		List<String> listaSalariosMinimosPorFuncionario = new ArrayList<>();
		DecimalFormat def = new DecimalFormat("###,###.00");
		
		double salarioMinimo = 1212.0;
		String msg = "";
		
		for (Funcionario f : funcionarios) {
			double divisao = f.getSalario().doubleValue() / salarioMinimo;
			BigDecimal resultado = BigDecimal.valueOf(divisao);
			msg += "Nome: " + f.getNome() + " - Ganha: " + def.format(resultado) + " salários mínimos" + "\n";
		}
		
		JOptionPane.showMessageDialog(null, msg);
		return msg;
	}
	
	
	
	public String mostrarDados(List<Funcionario> funcionarios) {
		String msg = "";
		
		for (Funcionario funcionario : funcionarios) {
			msg += funcionario.toString();
		}
		return msg;
	}

	@Override
	public int compare(Funcionario f1, Funcionario f2) {
		return f1.getNome().compareTo(f2.getNome());
	}

}
