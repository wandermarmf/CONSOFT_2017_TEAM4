package br.gov.ufms.SGCteam04.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@Table(name="conferencia_comite")
public class ConferenciaComite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nomeComite;

    @ManyToOne
    @JoinColumn(name = "conferencia_id")
    private Conferencia conferencia;
    
    public ConferenciaComite() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeComite() {
		return nomeComite;
	}

	public void setNomeComite(String nomeComite) {
		this.nomeComite = nomeComite;
	}

	public Conferencia getConferencia() {
		return conferencia;
	}

	public void setConferencia(Conferencia conferencia) {
		this.conferencia = conferencia;
	}

}
