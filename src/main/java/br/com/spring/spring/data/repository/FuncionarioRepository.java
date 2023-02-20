package br.com.spring.spring.data.repository;

import org.springframework.stereotype.Repository;

import br.com.spring.spring.data.orm.Funcionario;
import br.com.spring.spring.data.orm.FuncionarioProjecao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	List<Funcionario> findByNome(String nome);
	
	@Query("SELECT f FROM Funcionario f WHERE f.salario >= :salario AND f.dataContratacao = :data")
	List<Funcionario> findSalarioMaiorDataContratacao(BigDecimal salario, LocalDate data);
	
	@Query(value = "SELECT * FROM funcionarios f where f.data_contratacao >= :data", nativeQuery = true)
	List<Funcionario> findMaiorData(LocalDate data);

	@Query(value = "SELECT f.id, f.nome, f.salario FROM funcionarios f",
			nativeQuery = true)
	List<FuncionarioProjecao> findFuncionarioSalario();
}
