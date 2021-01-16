package br.ufscar.dc.pibd.service.spec;

import java.util.List;

import br.ufscar.dc.pibd.classes.Telefone;

public interface ITelefoneService {
	Telefone findById(Long id);

	List<Telefone> findAll();

	void save(Telefone telefone);

	void remove(Long id);
	
	List<Telefone> findAllByPessoa(Long id);
}
