package br.com.spring.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.spring.data.orm.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long>{
	
}
