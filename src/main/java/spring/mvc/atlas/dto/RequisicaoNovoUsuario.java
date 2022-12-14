package spring.mvc.atlas.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import spring.mvc.atlas.model.Usuario;

public class RequisicaoNovoUsuario {

	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario toUsuario() {
		return new Usuario(this.nome, this.email, new BCryptPasswordEncoder().encode(this.senha));
	}
}
