package br.gov.ufms.SGCteam04.models;

import javax.persistence.*;

@Entity
public class CategoriaPreco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
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
