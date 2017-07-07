package br.gov.ufms.SGCteam04.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CategoriaPreco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String categoriaPreco;
	private Double preco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoriaPreco() {
		return categoriaPreco;
	}

	public void setCategoriaPreco(String categoriaPreco) {
		this.categoriaPreco = categoriaPreco;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public CategoriaPreco() {
		// TODO Auto-generated constructor stub
	}

}
