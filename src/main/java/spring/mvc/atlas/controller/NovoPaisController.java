package spring.mvc.atlas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.atlas.dto.RequisicaoNovoPais;
import spring.mvc.atlas.model.Pais;
import spring.mvc.atlas.repository.PaisRepository;

@Controller
@RequestMapping("pais")
public class NovoPaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPais requisicao) {
		return "formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPais requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "formulario";
		}
		
		Pais pais = requisicao.toPais();
		paisRepository.save(pais);
		
		return "redirect:/home";
	}
}
