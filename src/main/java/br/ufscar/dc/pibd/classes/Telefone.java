package br.ufscar.dc.pibd.classes;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "telefone")
@DynamicUpdate
public class Telefone {
		
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition = "INTEGER")
	Long id;
	
	@Size(max = 2)
	@Column(name="prefixo", length= 2 )
	String prefixo;
	
	@Size(max = 2)
	@Column(name="ddd", length= 2)
	String ddd;
	
	@Size(max = 9)
	@Column(name="numero", length= 9)
	String numero;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	Pessoa dono;
	
	

	public Telefone() {
		
	}

	public Telefone( @Size(max = 2) String prefixo, @Size(max = 2) String ddd, @Size(max = 9) String numero,
			Pessoa dono) {
		this.prefixo = prefixo;
		this.ddd = ddd;
		this.numero = numero;
		this.dono = dono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Pessoa getDono() {
		return dono;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ddd, dono, id, numero, prefixo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(ddd, other.ddd) && Objects.equals(dono, other.dono) && Objects.equals(id, other.id)
				&& Objects.equals(numero, other.numero) && Objects.equals(prefixo, other.prefixo);
	}
	
	

	
}
