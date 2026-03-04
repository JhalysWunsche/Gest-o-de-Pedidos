package model;

import java.util.Date;



public class Cliente {
    private int id;
    private String nome;
    private String documento;
    private String tipoCliente;
    private String telefone;
    private String email;
    private String numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
    private Date dataCadastro;
    private String observacoes;
    private String logradouro;
    private String bairro;

    public Cliente() {
    }

    public Cliente(int id, String nome, String documento, String tipoCliente, String telefone, String email, String numero, String complemento, String cidade, String estado, String cep, Date dataCadastro, String observacoes, String logradouro, String bairro) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.tipoCliente = tipoCliente;
        this.telefone = telefone;
        this.email = email;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.dataCadastro = dataCadastro;
        this.observacoes = observacoes;
        this.logradouro = logradouro;
        this.bairro = bairro;
    }

    public Cliente(String nome, String documento, String tipoCliente, String telefone, String email, String numero, String complemento, String cidade, String estado, String cep, String observacoes, String logradouro, String bairro) {
        this.nome = nome;
        this.documento = documento;
        this.tipoCliente = tipoCliente;
        this.telefone = telefone;
        this.email = email;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.observacoes = observacoes;
        this.logradouro = logradouro;
        this.bairro = bairro;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return this.id == other.id;
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

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}

