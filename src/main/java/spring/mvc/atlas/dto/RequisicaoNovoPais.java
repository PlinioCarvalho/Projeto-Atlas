package spring.mvc.atlas.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import spring.mvc.atlas.model.Pais;

public class RequisicaoNovoPais {

	@NotBlank
	private String nome;
	@NotBlank
	private String regime;
	@NotBlank
	private String governo;
	@Max(200000000)
	@NotNull
	private BigDecimal populacao;
	@Max(150000000)
	@NotNull
	private BigDecimal area;
	@NotBlank
	private String continente;
	@NotBlank
	private String imagem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	public String getGoverno() {
		return governo;
	}

	public void setGoverno(String governo) {
		this.governo = governo;
	}

	public BigDecimal getPopulacao() {
		return populacao;
	}

	public void setPopulacao(BigDecimal populacao) {
		this.populacao = populacao;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Pais toPais() {
		Pais pais = new Pais();
		pais.setNome(nome);
		pais.setRegime(regime);
		pais.setGoverno(governo);
		pais.setPopulacao(populacao);
		pais.setArea(area);
		pais.setContinente(continente);
		pais.setImagem(imagem);

		return pais;
	}
}
