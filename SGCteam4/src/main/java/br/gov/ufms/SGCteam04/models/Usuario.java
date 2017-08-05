package br.gov.ufms.SGCteam04.models;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private String name;


    @NotNull
    @Length(min = 5 , max = 50)
    private String sobrenome;


    @NotNull
    @Length(min = 4,max = 50)
    private String senha;

    @NotNull
    @Column(unique = true)
    @Length(min = 5,max = 50)
    private String email;

    @NotNull
    private String aniversario;

    @NotNull
    private String website;

    @NotNull
    private String nacionalidade;

    private Boolean usuarioAtivo = true;

    @NotNull
    private String telefone;

    private String diretorioImagem;

    @Embedded
    private Endereco local;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private Set<Role> roles ;

    public Usuario() {}

    public Usuario(String name, String sobrenome, String senha, String email, String aniversario, String website, String nacionalidade, Boolean usuarioAtivo, String telefone, String diretorioImagem, Endereco local, Set<Role> roles) {
        this.name = name;
        this.sobrenome = sobrenome;
        this.senha = senha;
        this.email = email;
        this.aniversario = aniversario;
        this.website = website;
        this.nacionalidade = nacionalidade;
        this.usuarioAtivo = usuarioAtivo;
        this.telefone = telefone;
        this.diretorioImagem = diretorioImagem;
        this.local = local;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDiretorioImagem() {
        return diretorioImagem;
    }

    public void setDiretorioImagem(String diretorioImagem) {
        this.diretorioImagem = diretorioImagem;
    }

    public Endereco getLocal() {
        return local;
    }

    public void setLocal(Endereco local) {
        this.local = local;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
