package controller;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdbc.ModuloConexao;
import model.Usuario;
import view.TelaLogin;
import view.TelaPrincipal;



 
public class UsuarioDAO {
    
    private Connection con;
    
    public UsuarioDAO(){
        this.con = ModuloConexao.conectar();
        
    }
    public Boolean logar (String usuario, String senha){
        try {
            String sql = "select * from usuarios where nome = ? and senha = MD5(?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                String perfil = rs.getString("perfil");
                if (perfil.equals("Administrador")){
                    JOptionPane.showMessageDialog(null, "Acesso ao sistema!!!!");
                    
                    TelaPrincipal tela = new TelaPrincipal();
                    tela.setVisible(true);
                    tela.jMenuItemUsuario.setVisible(true);
                    tela.jMenuRelatorio.setVisible(true);
                    tela.jLabelUsuario.setText(usuario);
                    tela.jLabelUsuario.setForeground(Color.RED);
                    
                }else {
                    JOptionPane.showMessageDialog(null, "Acesso ao sistema!!!!");
                    TelaPrincipal tela = new TelaPrincipal();
                    tela.setVisible(true);
                    tela.jMenuItemUsuario.setVisible(false);
                    tela.jMenuRelatorio.setVisible(false);
                    tela.jLabelUsuario.setText(usuario);
                    tela.jLabelUsuario.setForeground(Color.YELLOW);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou Senha inválido!!!!");
                new TelaLogin().setVisible(true);
            }
            return true;
        }catch(Exception e){    
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    public void adicionarUsuario(Usuario obj) {
        
        
        try {
            //1 passo - criar o sql
            String sql = "insert into usuarios(nome, senha, perfil, nome_completo, email) values(?,md5(?),?,?,?)";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getSenha());
            stmt.setString(3, obj.getPerfil());
            stmt.setString(4, obj.getNomeCompleto());
            stmt.setString(5, obj.getEmail());
                        
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!!");
            
        } catch (SQLIntegrityConstraintViolationException e1) {
            JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
        
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
    public void alterarUsuario(Usuario obj) {
        
        try {
            String novaSenha;

            if (obj.getSenha() == null || obj.getSenha().isEmpty()) {
            // Não alterar senha
            String sql = "UPDATE usuarios SET nome=?, perfil=?, nome_completo=?, email=? WHERE id_usuario=?";
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getPerfil());
            stmt.setString(3, obj.getNomeCompleto());
            stmt.setString(4, obj.getEmail());
            stmt.setInt(5, obj.getId());            
            
                        
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!!");
            //System.out.println(stmt);
            } else {
            // Alterar senha com hash
            String sql = "UPDATE usuarios SET nome=?, senha=md5(?), perfil=?, nome_completo=?, email=? WHERE id_usuario=?";
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getSenha());
            stmt.setString(3, obj.getPerfil());
            stmt.setString(4, obj.getNomeCompleto());
            stmt.setString(5, obj.getEmail());
            stmt.setInt(6, obj.getId());            
            
                        
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!!");
            //System.out.println(stmt);
            }
            
        } catch (SQLIntegrityConstraintViolationException e1) {
            JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");
        
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
    public void excluirUsuario(Usuario obj) {
        
        try {
            //1 passo - criar o sql
        String sql = "delete from usuarios where id_usuario = ?;";
        //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());            
            
                        
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!!");
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
/**
     *  Método Listar Todos Usuários
     * @param Usuário 
     * @return Lista de Usuários Cadastrados na Base de Dados.
     */
    /**
     *  Método Listar Todos Usuários
     * @param Usuário 
     * @return Lista de Usuários Cadastrados na Base de Dados.
     */

    public List<Usuario> listarUsuarios() {
        try {

            //1 passo criar a lista
            List<Usuario> lista = new ArrayList<>();

            //2 passo - criar sql , organizar e executar.
            String sql = "select * from usuarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario obj = new Usuario();

                obj.setId(rs.getInt("id_usuario"));
                obj.setNome(rs.getString("nome"));
                obj.setSenha("");
                obj.setPerfil(rs.getString("perfil"));
                obj.setNomeCompleto(rs.getString("nome_completo"));
                obj.setEmail(rs.getString("email"));
                obj.setDataCadastro(rs.getDate("data_cadastro"));
                

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
     

    }   
   }

