package br.ufscar.dc.pibd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.pibd.classes.Pessoa;

@SuppressWarnings("unchecked")
public interface  IPessoaDAO extends CrudRepository<Pessoa, Long> {
	Pessoa findById(long id);

	List<Pessoa> findAll();

	Pessoa save(Pessoa pessoa);

	void deleteById(Long id);
	
	@Query("SELECT p FROM Pessoa p WHERE p.email = :email")
	public Pessoa getPessoaByEmail(@Param("email") String email);
}
