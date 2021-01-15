package br.ufscar.dc.pibd.service.spec;

import java.util.List;

import br.ufscar.dc.pibd.classes.Pessoa;

public interface IPessoaService {

	Pessoa findById(Long id);

	List<Pessoa> findAll();

	void save(Pessoa pessoa);

	void remove(Long id);

}
