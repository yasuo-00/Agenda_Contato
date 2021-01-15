package br.ufscar.dc.pibd.classes;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "carro")
@DynamicUpdate
public class Carro {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition = "INTEGER")
	Long id;
	
	@Column(name="cor")
	String cor;
	
	@Size(max=4)
	@Column(columnDefinition = "INTEGER", name="ano", length=4)
	int ano;
	
	@Column(name="modelo")
	String modelo;
	
	@ManyToMany(mappedBy = "carros")
	private List<Pessoa> pessoas;

	
	
	
	public Carro() {
	}
	

	public Carro(String cor, @Size(max = 4) int ano, String modelo, List<Pessoa> pessoas) {
		super();
		this.cor = cor;
		this.ano = ano;
		this.modelo = modelo;
		this.pessoas = pessoas;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, cor, id, modelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return ano == other.ano && Objects.equals(cor, other.cor) && Objects.equals(id, other.id)
				&& Objects.equals(modelo, other.modelo);
	}
	
	
}
