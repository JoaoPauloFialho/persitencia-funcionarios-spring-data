package br.com.spring.spring.data.orm;

import java.util.List;

import br.com.spring.spring.modelos.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidades_de_trabalho")
public class UnidadeDeTrabalho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@Embedded
	private Endereco endereco;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Funcionario> funcionarios;

	public UnidadeDeTrabalho() {
	}

	public UnidadeDeTrabalho(
			String descricao, 
			String rua, 
			String bairro, 
			String cidade, 
			String numero) {
		this.descricao = descricao;
		this.endereco = new Endereco(rua, bairro, cidade, numero);
	}
	
	public UnidadeDeTrabalho(
			Long id,
			String descricao, 
			String rua, 
			String bairro, 
			String cidade, 
			String numero) {
		this(
			descricao, 
			rua, 
			bairro, 
			cidade, 
			numero);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@Override
	public String toString() {
		return "Id -> " + this.id + " ||| Unidade -> " + this.descricao;
	}

}
