package br.com.spring.spring.data.orm;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargos")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;
	
	public Cargo() {
		
	}
	
	public Cargo(String descricao) {
		this.descricao = descricao;
	}
	
	public Cargo(Long id, String descricao) {
		this(descricao);
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
	
	@Override
	public String toString() {
		return "Id -> " + this.id + " ||| Descricao -> " + this.descricao;
	}

}
