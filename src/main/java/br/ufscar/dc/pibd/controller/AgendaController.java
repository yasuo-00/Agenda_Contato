package br.ufscar.dc.pibd.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.pibd.classes.Agenda;
import br.ufscar.dc.pibd.classes.Pessoa;
import br.ufscar.dc.pibd.security.UserAccount;
import br.ufscar.dc.pibd.service.spec.IAgendaService;
import br.ufscar.dc.pibd.service.spec.IPessoaService;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
	
	
	@Autowired
	private IAgendaService agendaService;

	@Autowired
	private IPessoaService pessoaService;
	
	private Pessoa getPessoa() {
		UserAccount usuarioDetails = (UserAccount) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUser();
	}

	@GetMapping("/listar")
	public String list(ModelMap model) {
		
		model.addAttribute("contatos", agendaService.findAllByContactante(this.getPessoa().getId()));
//		
		return "agenda/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
        Agenda agenda = new Agenda();
        agenda.setContactante(this.getPessoa());
        agenda.setContato(pessoa);
        LocalDate data = LocalDate.now();
        agenda.setDataInicioAmizade(data);
        
        agendaService.save(agenda);
        
		attr.addFlashAttribute("success", "Contato Adicionado"	);
		return "redirect:/agenda/listar";
	}

	@GetMapping("/cadastrar")
	public String Cadastrar(ModelMap model, Agenda agenda) {
		agenda.setContactante(this.getPessoa());
		model.addAttribute("pessoas", pessoaService.findAll());
		
		return "agenda/cadastrarContato";
	}
	


}
