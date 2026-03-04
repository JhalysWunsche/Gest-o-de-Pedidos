package model;

import java.util.Date;

public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private String perfil;
    private String nomeCompleto;
    private String email;
    private Date dataCadastro;
    
    public Usuario(){};
    
    public Usuario(int id, String nome, String senha, String perfil, String nomeCompleto, String email, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.perfil  = perfil;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public Usuario(String nome, String senha, String perfil, String nomeCompleto, String email) {
        this.nome = nome;
        this.senha = senha;
        this.perfil = perfil;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }
    public Usuario(int id, String nome, String senha, String perfil, String nomeCompleto, String email) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.perfil = perfil;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPerfil() {
        return perfil;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
