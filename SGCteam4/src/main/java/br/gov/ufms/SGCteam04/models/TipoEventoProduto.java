package br.gov.ufms.SGCteam04.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoEventoProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(unique = true)
	private String nome;
	private String informacao;
	private char modoSelecao;
	private Integer ordemSelecao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInformacao() {
		return informacao;
	}

	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}

	public char getModoSelecao() {
		return modoSelecao;
	}

	public void setModoSelecao(char modoSelecao) {
		this.modoSelecao = modoSelecao;
	}

	public Integer getOrdemSelecao() {
		return ordemSelecao;
	}

	public void setOrdemSelecao(Integer ordemSelecao) {
		this.ordemSelecao = ordemSelecao;
	}

	public TipoEventoProduto() {
		// TODO Auto-generated constructor stub
	}

}
