package br.ufscar.dc.pibd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.pibd.classes.Agenda;
import br.ufscar.dc.pibd.classes.Pessoa;
import br.ufscar.dc.pibd.dao.IAgendaDAO;
import br.ufscar.dc.pibd.service.spec.IAgendaService;

@Service
@Transactional(readOnly = false)
public class AgendaService implements IAgendaService{
	@Autowired
	IAgendaDAO dao;
	
	public void save(Agenda agenda) {
		dao.save(agenda);
	}

	public void remove(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Agenda findById(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Agenda> findAll() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Agenda> findAllByContactante(Long contactanteId) {
		return dao.findAllByContactante(contactanteId);
	}
	
}
