package br.gov.ufms.SGCteam04.models;

import javax.persistence.*;

@Entity
public class GrupoParticipante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
	private String grupo;	

	@Transient
	private boolean selected = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public GrupoParticipante() {
		// TODO Auto-generated constructor stub
	}

	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
