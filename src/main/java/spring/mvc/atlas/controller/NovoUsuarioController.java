package spring.mvc.atlas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.atlas.dto.RequisicaoNovoUsuario;
import spring.mvc.atlas.model.Usuario;
import spring.mvc.atlas.repository.UsuarioRepository;

@Controller
@RequestMapping("/cadastrarUsuario")
public class NovoUsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/formulario")
	public String formulario(RequisicaoNovoUsuario requisicao) {
		return "formularioNovoUsuario";
	}
	
	@PostMapping("/novo")
	public String cadastrar(@Valid RequisicaoNovoUsuario requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "formularioNovoUsuario";
		}
		
		Usuario usuario = requisicao.toUsuario();
		
		usuarioRepository.save(usuario);
		
		return "redirect:/login";
	}
	
}
