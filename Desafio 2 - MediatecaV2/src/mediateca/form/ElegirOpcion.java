package mediateca.form;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @erick alas
 */
public class ElegirOpcion extends javax.swing.JFrame {

  
    public ElegirOpcion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("¿Qué acción desea realizar?");
        this.setSize(430, 260);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTituloNuevo = new javax.swing.JLabel();
        cbxOpciones = new javax.swing.JComboBox<>();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloNuevo.setBackground(new java.awt.Color(102, 0, 204));
        lblTituloNuevo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloNuevo.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloNuevo.setText("Elige que tipo de material deseas ver");
        jPanel1.add(lblTituloNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        cbxOpciones.setFont(new java.awt.Font("Century", 0, 11)); // NOI18N
        cbxOpciones.setForeground(new java.awt.Color(102, 0, 102));
        cbxOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción ", "Solicitar material", "Devolver material", "Ver préstamos" }));
        cbxOpciones.setToolTipText("");
        cbxOpciones.setBorder(null);
        cbxOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOpcionesActionPerformed(evt);
            }
        });
        jPanel1.add(cbxOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 140, 40));

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(102, 0, 153));
        btnAtras.setText("Atrás");
        btnAtras.setBorder(null);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOpcionesActionPerformed
        try {
            // TODO add your handling code here:
            int cbx = cbxOpciones.getSelectedIndex();
            
            switch (cbx) {
                case 1:
                    SolicitarMaterial vista = new SolicitarMaterial();
                    vista.setVisible(true);
                    this.dispose();
                    break;
                case 2:
                    DevolverMaterial back = new DevolverMaterial();
                    back.setVisible(true);
                    this.dispose();
                    break;
                case 3:
                    VerPrestamos ver = new VerPrestamos();
                    ver.setVisible(true);
                    this.dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Seleccionar una de las opciones. \n", "Elige opción correcta", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElegirOpcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbxOpcionesActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        try {
            Dashboard dash = new Dashboard();
            dash.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            
        }

    }//GEN-LAST:event_btnAtrasActionPerformed

 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ElegirOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElegirOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElegirOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElegirOpcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElegirOpcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JComboBox<String> cbxOpciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTituloNuevo;
    // End of variables declaration//GEN-END:variables
}
