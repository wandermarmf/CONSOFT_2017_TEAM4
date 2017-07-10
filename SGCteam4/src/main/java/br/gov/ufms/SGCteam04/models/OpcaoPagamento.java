package br.gov.ufms.SGCteam04.models;

import javax.persistence.*;

/**
 * Created by Marco Cardoso on 7/10/2017.
 */
@Entity
public class OpcaoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
