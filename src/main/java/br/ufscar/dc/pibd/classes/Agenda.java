package br.ufscar.dc.pibd.classes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "agenda")
@DynamicUpdate
public class Agenda {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition = "INTEGER")
	Long id;
	
	@Column(name = "data_inicio_amizade")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicioAmizade;
}
