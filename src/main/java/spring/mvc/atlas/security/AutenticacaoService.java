package spring.mvc.atlas.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.mvc.atlas.model.Usuario;
import spring.mvc.atlas.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService  {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByNome(username);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Usuario não encontrado!");
	}

}
