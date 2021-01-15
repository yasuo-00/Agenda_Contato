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

import br.ufscar.dc.pibd.classes.Agenda;
import br.ufscar.dc.pibd.service.spec.IAgendaService;

@Controller
@RequestMapping("/agendas")
public class AgendaController {
	
	
	@Autowired
	private IAgendaService agendaService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/list")
	public String list(@RequestParam(value = "city", required = false) String city, ModelMap model) {
//		if (city == "" || city == null) {
//			model.addAttribute("hotels", agendaService.findAll());
//		} else {
//			model.addAttribute("hotels", agendaService.findAllByCity(city));
//		}
		return "agenda/list";
	}

	@PostMapping("/save")
	public String save(@Valid Agenda agenda, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "agenda/register";
		}
		agendaService.save(agenda);
		attr.addFlashAttribute("success", "Agenda inserted successfully");
		return "redirect:/agendas/list";
	}

	@GetMapping("/register")
	public String register(Agenda agenda) {
		return "agenda/register";
	}

	// talvez tenha que mudar para post
	@GetMapping("/edit/{id}")
	public String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("agenda", agendaService.findById(id));
		return "agenda/register";
	}

	@PostMapping("/edit")
	public String edit(@Valid Agenda agenda, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "agenda/register";
		}
		agendaService.save(agenda);
		attr.addFlashAttribute("success", "Agenda edited successfully");
		return "redirect:/agendas/list";
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, RedirectAttributes attr) {
		agendaService.remove(id);
		attr.addFlashAttribute("success", "Agenda removed successfully");
		return "redirect:/agendas/list";
	}
	


}
