package br.ufscar.dc.pibd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufscar.dc.pibd.service.spec.IPessoaService;


@Controller
public class IndexController {
	
	private IPessoaService pessoaService;

	@GetMapping("/")
	public String root() {
		return "home";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
