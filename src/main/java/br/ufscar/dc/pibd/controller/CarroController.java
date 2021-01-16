package br.ufscar.dc.pibd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.pibd.classes.Carro;
import br.ufscar.dc.pibd.classes.Pessoa;
import br.ufscar.dc.pibd.security.UserAccount;
import br.ufscar.dc.pibd.service.spec.ICarroService;

@Controller
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	private ICarroService carroService;

	private Pessoa getPessoa() {
		UserAccount usuarioDetails = (UserAccount) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return usuarioDetails.getUser();
	}

	@GetMapping("/listar")
	public String list(ModelMap model) {
		if (this.getPessoa().getRole().compareTo("ROLE_ADMIN") == 0) {
			model.addAttribute("carros", carroService.findAll());
		} else if (this.getPessoa().getRole().compareTo("ROLE_USER") == 0) {
			model.addAttribute("carros", carroService.findAllByPessoa(this.getPessoa().getId()));
		}
		return "carro/lista";
	}

	@PostMapping("/salvar")
	public String save(Carro carro, BindingResult result, RedirectAttributes attr) {

		carro.setPessoa(this.getPessoa());
		carroService.save(carro);
		attr.addFlashAttribute("success", "Carro inserted successfully");
		return "redirect:/carro/listar";
	}

	@GetMapping("/cadastrar")
	public String register(Carro carro) {
		carro.setPessoa(this.getPessoa());
		return "carro/cadastro";
	}

}
