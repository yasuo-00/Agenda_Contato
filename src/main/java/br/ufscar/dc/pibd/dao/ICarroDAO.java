package br.ufscar.dc.pibd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.pibd.classes.Carro;
import br.ufscar.dc.pibd.classes.Pessoa;

@SuppressWarnings("unchecked")
public interface ICarroDAO extends CrudRepository<Carro, Long> {
	Carro findById(long id);

	List<Carro> findAll();

	Carro save(Carro carro);
	
	@Query("SELECT c FROM Carro c WHERE c.pessoa.id = :pessoaId")
	public List<Carro> findAllByPessoa(@Param("pessoaId")Long pessoaId);

	void deleteById(Long id);
}
