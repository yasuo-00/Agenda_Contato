package br.ufscar.dc.pibd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.pibd.classes.Agenda;

@SuppressWarnings("unchecked")
public interface IAgendaDAO extends CrudRepository<Agenda, Long> {
	Agenda findById(long id);

	List<Agenda> findAll();

	Agenda save(Agenda agenda);
	
	@Query("SELECT DISTINCT a FROM Agenda a WHERE a.contactante.id = :contactanteId OR a.contato.id=:contactanteId")
	public List<Agenda> findAllByContactante(@Param("contactanteId")Long contactanteId);

	void deleteById(Long id);
}
