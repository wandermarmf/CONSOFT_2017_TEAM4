package br.gov.ufms.SGCteam04.models;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Marco Cardoso on 7/28/2017.
 */
@Entity
public class Usuario {

    /*
        ATRIBUTOS DA CLASSE
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(min = 5 , max = 50)
    private String nome;

    @NotNull
    @Length(min = 5,max = 50)
    private String senha;

    @NotNull
    @Column(unique = true)
    @Length(min = 5,max = 50)
    private String email;

    @NotNull
    @Min(value = 0) @Max(value = 150)
    private Integer idade;

    @NotNull
    @URL
    private String website;

    @NotNull
    private String nacionalidade;

    @NotNull
    @ColumnDefault(value = "true")
    private Boolean usuarioAtivo;

    @NotNull
    private String telefone;

    private String diretorioImagem;

    @OneToMany(mappedBy = "usuario")
    private List<Role> roles;


    /*
        GETTERS E SETTERS

     */

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Boolean getUsuarioAtivo() {
        return usuarioAtivo;
    }

    public void setUsuarioAtivo(Boolean usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }

    public String getDiretorioImagem() {
        return diretorioImagem;
    }

    public void setDiretorioImagem(String diretorioImagem) {
        this.diretorioImagem = diretorioImagem;
    }
}
