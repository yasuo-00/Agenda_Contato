package br.ufscar.dc.pibd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.pibd.classes.Telefone;
import br.ufscar.dc.pibd.service.spec.ITelefoneService;

@Controller
@RequestMapping("/telefones")
public class TelefoneController {

	@Autowired
	private ITelefoneService telefoneService;

	@GetMapping("/list")
	public String list(@RequestParam(value = "city", required = false) String city, ModelMap model) {
//		if (city == "" || city == null) {
//			model.addAttribute("hotels", TelefoneService.findAll());
//		} else {
//			model.addAttribute("hotels", TelefoneService.findAllByCity(city));
//		}
		model.addAttribute("telefones", telefoneService.findAll());
		return "telefone/list";
	}

	@PostMapping("/save")
	public String save(@Valid Telefone telefone, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "telefone/register";
		}
		telefoneService.save(telefone);
		attr.addFlashAttribute("success", "Telefone inserted successfully");
		return "redirect:/telefones/list";
	}

	@GetMapping("/register")
	public String register(Telefone telefone) {
		return "telefone/register";
	}

	// talvez tenha que mudar para post
	@GetMapping("/edit/{id}")
	public String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("telefone", telefoneService.findById(id));
		return "telefone/register";
	}

	@PostMapping("/edit")
	public String edit(@Valid Telefone telefone, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "telefone/register";
		}
		telefoneService.save(telefone);
		attr.addFlashAttribute("success", "Telefone edited successfully");
		return "redirect:/telefones/list";
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, RedirectAttributes attr) {
		telefoneService.remove(id);
		attr.addFlashAttribute("success", "Telefone removed successfully");
		return "redirect:/telefones/list";
	}

}
