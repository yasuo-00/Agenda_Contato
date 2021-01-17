package br.ufscar.dc.pibd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.pibd.classes.Agenda;
import br.ufscar.dc.pibd.classes.Carro;
import br.ufscar.dc.pibd.classes.Pessoa;
import br.ufscar.dc.pibd.classes.Telefone;
import br.ufscar.dc.pibd.dao.IAgendaDAO;
import br.ufscar.dc.pibd.dao.ICarroDAO;
import br.ufscar.dc.pibd.dao.IPessoaDAO;
import br.ufscar.dc.pibd.dao.ITelefoneDAO;


@SpringBootApplication
public class SpringMVCApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringMVCApplication.class);

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(SpringMVCApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BCryptPasswordEncoder encoder, IPessoaDAO pDao, ITelefoneDAO tDao, IAgendaDAO aDao, ICarroDAO cDao) {
		return (args) -> {
			
//			Pessoa p1 = new Pessoa(email, password, homepage, prenome, nome, dataNascimento, logradouro, numero, bairro, cep, complemento, uf, cidade, telefones, carros, role)
//			
//			Carro c1 = new Carro(cor, placa, ano, modelo, pessoas)
//			
//			Telefone t1 = new Telefone(prefixo, ddd, numero, dono)
//			
//			Agenda a1 = new Agenda(dataInicioAmizade, contato, contactante)
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			Pessoa ana = new Pessoa("ana@gmail.com", encoder.encode("ana123"), "site2", "lúcia", "ana", LocalDate.parse("01/02/1998", formatter), "Rua da Luz", 121, "Brasil", "112345", "Casa", "SP", "São Carlos",  "ROLE_USER");

			Pessoa lucas = new Pessoa("lucas@gmail.com", encoder.encode("lucas123"), "site3", "almeida", "hugo", LocalDate.parse("01/03/1998", formatter), "Rua Sé", 131, "Brasil", "122456", "Casa", "São Paulo", "Campinas", "ROLE_USER");

			Pessoa hugo = new Pessoa("hugo@gmail.com", encoder.encode("hugo123"), "site1", "santos", "hugo", LocalDate.parse("01/01/1998", formatter), "Rua Vieira", 111, "Brasil", "123456", "Casa", "São Paulo", "São Paulo", "ROLE_USER");
			
			pDao.save(ana);
			pDao.save(lucas);
			pDao.save(hugo);
			
			Telefone t1 = new Telefone("55","16", "123456789", ana);

			Telefone t2 = new Telefone("55", "16", "112345678", lucas);

			Telefone t3 = new Telefone("55", "16", "122345634", hugo);

			tDao.save(t1);
			tDao.save(t2);
			tDao.save(t3);
			
			Agenda a1= new Agenda(LocalDate.parse("02/01/2020", formatter), ana, lucas);

			Agenda a2 = new Agenda(LocalDate.parse("03/01/2020", formatter), ana, hugo);

			//Agenda a3 = new Agenda(LocalDate.parse("03/01/2020", formatter), lucas, hugo);
			
			aDao.save(a1);
			aDao.save(a2);
			//aDao.save(a3);
			
			Carro c1 = new Carro("azul", "abc", 2020, "sedan", ana);

			Carro c2 = new Carro("vermelho", "abb", 2019, "sedan", lucas);

			Carro c3 = new Carro("azul", "acc", 2018, "sedan", hugo);
			
			cDao.save(c1);
			cDao.save(c2);
			cDao.save(c3);
			
		};
	}
}
