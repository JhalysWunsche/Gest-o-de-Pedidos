package jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author clebe
 */
public class TesteConexao {
    
    public static void main(String[] args) {

        try {
            ModuloConexao.conectar();
            

        } catch (Exception erro) {
            
        }
    }
    
}
