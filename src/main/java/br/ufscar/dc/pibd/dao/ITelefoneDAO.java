package br.ufscar.dc.pibd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.pibd.classes.Telefone;

@SuppressWarnings("unchecked")
public interface ITelefoneDAO extends CrudRepository<Telefone, Long> {
	Telefone findById(long id);

	List<Telefone> findAll();

	Telefone save(Telefone telefone);

	void deleteById(Long id);
	
	@Query("SELECT t FROM Telefone t WHERE t.dono.id = :pessoaId")
	public List<Telefone> findAllByPessoa(@Param("pessoaId") Long pessoaId);
}
