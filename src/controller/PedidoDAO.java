/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import jdbc.ModuloConexao;
import model.Cliente;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pedido;
/**
 *
 * @author jhaly
 */
public class PedidoDAO {
    
    private Connection con;
    
    public void PedidoDAO(){
        this.con = ModuloConexao.conectar();
    }
    public List<Cliente> listarClienteNome(String nome) {
        try {

            //1 passo criar a lista
            List<Cliente> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql ="SELECT id_cliente AS id, nome AS nome, telefone AS telefone " + "FROM clientes WHERE nome LIKE ?";
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
    public Pedido listarPedidoId(int id) {
        try {
            //1 passo - criar o sql , organizar e executar.
            String sql = "select * from pedidos where id_pedido = ?";
            PreparedStatement stmt;
            con = ModuloConexao.conectar();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Pedido pedido = new Pedido();
            if(rs.next()){
                Cliente obj = new Cliente();
                
                obj.setId(rs.getInt("id_cliente"));
                
                pedido = new Pedido();
                
                pedido.setId(rs.getInt("id_pedido"));
                pedido.setCliente(obj);
                pedido.setData(rs.getDate("data_pedido"));
                pedido.setStatus(rs.getString("status"));
                pedido.setTotal(rs.getDouble("valor_total"));
                pedido.setObservacoes(rs.getString("observacoes"));
                
                return pedido;
            }
            
            return null;
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
    }
    /**
     * Método responsável por adicionar um novo Pedido
     */
    public void adicionarPedido(Pedido obj) {

        try {
            //1 passo - criar o sql
            String sql = "insert into pedidos(id_cliente, status, valor_total, observacoes ) values(?,?,?,?)";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getStatus());
            stmt.setDouble(3, obj.getTotal());
            stmt.setString(4, obj.getObservacoes());
            
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!!");

        }catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    public void excluirPedido(Pedido obj){
        try {
            //1 passo - criar o sql
            String sql = "delete from pedidos where id_pedido = ?;";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());            
            
                        
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Pedido deletado com sucesso!!");
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
    public void alterarPedido(Pedido obj) {
        try {
            //1 passo - criar o sql
            String sql = "UPDATE pedidos SET status=?, valor_total=?, observacoes=? WHERE id_pedido=?";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getStatus());
            stmt.setDouble(2, obj.getTotal());
            stmt.setString(3, obj.getObservacoes());
            stmt.setInt(4, obj.getId());
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Pedido atualizado com sucesso!!");
        
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
}
