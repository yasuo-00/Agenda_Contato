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

import br.ufscar.dc.pibd.classes.Carro;
import br.ufscar.dc.pibd.service.spec.ICarroService;

@Controller
@RequestMapping("/carros")
public class CarroController {

	@Autowired
	private ICarroService carroService;

	@GetMapping("/list")
	public String list(@RequestParam(value = "city", required = false) String city, ModelMap model) {
//		if (city == "" || city == null) {
//			model.addAttribute("hotels", carroService.findAll());
//		} else {
//			model.addAttribute("hotels", carroService.findAllByCity(city));
//		}
		return "carro/list";
	}

	@PostMapping("/save")
	public String save(@Valid Carro carro, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "carro/register";
		}
		carroService.save(carro);
		attr.addFlashAttribute("success", "Carro inserted successfully");
		return "redirect:/carros/list";
	}

	@GetMapping("/register")
	public String register(Carro carro) {
		return "carro/register";
	}

	// talvez tenha que mudar para post
	@GetMapping("/edit/{id}")
	public String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("carro", carroService.findById(id));
		return "carro/register";
	}

	@PostMapping("/edit")
	public String edit(@Valid Carro carro, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "carro/register";
		}
		carroService.save(carro);
		attr.addFlashAttribute("success", "Carro edited successfully");
		return "redirect:/carros/list";
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, RedirectAttributes attr) {
		carroService.remove(id);
		attr.addFlashAttribute("success", "Carro removed successfully");
		return "redirect:/carros/list";
	}
	

}
