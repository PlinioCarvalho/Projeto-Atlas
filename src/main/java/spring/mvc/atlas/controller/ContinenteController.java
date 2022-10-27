package spring.mvc.atlas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.atlas.model.Pais;
import spring.mvc.atlas.repository.PaisRepository;

@Controller
@RequestMapping("/continente")
public class ContinenteController {

	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping(value = "{continente}")
	public String america(Model model, @PathVariable String continente) {
		List<Pais> paises = paisRepository.findByContinente(continente);
		model.addAttribute("paises", paises);
		
		return "continentes/" + continente;
	}
	
}
