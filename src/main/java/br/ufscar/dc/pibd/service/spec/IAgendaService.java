package br.ufscar.dc.pibd.service.spec;

import java.util.List;

import br.ufscar.dc.pibd.classes.Agenda;
import br.ufscar.dc.pibd.classes.Pessoa;

public interface IAgendaService {
	Agenda findById(Long id);

	List<Agenda> findAll();
	
	List<Agenda> findAllByContactante(Pessoa p);

	void save(Agenda agenda);

	void remove(Long id);
	

}
