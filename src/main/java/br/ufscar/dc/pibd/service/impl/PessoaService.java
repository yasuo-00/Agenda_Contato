package br.ufscar.dc.pibd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.pibd.classes.Pessoa;
import br.ufscar.dc.pibd.dao.IPessoaDAO;
import br.ufscar.dc.pibd.service.spec.IPessoaService;

public class PessoaService implements IPessoaService{

	@Autowired
	IPessoaDAO dao;

	public void save(Pessoa pessoa) {
		dao.save(pessoa);
	}

	public void remove(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Pessoa findById(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Pessoa> findAll() {
		return dao.findAll();
	}
}
