package br.com.spring.spring.data.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.spring.spring.data.orm.Cargo;
import br.com.spring.spring.data.repository.CargoRepository;

//como essa classe é um service é preciso definir aqui com uma anotação
@Service
public class CrudCargoRepository {
	private final CargoRepository repository;

	public CrudCargoRepository(CargoRepository repository) {
		this.repository = repository;
	}

	public void salvar(String descricao) {
		Cargo cargo = new Cargo(descricao);
		this.repository.save(cargo);
		System.out.println("Cargo salvo");
	}

	public void atualizar(Long id, String descricao) {
		Cargo cargo = new Cargo(id, descricao);
		this.repository.save(cargo);
		System.out.println("Cargo atualizado");
	}
	
	public void visualizar() {
		Iterable<Cargo> cargos = this.repository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	public Cargo pegarCargoPorId(Long id) {
		return this.repository.findById(id).get();
	}
	
	public void deletar(Long id) {
		this.repository.deleteById(id);
		System.out.println("Cargo deletado");
	}
}
