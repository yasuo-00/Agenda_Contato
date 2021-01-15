package br.ufscar.dc.pibd.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.pibd.classes.Telefone;

@SuppressWarnings("unchecked")
public interface ITelefoneDAO extends CrudRepository<Telefone, Long> {
	Telefone findById(long id);

	List<Telefone> findAll();

	Telefone save(Telefone telefone);

	void deleteById(Long id);
}
