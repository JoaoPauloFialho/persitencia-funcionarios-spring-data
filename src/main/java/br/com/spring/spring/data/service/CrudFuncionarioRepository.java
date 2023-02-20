package br.com.spring.spring.data.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.spring.spring.data.orm.Cargo;
import br.com.spring.spring.data.orm.Funcionario;
import br.com.spring.spring.data.orm.FuncionarioProjecao;
import br.com.spring.spring.data.orm.UnidadeDeTrabalho;
import br.com.spring.spring.data.repository.FuncionarioRepository;
import br.com.spring.spring.data.repository.UnidadeDeTrabalhoRepository;

@Service
public class CrudFuncionarioRepository {
	private final FuncionarioRepository repository;
	private final UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository;

	public CrudFuncionarioRepository(FuncionarioRepository repository,
			UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository) {
		this.repository = repository;
		this.unidadeDeTrabalhoRepository = unidadeDeTrabalhoRepository;
	}

	public List<UnidadeDeTrabalho> cadastrarUnidadesDoFuncionario() {
		List<UnidadeDeTrabalho> unidades = new ArrayList<>();

		while (true) {
			Iterable<UnidadeDeTrabalho> todasUnidades = this.unidadeDeTrabalhoRepository.findAll();
			todasUnidades.forEach(unidade -> System.out.println(unidade));
			System.out.println("Digite o id de uma unidade (0 para sair)");
			Long id = new Scanner(System.in).nextLong();
			if (id == 0) {
				break;
			}
			Optional<UnidadeDeTrabalho> unidade = this.unidadeDeTrabalhoRepository.findById(id);
			unidades.add(unidade.get());
		}
		return unidades;
	}

	public void adicionar(String nome, String cpf, BigDecimal salario, Cargo cargo) {
		List<UnidadeDeTrabalho> unidadesTrabalho = this.cadastrarUnidadesDoFuncionario();
		Funcionario funcionario = new Funcionario(nome, cpf, salario, cargo, unidadesTrabalho);
		this.repository.save(funcionario);
		System.out.println("Funcionario adicionado");
	}

	public void atualizar(Long id, String nome, String cpf, BigDecimal salario, Cargo cargo) {
		List<UnidadeDeTrabalho> unidadesTrabalho = this.cadastrarUnidadesDoFuncionario();
		Funcionario funcionario = new Funcionario(nome, cpf, salario, cargo, unidadesTrabalho);
		this.repository.save(funcionario);
		System.out.println("Funcionario adicionado");
	}

	public void remover(Long id) {
		this.repository.deleteById(id);
		System.out.println("Funcionario excluído");
	}

	public void visualizar(Integer pagina) {

		Pageable pageable = PageRequest.of(pagina, 5, Sort.by(Sort.Direction.ASC, "nome"));
		Page<Funcionario> funcionarios = this.repository.findAll(pageable);
		System.out.println(funcionarios);
		System.out.println("Pagina atual " + funcionarios.getNumber() + 1);
		System.out.println("Total de paginas " + funcionarios.getTotalPages());
		System.out.println("Total elementos " + funcionarios.getTotalElements());
		funcionarios.forEach(funcionario -> {
			System.out.println(funcionario);
		});
	}

	public void pesquisaFuncionarioSalario() {
		List<FuncionarioProjecao> lista = this.repository.findFuncionarioSalario();
		lista.forEach(f -> System.out.println("Id -> " + 
				f.getId() + "|| Nome -> " + 
				f.getNome() + "|| Salario -> " +
				f.getSalario()));
	}
}
