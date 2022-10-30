package mediateca.form;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @erick alas
 */
public class ElegirVista extends javax.swing.JFrame {

    
    public ElegirVista() {
        initComponents();
        this.setTitle("¿Qué deseas visualizar?");
        this.setLocationRelativeTo(null);
        this.setSize(430, 230);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTituloNuevo = new javax.swing.JLabel();
        cbxOpciones = new javax.swing.JComboBox<>();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(102, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloNuevo.setBackground(new java.awt.Color(102, 0, 204));
        lblTituloNuevo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloNuevo.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloNuevo.setText("Elige que tipo de material deseas ver");
        jPanel1.add(lblTituloNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        cbxOpciones.setFont(new java.awt.Font("Century", 0, 11)); // NOI18N
        cbxOpciones.setForeground(new java.awt.Color(102, 0, 102));
        cbxOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción ", "LIBRO ", "REVISTA", "CD ", "DVD" }));
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
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOpcionesActionPerformed
        // TODO add your handling code here:
        int cbx = cbxOpciones.getSelectedIndex();
        
        if(cbx == 1){
            try {
                VistaLibros vista = new VistaLibros();
                vista.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ElegirVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else if(cbx==2){
            try {
                VistaRevistas rev = new VistaRevistas();
                rev.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ElegirVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(cbx==3){
            try{
                VistaCD cd = new VistaCD();
                cd.setVisible(true);
                this.dispose();
            } catch (SQLException e){
                System.out.println("ERROR. " +e);
            }
        } else{
            try {
                VistaDVD dvd = new VistaDVD();
                dvd.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ElegirVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cbxOpcionesActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        try {
            Dashboard dash = new Dashboard();
            dash.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ElegirVista.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(ElegirVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElegirVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElegirVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElegirVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElegirVista().setVisible(true);
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
