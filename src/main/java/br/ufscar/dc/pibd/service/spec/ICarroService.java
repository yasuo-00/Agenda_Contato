package br.ufscar.dc.pibd.service.spec;

import java.util.List;

import br.ufscar.dc.pibd.classes.Carro;

public interface ICarroService {

	Carro findById(Long id);

	List<Carro> findAll();

	void save(Carro carro);
	
	List<Carro> findAllByPessoa(Long pessoaId);

	void remove(Long id);
}
