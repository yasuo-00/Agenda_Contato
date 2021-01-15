package br.ufscar.dc.pibd.classes;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pessoa")
@DynamicUpdate
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INTEGER")
	Long id;

	@Column(name = "email")
	String email;
	
	@Column(name = "password")
	String password;

	@Column(name = "homepage")
	String homepage;

	@Column(name = "prenome")
	String prenome;

	@Column(name = "nome")
	String nome;

	@Column(name = "data_nascimento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate dataNascimento;

	@Column(name = "logradouro")
	String logradouro;

	@Column(name = "numero")
	int numero;

	@Column(name = "bairo")
	String bairro;

	@Column(name = "cep")
	String cep;

	@Column(name = "complemento")
	String complemento;

	@Column(name = "uf")
	String uf;

	@Column(name = "cidade")
	String cidade;

	@OneToMany(mappedBy = "dono")
	@Cascade(CascadeType.ALL)
	private List<Telefone> telefones;

	@ManyToMany
	@JoinTable(name = "pessoa_has_carros", joinColumns = { @JoinColumn(name = "pessoa_id") }, inverseJoinColumns = {
			@JoinColumn(name = "carro_id") })
	private List<Carro> carros;

	@Column(nullable = false, length = 20)
	private String role;

	@OneToMany(mappedBy = "contato")
	@Cascade(CascadeType.ALL)
	private List<Agenda> agendaContato;
	
	@OneToMany(mappedBy = "contactante")
	@Cascade(CascadeType.ALL)
	private List<Agenda> agendaContactante;
	
	public Pessoa() {
	}
	
	

	public Pessoa(String email, String password, String homepage, String prenome, String nome,
			LocalDate dataNascimento, String logradouro, int numero, String bairro, String cep, String complemento,
			String uf, String cidade, String role) {
		this.email = email;
		this.password = password;
		this.homepage = homepage;
		this.prenome = prenome;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.complemento = complemento;
		this.uf = uf;
		this.cidade = cidade;
		this.role = role;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getPrenome() {
		return prenome;
	}

	public void setPrenome(String prenome) {
		this.prenome = prenome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complemento, dataNascimento, email, homepage, id, logradouro, nome,
				numero, prenome, telefones, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
				&& Objects.equals(homepage, other.homepage) && Objects.equals(id, other.id)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(nome, other.nome)
				&& numero == other.numero && Objects.equals(prenome, other.prenome)
				&& Objects.equals(telefones, other.telefones) && Objects.equals(uf, other.uf);
	}

}
