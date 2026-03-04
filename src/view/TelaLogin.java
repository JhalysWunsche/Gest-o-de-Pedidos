package view;

import controller.UsuarioDAO;
import javax.swing.JOptionPane;


public class TelaLogin extends javax.swing.JFrame {
    

    
    public TelaLogin() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtUsuario = new javax.swing.JTextField();
        jTxtSenha = new javax.swing.JPasswordField();
        jBotCancel = new javax.swing.JButton();
        jBotLogar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de login");
        setIconImages(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Usuário");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Senha");

        jTxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtUsuarioActionPerformed(evt);
            }
        });

        jTxtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtSenhaActionPerformed(evt);
            }
        });
        jTxtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtSenhaKeyPressed(evt);
            }
        });

        jBotCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBotCancel.setText("Cancelar");
        jBotCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotCancelActionPerformed(evt);
            }
        });

        jBotLogar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBotLogar.setText("Logar");
        jBotLogar.setToolTipText("Entrar no sistema");
        jBotLogar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBotLogar.setEnabled(false);
        jBotLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotLogarActionPerformed(evt);
            }
        });
        jBotLogar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBotLogarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBotLogarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBotLogarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBotCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBotLogar)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBotCancel)
                    .addComponent(jBotLogar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtUsuarioActionPerformed

    private void jTxtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtSenhaActionPerformed

    private void jBotLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotLogarActionPerformed
        // TODO add your handling code here:
        String senha = String.valueOf(jTxtSenha.getPassword());
        String usuario = jTxtUsuario.getText();
        UsuarioDAO dao = new UsuarioDAO();
        dao.logar(usuario, senha);
        this.dispose();
    }//GEN-LAST:event_jBotLogarActionPerformed

    private void jBotCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotCancelActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jBotCancelActionPerformed

    private void jBotLogarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBotLogarKeyPressed
        // TODO add your handling code here:
        String senha = String.valueOf(jTxtSenha.getPassword());
        String usuario = jTxtUsuario.getText();
        UsuarioDAO dao = new UsuarioDAO();
        dao.logar(usuario, senha);
        this.dispose();
    }//GEN-LAST:event_jBotLogarKeyPressed

    private void jBotLogarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBotLogarKeyTyped
        // TODO add your handling code here
    }//GEN-LAST:event_jBotLogarKeyTyped

    private void jTxtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtSenhaKeyPressed
        // TODO add your handling code here:
        if(jTxtSenha.getText().length()>=3){
            jBotLogar.setEnabled(true);
        }
        
    }//GEN-LAST:event_jTxtSenhaKeyPressed

    private void jBotLogarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBotLogarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jBotLogarKeyReleased

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new TelaLogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotCancel;
    private javax.swing.JButton jBotLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPasswordField jTxtSenha;
    public javax.swing.JTextField jTxtUsuario;
    // End of variables declaration//GEN-END:variables
}
