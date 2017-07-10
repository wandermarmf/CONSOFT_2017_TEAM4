package br.gov.ufms.SGCteam04.models;

import javax.persistence.*;

@Entity
public class Topico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
	private String topico;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public Topico() {
		// TODO Auto-generated constructor stub
	}

}
