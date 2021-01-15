package br.ufscar.dc.pibd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.pibd.classes.Telefone;
import br.ufscar.dc.pibd.dao.ITelefoneDAO;
import br.ufscar.dc.pibd.service.spec.ITelefoneService;

public class TelefoneService implements ITelefoneService{

	@Autowired
	ITelefoneDAO dao;
	
	public void save(Telefone telefone) {
		dao.save(telefone);
	}

	public void remove(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Telefone findById(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Telefone> findAll() {
		return dao.findAll();
	}
}
