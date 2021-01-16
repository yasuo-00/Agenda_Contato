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

import br.ufscar.dc.pibd.classes.Pessoa;
import br.ufscar.dc.pibd.classes.Telefone;
import br.ufscar.dc.pibd.security.UserAccount;
import br.ufscar.dc.pibd.service.spec.ITelefoneService;

@Controller
@RequestMapping("/telefone")
public class TelefoneController {

	@Autowired
	private ITelefoneService telefoneService;

	private Pessoa getPessoa() {
		UserAccount usuarioDetails = (UserAccount) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return usuarioDetails.getUser();
	}

	@GetMapping("/cadastrar")
	public String cadastrar(ModelMap model) {

		return "telefone/cadastrarTelefone";
	}

	@PostMapping("/salvarTelefone")
	public String salvar(Telefone telefone, BindingResult result, RedirectAttributes attr) {
		telefone.setDono(this.getPessoa());

		attr.addFlashAttribute("success", "Telefone Adicionado");
		return "redirect:/telefone/listar";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		if (this.getPessoa().getRole().compareTo("ROLE_ADMIN") == 0) {
			model.addAttribute("telefones", telefoneService.findAll());
		} else if (this.getPessoa().getRole().compareTo("ROLE_USER") == 0) {
			model.addAttribute("telefones", telefoneService.findAllByPessoa(this.getPessoa().getId()));
		}
		return "telefone/lista";
	}

}
