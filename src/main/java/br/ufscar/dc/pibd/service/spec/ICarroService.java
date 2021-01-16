package br.ufscar.dc.pibd.service.spec;

import java.util.List;

import br.ufscar.dc.pibd.classes.Carro;
import br.ufscar.dc.pibd.classes.Pessoa;

public interface ICarroService {

	Carro findById(Long id);

	List<Carro> findAll();

	void save(Carro carro);
	
	List<Carro> findAllByPessoa(Pessoa p);

	void remove(Long id);
}
