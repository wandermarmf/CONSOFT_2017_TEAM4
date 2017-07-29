package br.gov.ufms.SGCteam04.models;

import javax.persistence.*;

/**
 * Created by Marco Cardoso on 7/28/2017.
 */
@Entity
public class Role {

    @ManyToOne
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String role;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
