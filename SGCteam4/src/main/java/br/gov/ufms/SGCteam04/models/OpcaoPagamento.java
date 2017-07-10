package br.gov.ufms.SGCteam04.models;

import javax.persistence.*;
import java.util.ArrayList;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
