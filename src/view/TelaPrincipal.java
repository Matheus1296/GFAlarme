/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.UIManager;

/**
 *
 * @author aluno
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        estilo();
        initComponents();
        setVisible(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbCadastro = new javax.swing.JButton();
        jbAlterarCliente = new javax.swing.JButton();
        jbAlterarAdm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GF-Alarme");
        setResizable(false);

        jbCadastro.setText("Cadastro");
        jbCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastroActionPerformed(evt);
            }
        });

        jbAlterarCliente.setText("Dados dos Clientes");
        jbAlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarClienteActionPerformed(evt);
            }
        });

        jbAlterarAdm.setText("Dados dos Administradores");
        jbAlterarAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarAdmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAlterarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAlterarAdm)
                .addContainerGap(192, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbAlterarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbAlterarAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(389, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroActionPerformed
        telaCadastroCliente();
    }//GEN-LAST:event_jbCadastroActionPerformed

    private void jbAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarClienteActionPerformed
        telaAlterarBuscarCliente();
    }//GEN-LAST:event_jbAlterarClienteActionPerformed

    private void jbAlterarAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarAdmActionPerformed
        telaAlterarBuscarAdm();
    }//GEN-LAST:event_jbAlterarAdmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAlterarAdm;
    private javax.swing.JButton jbAlterarCliente;
    private javax.swing.JButton jbCadastro;
    // End of variables declaration//GEN-END:variables

    private void telaCadastroCliente() {
        CadastroCliente aux = new CadastroCliente();
        aux.setVisible(true);
        setVisible(false);
    }
    
    private void estilo() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void telaAlterarBuscarCliente() {
        AlterarBuscarExcluirCliente aux = new AlterarBuscarExcluirCliente();
        aux.setVisible(true);
        setVisible(false);
    }
    
    private void telaAlterarBuscarAdm() {
        AlterarBuscarExcluirAdm aux = new AlterarBuscarExcluirAdm();
        aux.setVisible(true);
        setVisible(false);
    }
}
