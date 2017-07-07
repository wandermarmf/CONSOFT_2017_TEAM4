package br.gov.ufms.SGCteam04.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TipoSubmissao {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Integer id;
	   private String tipoSubmissao;
	   
	   public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoSubmissao() {
		return tipoSubmissao;
	}

	public void setTipoSubmissao(String tipoSubmissao) {
		this.tipoSubmissao = tipoSubmissao;
	}

	public TipoSubmissao() {
		// TODO Auto-generated constructor stub
	}

}
