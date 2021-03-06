package br.gov.ufms.SGCteam04.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Topico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
	private String topico;

	@Transient
	private boolean selected = false;

	/*
	@ManyToMany
	private ArrayList<Conferencia> conferenciaArrayList;


	public ArrayList<Conferencia> getConferenciaArrayList() {
		return conferenciaArrayList;
	}

	public void setConferenciaArrayList(ArrayList<Conferencia> conferenciaArrayList) {
		this.conferenciaArrayList = conferenciaArrayList;
	}
	*/

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

	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
