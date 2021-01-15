package br.ufscar.dc.pibd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.pibd.classes.Pessoa;
import br.ufscar.dc.pibd.service.spec.IPessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private IPessoaService	pessoaService;

	@GetMapping("/list")
	public String list(@RequestParam(value = "city", required = false) String city, ModelMap model) {
//		if (city == "" || city == null) {
//			model.addAttribute("hotels", pessoaService.findAll());
//		} else {
//			model.addAttribute("hotels", pessoaService.findAllByCity(city));
//		}
		return "pessoa/list";
	}

	@PostMapping("/save")
	public String save(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "pessoa/register";
		}
		pessoaService.save(pessoa);
		attr.addFlashAttribute("success", "Pessoa inserted successfully");
		return "redirect:/pessoas/list";
	}

	@GetMapping("/register")
	public String register(Pessoa pessoa) {
		return "pessoa/register";
	}

	// talvez tenha que mudar para post
	@GetMapping("/edit/{id}")
	public String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.findById(id));
		return "pessoa/register";
	}

	@PostMapping("/edit")
	public String edit(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "pessoa/register";
		}
		pessoaService.save(pessoa);
		attr.addFlashAttribute("success", "Pessoa edited successfully"	);
		return "redirect:/pessoas/list";
	}
	
	//só pode ser apagada se não tiver contato com ninguém
	//TODO
	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, RedirectAttributes attr) {
		pessoaService.remove(id);
		attr.addFlashAttribute("success", "Pessoa removed successfully");
		return "redirect:/pessoas/list";
	}
	


}
