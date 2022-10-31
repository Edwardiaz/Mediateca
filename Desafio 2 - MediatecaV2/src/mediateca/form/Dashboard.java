package mediateca.form;

import datos.Conexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @erick alas
 */
public class Dashboard extends javax.swing.JFrame {
    
    Conexion co = new Conexion();
    Connection con = co.getConnection();
    
    
    public Dashboard() throws SQLException{
        initComponents();
        
        //Bloque de código para identificar fecha actual
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int dia = now.getDayOfMonth();
        int month = now.getMonthValue();
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto"," ;Septiembre"
            ,"Octubre","Noviembre","Diciemrbre"};
        lblFecha.setText("Hoy es "+dia+" de "+meses[month - 1]+" de "+year);
        this.setLocationRelativeTo(null);
        this.setTitle("Mediateca UDB - GRUPO 02");
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnPrestar = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlMenu.setForeground(new java.awt.Color(255, 255, 255));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(51, 0, 153));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnActualizar.png"))); // NOI18N
        btnActualizar.setText("Modificar material");
        btnActualizar.setIconTextGap(7);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnActualizarMousePressed(evt);
            }
        });
        pnlMenu.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 49));

        btnMostrar.setBackground(new java.awt.Color(255, 255, 255));
        btnMostrar.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(51, 0, 153));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-mostrar.png"))); // NOI18N
        btnMostrar.setText("Mostrar material");
        btnMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMostrarMousePressed(evt);
            }
        });
        pnlMenu.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 180, 49));

        btnBorrar.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrar.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(51, 0, 153));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-eliminar.png"))); // NOI18N
        btnBorrar.setText("Borrar material");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        pnlMenu.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 180, 49));

        btnPrestar.setBackground(new java.awt.Color(255, 255, 255));
        btnPrestar.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnPrestar.setForeground(new java.awt.Color(51, 0, 153));
        btnPrestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-prestar.png"))); // NOI18N
        btnPrestar.setText("Solicitar material");
        pnlMenu.add(btnPrestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 180, 49));

        btnDevolver.setBackground(new java.awt.Color(255, 255, 255));
        btnDevolver.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnDevolver.setForeground(new java.awt.Color(51, 0, 153));
        btnDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-devolver.png"))); // NOI18N
        btnDevolver.setText("Devolver material");
        pnlMenu.add(btnDevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, 49));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(51, 0, 153));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-buscar.png"))); // NOI18N
        jButton9.setText("Buscar material");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnBuscarMousePressed(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        pnlMenu.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 180, 49));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(51, 0, 153));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar material");
        btnAgregar.setBorder(null);
        btnAgregar.setIconTextGap(15);
        btnAgregar.setName("btnAgregar"); // NOI18N
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pnlMenu.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 49));

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 420));

        jPanel2.setBackground(new java.awt.Color(102, 0, 204));
        jPanel2.setForeground(new java.awt.Color(102, 0, 204));

        lblFecha.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Hoy es 24 de octubre de 2022");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 0, 630, 90));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(153, 153, 255));
        btnSalir.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 107, 35));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 620, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       
        // TODO add your handling code here:
  
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed
        try {
            
            Tipo_Material tipo = new Tipo_Material();
            tipo.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarMousePressed

    private void btnActualizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMousePressed
        try {
            // TODO add your handling code here:
            BorrarMaterial modificar = new BorrarMaterial();
            modificar.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            System.out.println("Error en sentencia SQL" + ex);
        }
        
            
    }//GEN-LAST:event_btnActualizarMousePressed

    private void btnMostrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMousePressed
        ElegirVista vista = new ElegirVista();
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMostrarMousePressed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {
            EliminarMaterial eliminar = new EliminarMaterial();
            eliminar.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void BtnBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBuscarMousePressed
        try {
            ConsultarMateriales consulta = new ConsultarMateriales();
            consulta.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BtnBuscarMousePressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnPrestar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
