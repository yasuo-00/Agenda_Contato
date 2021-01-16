package br.ufscar.dc.pibd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.pibd.classes.Pessoa;

import br.ufscar.dc.pibd.service.spec.IPessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private IPessoaService	pessoaService;


	@GetMapping("/listar")
	public String list(ModelMap model) {
		
		model.addAttribute("pessoas", pessoaService.findAll());
		return "pessoa/lista";
	}

	@PostMapping("/salvar")
	public String save(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
		pessoa.setRole("ROLE_USER");
		pessoaService.save(pessoa);
		attr.addFlashAttribute("success", "Pessoa inserted successfully");
		return "redirect:/pessoa/listar";
	}

	@GetMapping("/cadastrar")
	public String register(Pessoa pessoa) {
		return "pessoa/cadastro";
	}
	


}
