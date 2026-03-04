package controller;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Usuario;
import model.WebServiceCep;
import jdbc.ModuloConexao;



public class ClienteDAO {
    private Connection con;
    
    public void ClienteDAO(){
        this.con = ModuloConexao.conectar();
    }
    public List<Cliente> listarClienteNome(String nome) {
        try {
            con = ModuloConexao.conectar();
            //1 passo criar a lista
            List<Cliente> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql ="select id_cliente as id, nome, telefone from clientes where nome like ?";
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente obj = new Cliente();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setTelefone(rs.getString("telefone"));
                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
    }
    
    public void adicionarCliente(Cliente obj) {
        
        
        try {
            //1 passo - criar o sql
            String sql = "insert into clientes(nome, documento, tipo_cliente, telefone, email, logradouro, numero, complemento, bairro, cidade, estado, cep, observacoes) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getDocumento());
            stmt.setString(3, obj.getTipoCliente());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getEmail());
            stmt.setString(6, obj.getLogradouro());
            stmt.setString(7, obj.getNumero());
            stmt.setString(8, obj.getComplemento());
            stmt.setString(9, obj.getBairro());
            stmt.setString(10, obj.getCidade());
            stmt.setString(11, obj.getEstado());
            stmt.setString(12, obj.getCep());
            stmt.setString(13, obj.getObservacoes());
                        
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!!");
        
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    public void excluirCliente(Cliente obj) {
        
        try {
            //1 passo - criar o sql
            String sql = "delete from clientes where id_cliente = ?;";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());            
            
                        
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!!");
            //System.out.println(stmt);
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    public void alterarCliente(Cliente obj) {
        try {
            //1 passo - criar o sql
            String sql = "UPDATE clientes SET nome=?, documento=?, tipo_cliente=?, telefone=?, email=?, numero=?, complemento=?, cidade=?, estado=?, cep=?, logradouro=?, bairro=?, observacoes=? WHERE id_cliente=?";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getDocumento());
            stmt.setString(3, obj.getTipoCliente());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getEmail());
            stmt.setString(6, obj.getNumero());
            stmt.setString(7, obj.getComplemento());
            stmt.setString(8, obj.getCidade());
            stmt.setString(9, obj.getEstado());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getLogradouro());
            stmt.setString(12, obj.getBairro());
            stmt.setString(13, obj.getObservacoes());
            stmt.setInt(14, obj.getId());
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!!");
        
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public Cliente buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Cliente obj = new Cliente();

        if (webServiceCep.wasSuccessful()) {
            obj.setLogradouro(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setEstado(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
    public List<Cliente> listarClientes() {
        try { 

            //1 passo criar a lista
            List<Cliente> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from clientes";
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setId(rs.getInt("id_cliente"));
                obj.setNome(rs.getString("nome"));
                obj.setDocumento(rs.getString("documento")); 
                obj.setTipoCliente(rs.getString("tipo_cliente"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setEmail(rs.getString("email"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNumero(rs.getString("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                obj.setCep(rs.getString("cep"));
                obj.setDataCadastro(rs.getDate("data_cadastro"));
                obj.setObservacoes(rs.getString("observacoes"));
                lista.add(obj);
            }
            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
     

    }

}
