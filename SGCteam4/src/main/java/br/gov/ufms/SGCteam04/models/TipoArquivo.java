package br.gov.ufms.SGCteam04.models;

import javax.persistence.*;

@Entity
public class TipoArquivo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
	private String tipoArquivo;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTipoArquivo() {
		return tipoArquivo;
	}


	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}


	public TipoArquivo() {
		// TODO Auto-generated constructor stub
	}

}
