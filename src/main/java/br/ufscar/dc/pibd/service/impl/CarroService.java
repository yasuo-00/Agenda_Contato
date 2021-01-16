package br.ufscar.dc.pibd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.pibd.classes.Carro;
import br.ufscar.dc.pibd.classes.Pessoa;
import br.ufscar.dc.pibd.dao.ICarroDAO;
import br.ufscar.dc.pibd.service.spec.ICarroService;

@Service
@Transactional(readOnly = false)
public class CarroService implements ICarroService{
	@Autowired
	ICarroDAO dao;
	
	public void save(Carro carro) {
		dao.save(carro);
	}

	public void remove(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Carro findById(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Carro> findAll() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	public List<Carro> findAllByPessoa(Pessoa p) {
		return dao.findAllByPessoa(p);
	}
	
}
