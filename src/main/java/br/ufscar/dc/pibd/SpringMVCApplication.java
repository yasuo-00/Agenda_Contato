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

import br.ufscar.dc.dsw.classes.BookingSite;
import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.classes.SaleOff;
import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.pibd.classes.Pessoa;


@SpringBootApplication
public class SpringMVCApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringMVCApplication.class);

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(SpringMVCApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BCryptPasswordEncoder encoder) {
		return (args) -> {
			
			
			
			
		};
	}
}
