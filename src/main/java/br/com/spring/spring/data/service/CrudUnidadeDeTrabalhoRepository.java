package br.com.spring.spring.data.service;

import org.springframework.stereotype.Service;

import br.com.spring.spring.data.orm.UnidadeDeTrabalho;
import br.com.spring.spring.data.repository.UnidadeDeTrabalhoRepository;

@Service
public class CrudUnidadeDeTrabalhoRepository {
	private UnidadeDeTrabalhoRepository repository;

	public CrudUnidadeDeTrabalhoRepository(UnidadeDeTrabalhoRepository repository) {
		this.repository = repository;
	}

	public void adicionar(String descricao, String rua, String bairro, String cidade, String numero) {
		UnidadeDeTrabalho unidade = new UnidadeDeTrabalho(descricao, rua, bairro, cidade, numero);
		this.repository.save(unidade);
	}

	public void atualizar(Long id, String descricao, String rua, String bairro, String cidade, String numero) {
		UnidadeDeTrabalho unidade = new UnidadeDeTrabalho(id, descricao, rua, bairro, cidade, numero);
		this.repository.save(unidade);
	}
	
	public void visualizar() {
		Iterable<UnidadeDeTrabalho> unidades = this.repository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade));
	}
	
	public void deletar(Long id) {
		this.repository.deleteById(id);
	}

}