package br.gov.ufms.SGCteam04.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Marco Cardoso on 7/9/2017.
 */
@Entity
public class TipoFase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Column(unique=true)
    private String descricao;

    @OneToMany
    private Set<Fase> fases  = new HashSet<Fase>();

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoFase(){
    }

    public Set<Fase> getFases() {
        return fases;
    }

    public void setFases(Set<Fase> fases) {
        this.fases = fases;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
