package br.ufscar.dc.pibd.classes;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "agenda", uniqueConstraints={
	    @UniqueConstraint(columnNames = {"data_inicio_amizade","contato_id", "contactante_id"})})
@DynamicUpdate
public class Agenda {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition = "INTEGER")
	Long id;
	
	@Column(name = "data_inicio_amizade")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicioAmizade;
	
	@ManyToOne
	@JoinColumn(name = "contato_id")
	private Pessoa contato;
	
	@ManyToOne
	@JoinColumn(name = "contactante_id")
	private Pessoa contactante;

	
	
	public Agenda() {
		super();
	}



	public Agenda(LocalDate dataInicioAmizade, Pessoa contato, Pessoa contactante) {
		super();
		this.dataInicioAmizade = dataInicioAmizade;
		this.contato = contato;
		this.contactante = contactante;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDate getDataInicioAmizade() {
		return dataInicioAmizade;
	}



	public void setDataInicioAmizade(LocalDate dataInicioAmizade) {
		this.dataInicioAmizade = dataInicioAmizade;
	}



	public Pessoa getContato() {
		return contato;
	}



	public void setContato(Pessoa contato) {
		this.contato = contato;
	}



	public Pessoa getContactante() {
		return contactante;
	}



	public void setContactante(Pessoa contactante) {
		this.contactante = contactante;
	}



	@Override
	public int hashCode() {
		return Objects.hash(contactante, contato, dataInicioAmizade, id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(contactante, other.contactante) && Objects.equals(contato, other.contato)
				&& Objects.equals(dataInicioAmizade, other.dataInicioAmizade) && Objects.equals(id, other.id);
	}
	
	
	
}
