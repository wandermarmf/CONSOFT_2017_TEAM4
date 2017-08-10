package br.gov.ufms.SGCteam04.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

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

	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "conferencia_tipo_submissao", joinColumns = @JoinColumn(name = "conferencia_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tipo_submissao_id", referencedColumnName = "id"))
	private List<TipoSubmissao> tipoSubmissaoList = new ArrayList<TipoSubmissao>();

	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "conferencia_grupo_participante", joinColumns = @JoinColumn(name = "conferencia_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "grupo_participante_id", referencedColumnName = "id"))
	private List<GrupoParticipante> grupoParticipanteList = new ArrayList<GrupoParticipante>();

	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "conferencia_topico", joinColumns = @JoinColumn(name = "conferencia_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "topico_id", referencedColumnName = "id"))
	private List<Topico> topicoList = new ArrayList<Topico>();
	
	@OneToMany(mappedBy = "conferencia", cascade = CascadeType.ALL)
	private List<ConferenciaComite> comiteList;

	@OneToOne
	private Usuario administrador;

	//TODO criar entidade e repositorio da sessao completed
	@OneToMany(mappedBy = "conferencia", fetch = FetchType.LAZY)
	private Set<Sessao> sessaoArrayList  = new HashSet<Sessao>();



	//TODO criar entidade e repositorio da fase da conferencia completed
	@OneToMany(mappedBy = "conferencia", fetch = FetchType.LAZY)
	private Set<Fase> conferenciaFaseArrayList = new HashSet<Fase>();

	public Usuario getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}

	public Set<Sessao> getSessaoArrayList() {
		return sessaoArrayList;
	}

	public void setSessaoArrayList(Set<Sessao> sessaoArrayList) {
		this.sessaoArrayList = sessaoArrayList;
	}

	public Set<Fase> getConferenciaFaseArrayList() {
		return conferenciaFaseArrayList;
	}

	public void setConferenciaFaseArrayList(Set<Fase> conferenciaFaseArrayList) {
		this.conferenciaFaseArrayList = conferenciaFaseArrayList;
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

	public List<TipoSubmissao> getTipoSubmissaoList() {
		return tipoSubmissaoList;
	}

	public void setTipoSubmissaoList(List<TipoSubmissao> tipoSubmissaoList) {
		this.tipoSubmissaoList = tipoSubmissaoList;
	}

	public List<GrupoParticipante> getGrupoParticipanteList() {
		return grupoParticipanteList;
	}

	public void setGrupoParticipanteList(List<GrupoParticipante> grupoParticipanteList) {
		this.grupoParticipanteList = grupoParticipanteList;
	}

	public List<Topico> getTopicoList() {
		return topicoList;
	}

	public void setTopicoList(List<Topico> grupotopicoList) {
		this.topicoList = grupotopicoList;
	}
	
	public List<ConferenciaComite> getComiteList() {
		return comiteList;
	}

	public void setComiteList(List<ConferenciaComite> comiteList) {
		this.comiteList = comiteList;
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

	public void addTipoSubmissao(Iterable<TipoSubmissao> listObjs, String paramValue) {

		if (paramValue.equals("") == true)
			return;

		for (TipoSubmissao obj : listObjs) {
			if (obj.getId().toString().equals(paramValue)) {
				tipoSubmissaoList.add(obj);
				return;
			}
		}
	}

	public void addGrupoParticipante(Iterable<GrupoParticipante> listObjs, String paramValue) {

		if (paramValue.equals("") == true)
			return;

		for (GrupoParticipante obj : listObjs) {
			if (obj.getId().toString().equals(paramValue)) {
				grupoParticipanteList.add(obj);
				return;
			}
		}
	}

	public void addTopico(Iterable<Topico> listObjs, String paramValue) {

		if (paramValue.equals("") == true)
			return;

		for (Topico obj : listObjs) {
			if (obj.getId().toString().equals(paramValue)) {
				topicoList.add(obj);
				return;
			}
		}
	}
	
	
	public void addComite(Iterable<ConferenciaComite> listObjs, String paramValue) {

		if (paramValue.equals("") == true)
			return;

		for (ConferenciaComite obj : listObjs) {
			if (obj.getId().toString().equals(paramValue)) {
				comiteList.add(obj);
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
