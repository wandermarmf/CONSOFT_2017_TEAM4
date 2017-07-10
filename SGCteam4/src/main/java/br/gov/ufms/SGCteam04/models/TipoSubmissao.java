package br.gov.ufms.SGCteam04.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class TipoSubmissao {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   @Column(unique=true)
   private String tipoSubmissao;

   @ManyToMany
   private ArrayList<Conferencia> conferenciaArrayList;

	public ArrayList<Conferencia> getConferenciaArrayList() {
		return conferenciaArrayList;
	}

	public void setConferenciaArrayList(ArrayList<Conferencia> conferenciaArrayList) {
		this.conferenciaArrayList = conferenciaArrayList;
	}

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
