package br.ufscar.dc.pibd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.pibd.classes.Agenda;
import br.ufscar.dc.pibd.classes.Pessoa;

@SuppressWarnings("unchecked")
public interface IAgendaDAO extends CrudRepository<Agenda, Long> {
	Agenda findById(long id);

	List<Agenda> findAll();

	Agenda save(Agenda agenda);
	
	@Query("SELECT DISTINCT a FROM Agenda a WHERE a.contactante.id = :contactanteId OR a.contato.id=:contactanteId")
	public List<Agenda> findAllByContactante(@Param("contactanteId")Long contactanteId);

	void deleteById(Long id);

//	@Query("SELECT DISTINCT a.contato, a.contactante from Agenda a WHERE a.contactante.id != :pessoaId AND a.contato != :pessoaId")
//	SELECT a.contato FROM Agenda a NOT IN
//	
//	(SELECT a.contato from Agenda a WHERE a.contato != :pessoaId
//	UNION ALL SELECT a.contactante from Agenda a WHERE a.contactante != :pessoaId)
//	
//	
//SELECT a.contato_id FROM agenda a WHERE a.contato_id!=1 AND a.contato_id NOT IN
//	
//	(SELECT a.contactante_id from agenda a WHERE a.contato_id = 1
//	UNION ALL 
//	SELECT a.contato_id from agenda a WHERE a.contactante_id = 1 ) ;
	@Query("SELECT DISTINCT a.contato, a.contactante from Agenda a WHERE a.contactante.id != :pessoaId AND a.contato != :pessoaId")
	public List<Pessoa> findAllNotInAgenda(@Param("pessoaId")Long pessoaId);
	
}
