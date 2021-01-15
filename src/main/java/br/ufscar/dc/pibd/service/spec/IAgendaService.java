package br.ufscar.dc.pibd.service.spec;

import java.util.List;

import br.ufscar.dc.pibd.classes.Agenda;

public interface IAgendaService {
	Agenda findById(Long id);

	List<Agenda> findAll();

	void save(Agenda agenda);

	void remove(Long id);

}
