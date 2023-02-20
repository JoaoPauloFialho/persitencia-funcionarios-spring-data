package br.com.spring.spring.data.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

import org.springframework.stereotype.Service;

import br.com.spring.spring.data.orm.Funcionario;
import br.com.spring.spring.data.repository.FuncionarioRepository;

@Service
public class RelatorioService {
	
	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatorioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void buscaFuncionarioNome(String nome) {
		List<Funcionario> funcionarios = this.funcionarioRepository.findByNome(nome);
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}
	
	public void buscaMaiorSalarioDataContratacao(BigDecimal salario, String data) {
		LocalDate date = LocalDate.parse(data, formatter);
		List<Funcionario> funcionarios = this.funcionarioRepository.findSalarioMaiorDataContratacao(salario, date);
	}
	
}