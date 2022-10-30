package mediateca.form;

import datos.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @erick alas
 */
public class VistaCD extends javax.swing.JFrame {

    public VistaCD() throws SQLException {
        initComponents();
        this.setTitle("CD's en sistema");
        this.setLocationRelativeTo(null);
        mostrarCD();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCD = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        lblCD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCD.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        tblCD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCD);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 900, -1));

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(102, 0, 153));
        btnAtras.setText("Atrás");
        btnAtras.setBorder(null);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAtrasMousePressed(evt);
            }
        });
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 90, 40));

        lblCD.setBackground(new java.awt.Color(255, 255, 255));
        lblCD.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        lblCD.setForeground(new java.awt.Color(102, 0, 153));
        lblCD.setText("CD- Mediateca");
        jPanel1.add(lblCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMousePressed
        ElegirVista vista = new ElegirVista();
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasMousePressed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed

    
    public void mostrarCD () throws SQLException{
       PreparedStatement ps = null;
       ResultSet rs = null;
       Conexion conn = new Conexion();
       Connection con = conn.getConnection();
       
       try{
           String sql = "SELECT materiales.id, materiales.titulo, artistas.nombre_artista as Artista, generos.nombre_genero AS Genero, materiales.duracion, materiales.numero_de_canciones, materiales.unidades_disponibles, tipo_material.tipo_material AS Tipo from materiales LEFT JOIN artistas on artistas.id = materiales.codigo_artista LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material where codigo_tipo_material=1";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           int cont = 0;
           while(rs.next()){
               cont++;
           }
           
           String list [][] = new String [cont][8];
           int i = 0;
           ResultSet re = ps.executeQuery("SELECT materiales.id, materiales.titulo, artistas.nombre_artista as Artista, generos.nombre_genero AS Genero, materiales.duracion, materiales.numero_de_canciones, materiales.unidades_disponibles, tipo_material.tipo_material AS Tipo from materiales LEFT JOIN artistas on artistas.id = materiales.codigo_artista LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material where codigo_tipo_material=1");
           while(re.next()){
               list[i][0] = re.getString("id");
               list[i][1] = re.getString("titulo");
               list[i][2] = re.getString("Tipo");
               list[i][3] = re.getString("Artista");
               list[i][4] = re.getString("Genero");
               list[i][5] = re.getString("duracion");
               list[i][6] = re.getString("numero_de_canciones");
               list[i][7] = re.getString("unidades_disponibles");
               i++;
           }
           tblCD.setModel(new DefaultTableModel(
           list,
                new String[]{
                    "ID", "Título","Material","Artista","Género", "Duración","Num. Canciones", "Disponibles"
                }
           ));
           
       } catch(Exception e){
           System.out.println(e);
       } finally {
           Conexion.close(con);
           Conexion.close(ps);
           Conexion.close(rs);
       }
    }
    
    
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
            java.util.logging.Logger.getLogger(VistaCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaCD().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaCD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCD;
    private javax.swing.JTable tblCD;
    // End of variables declaration//GEN-END:variables
}