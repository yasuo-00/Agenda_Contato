package br.ufscar.dc.pibd.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.pibd.classes.Carro;
import br.ufscar.dc.pibd.classes.Pessoa;

@SuppressWarnings("unchecked")
public interface ICarroDAO extends CrudRepository<Carro, Long> {
	Carro findById(long id);

	List<Carro> findAll();

	Carro save(Carro carro);
	
	List<Carro> findAllByPessoa(Pessoa p);

	void deleteById(Long id);
}
