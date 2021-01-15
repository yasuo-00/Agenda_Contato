package br.ufscar.dc.pibd.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.pibd.classes.Agenda;

@SuppressWarnings("unchecked")
public interface IAgendaDAO extends CrudRepository<Agenda, Long> {
	Agenda findById(long id);

	List<Agenda> findAll();

	Agenda save(Agenda agenda);

	void deleteById(Long id);
}
