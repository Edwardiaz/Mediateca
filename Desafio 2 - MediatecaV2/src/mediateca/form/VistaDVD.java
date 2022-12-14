package mediateca.form;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @erick alas
 */
public class VistaDVD extends javax.swing.JFrame {

    public VistaDVD() throws SQLException {
        initComponents();
        this.setTitle("DVD's en sistema");
        this.setLocationRelativeTo(null);
        mostrarDVD();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDVD = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        lblCD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDVD.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        tblDVD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDVD);

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
        lblCD.setText("DVD- Mediateca");
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

    
    public void mostrarDVD() throws SQLException{
       PreparedStatement ps = null;
       ResultSet rs = null;
       Conexion conn = new Conexion();
       Connection con = conn.getConnection();
       
       try{
           String sql = "SELECT materiales.id, materiales.titulo, directores.nombre_director as Director, materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material where codigo_tipo_material=2";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           int cont = 0;
           while(rs.next()){
               cont++;
           }
           
           String list [][] = new String [cont][6];
           int i = 0;
           ResultSet re = ps.executeQuery("SELECT materiales.id, materiales.titulo, directores.nombre_director as Director, materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material where codigo_tipo_material=2");
           while(re.next()){
               list[i][0] = re.getString("id");
               list[i][1] = re.getString("titulo");
               list[i][2] = re.getString("Tipo");
               list[i][3] = re.getString("Director");
               list[i][4] = re.getString("Genero");
               list[i][5] = re.getString("duracion");
               i++;
           }
           tblDVD.setModel(new DefaultTableModel(
           list,
                new String[]{
                    "ID", "Título","Material","Director","Género", "Duración"
                }
           ));
           
       } catch(SQLException e){
           System.out.println("ERROR: " + e);
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
            java.util.logging.Logger.getLogger(VistaDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaDVD().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaDVD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCD;
    private javax.swing.JTable tblDVD;
    // End of variables declaration//GEN-END:variables
}
