package br.ufscar.dc.pibd.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.pibd.classes.Carro;

@SuppressWarnings("unchecked")
public interface ICarroDAO extends CrudRepository<Carro, Long> {
	Carro findById(long id);

	List<Carro> findAll();

	Carro save(Carro carro);

	void deleteById(Long id);
}
