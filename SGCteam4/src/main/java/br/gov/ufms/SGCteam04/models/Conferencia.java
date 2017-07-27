package br.gov.ufms.SGCteam04.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Conferencia {

	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Integer id;

	   @Column(unique=true, nullable = false)
	   private String nomeAbreviado;

	   @Column(unique = true, nullable = false)
	   private String nomeConferencia;

	   @Column(nullable = false)
	   private String subTitulo;

	   private String subTituloSecundario;

	   private String paginaWeb;

	   @Column(nullable = false)
	   private String cidadeConferencia;

	   @Column(nullable = false)
	   private String cidadeEmissaoFatura;

	   @Column(nullable = false)
	   private Double valorTaxaInscricao;

	   @Column(nullable = false)
	   private String moedaConferencia;

	   @ManyToMany(cascade = CascadeType.REMOVE)
	   @JoinTable(name = "conferencia_opcao_pagamento", joinColumns = @JoinColumn(name = "conferencia_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "opcao_pagamento_id", referencedColumnName = "id"))
	   private List<OpcaoPagamento> opcaoPagamentoList = new ArrayList<OpcaoPagamento>();
		
	   @ManyToMany(cascade = CascadeType.REMOVE)
	   @JoinTable(name = "conferencia_tipo_arquivo", joinColumns = @JoinColumn(name = "conferencia_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tipo_arquivo_id", referencedColumnName = "id"))
	   private List<TipoArquivo> tipoArquivoList = new ArrayList<TipoArquivo>();
		

	   /*
	   @ManyToMany
	   private ArrayList<Topico> topicoArrayList;
		*/

	   /*
	   @ManyToMany
	   
		*/

	   /*
	   TODO criar entidade e repositorio da sessao
	   @OneToMany
	   private ArrayList<Sessao> sessaoArrayList;
		*/

	   /*
	   TODO criar entidade e repositorio da fase da conferencia
	   @OneToMany
		private ArrayList<ConferenciaFase> conferenciaFaseArrayList;
		*/

	   /*
	   TODO criar entidade e repositorio do evento/produto da conferencia
	   @OneToMany
	   private ArrayList<ConferenciaEventoProduto> conferenciaEventoProdutoArrayList;
		*/

	   /*
	   	TODO criar entidade e repositorio do intervalo desconto da conferencia
	   	@OneTo?????
	   	private ArrayList<IntervaloDescontoConferencia> ...
	    */

	   /*
	   	TODO criar entidade e repositorio da inscricao
	   	@OneToMany
	   	private ArrayList<Inscricao> inscricaoArrayList;
	    */

	   /*
	   TODO criar entidade e repositorio do coordenador
	   @OneTo????
	   private ....
	    */

	   /*
	   @ManyToMany
	   private ArrayList<TipoSubmissao> tipoSubmissaoArrayList;

	   /*
	   TODO criar entidade e repositorio do perfil
	   @ManyToMany
	   private ArrayList<Perfil> perfilArrayList;
	    */



	public Conferencia() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}

	public String getNomeConferencia() {
		return nomeConferencia;
	}

	public void setNomeConferencia(String nomeConferencia) {
		this.nomeConferencia = nomeConferencia;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getSubTituloSecundario() {
		return subTituloSecundario;
	}

	public void setSubTituloSecundario(String subTituloSecundario) {
		this.subTituloSecundario = subTituloSecundario;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getCidadeConferencia() {
		return cidadeConferencia;
	}

	public void setCidadeConferencia(String cidadeConferencia) {
		this.cidadeConferencia = cidadeConferencia;
	}

	public String getCidadeEmissaoFatura() {
		return cidadeEmissaoFatura;
	}

	public void setCidadeEmissaoFatura(String cidadeEmissaoFatura) {
		this.cidadeEmissaoFatura = cidadeEmissaoFatura;
	}

	public Double getValorTaxaInscricao() {
		return valorTaxaInscricao;
	}

	public void setValorTaxaInscricao(Double valorTaxaInscricao) {
		this.valorTaxaInscricao = valorTaxaInscricao;
	}

	public String getMoedaConferencia() {
		return moedaConferencia;
	}

	public void setMoedaConferencia(String moedaConferencia) {
		this.moedaConferencia = moedaConferencia;
	}

	public List<OpcaoPagamento> getOpcaoPagamentoList() {
		return opcaoPagamentoList;
	}

	public void setOpcaoPagamentoList(List<OpcaoPagamento> opcaoPagamentoArrayList) {
		this.opcaoPagamentoList = opcaoPagamentoArrayList;
	}

	
	public List<TipoArquivo> getTipoArquivoList() {
		return tipoArquivoList;
	}

	public void setTipoArquivoList(List<TipoArquivo> tipoArquivoList) {
		this.tipoArquivoList = tipoArquivoList;
	}

	public void addTipoArquivo(Iterable<TipoArquivo> listArqObjs, String paramValue) {
		
		if (paramValue.equals("") == true)
			return;
		
		for (TipoArquivo arq : listArqObjs) {
			if (arq.getId().toString().equals(paramValue)) {
				tipoArquivoList.add(arq);
				return;				
			}
		}
	}

	public void addOpcaoPagamento(Iterable<OpcaoPagamento> listPgObjs, String paramValue) {
		
		if (paramValue.equals("") == true)
			return;
		
		for (OpcaoPagamento opPg : listPgObjs) {
			if (opPg.getId().toString().equals(paramValue)) {
				opcaoPagamentoList.add(opPg);
				return;				
			}
		}
	}

	
	/*
	public ArrayList<Topico> getTopicoArrayList() {
		return topicoArrayList;
	}

	public void setTopicoArrayList(ArrayList<Topico> topicoArrayList) {
		this.topicoArrayList = topicoArrayList;
	}

	*/   
}
