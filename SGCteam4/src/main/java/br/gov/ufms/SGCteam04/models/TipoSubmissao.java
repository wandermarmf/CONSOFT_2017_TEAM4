package br.gov.ufms.SGCteam04.models;

import javax.persistence.*;

@Entity
public class TipoSubmissao {

	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Integer id;
	   @Column(unique=true)
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
