package br.gov.ufms.SGCteam04.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Marco Cardoso on 7/13/2017.
 */
public class ConferenciaFase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date periodo_inciial;
    private Date periodo_final;
    private Boolean faseDesativada;
    private String descricao;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPeriodo_inciial() {
        return periodo_inciial;
    }

    public void setPeriodo_inciial(Date periodo_inciial) {
        this.periodo_inciial = periodo_inciial;
    }

    public Date getPeriodo_final() {
        return periodo_final;
    }

    public void setPeriodo_final(Date periodo_final) {
        this.periodo_final = periodo_final;
    }

    public Boolean getFaseDesativada() {
        return faseDesativada;
    }

    public void setFaseDesativada(Boolean faseDesativada) {
        this.faseDesativada = faseDesativada;
    }
}
