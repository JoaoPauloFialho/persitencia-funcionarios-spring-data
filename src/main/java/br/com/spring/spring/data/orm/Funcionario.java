package br.com.spring.spring.data.orm;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String nome;
	private String cpf;
	private BigDecimal salario;
	private LocalDate dataContratacao = LocalDate.now();
	@ManyToOne
	@JoinColumn(name = "cargo")
	private Cargo cargo;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "funcionario_unidades", joinColumns = {
			@JoinColumn(name = "fk_funcionario")},
	inverseJoinColumns = {@JoinColumn(name = "fk_unidade")}
	)
	private List<UnidadeDeTrabalho> unidadeTrabalhos;
	

	public Funcionario() {
	}

	public Funcionario(String nome, String cpf, BigDecimal salario, Cargo cargo, List<UnidadeDeTrabalho> unidadesTrabalho) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.cargo = cargo;
		this.unidadeTrabalhos = unidadesTrabalho;
	}

	public Funcionario(Long id, String nome, String cpf, BigDecimal salario, Cargo cargo, List<UnidadeDeTrabalho> unidadesTrabalho) {
		this(nome, cpf, salario, cargo, unidadesTrabalho);
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	@Override
	public String toString() {
		return "Id -> " + this.id + "||| Nome -> " + this.nome 
				+ "||| Cpf -> " + this.cpf + "||| Salario -> " + this.salario
				+ "||| Cargo -> " + this.cargo.getDescricao();
	}

}
