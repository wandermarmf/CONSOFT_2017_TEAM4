package br.gov.ufms.SGCteam04.models;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Marco Cardoso on 7/30/2017.
 */
@Entity
public class Fase {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(min = 5,  max = 50)
    private String nome;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date inicio;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fim;

    @ManyToOne
    private Conferencia conferencia;

    @ManyToOne
    private TipoFase tipoFase;

    public TipoFase getTipoFase() {
        return tipoFase;
    }

    public void setTipoFase(TipoFase tipoFase) {
        this.tipoFase = tipoFase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }

}
