package mediateca.form;

import datos.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @erick alas
 */
public class VistaLibros extends javax.swing.JFrame {

    public VistaLibros() throws SQLException {
        initComponents();
        this.setTitle("Libros en sistema");
        this.setLocationRelativeTo(null);
        mostrarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        lblLibrosTabla = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblLibros.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblLibros);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 900, -1));

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(102, 0, 153));
        btnAtras.setText("Atrás");
        btnAtras.setBorder(null);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 90, 40));

        lblLibrosTabla.setBackground(new java.awt.Color(255, 255, 255));
        lblLibrosTabla.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        lblLibrosTabla.setForeground(new java.awt.Color(102, 0, 153));
        lblLibrosTabla.setText("Libros - Mediateca");
        jPanel1.add(lblLibrosTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(102, 0, 153));
        btnUpdate.setBorder(null);
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUpdate.setLabel("Actualizar");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUpdateMousePressed(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 90, 40));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMousePressed
        ElegirVista vista = new ElegirVista();
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasMousePressed

    private void btnUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMousePressed
        try{
            //verificamos si hay algun registro seleccionado, si no mostramos un error
            if(this.tblLibros.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null,"Debe seleccionar un registro para poder actualizar datos!");
            }
            else{
                //Seleccionamos numero de registro seleccionado
                int linea = this.tblLibros.getSelectedRow();
                int modelRow = tblLibros.convertRowIndexToModel(linea);
                String s = tblLibros.getModel().getValueAt(modelRow, 0)+"";

                EditarLibro libro = new EditarLibro(s);
                libro.setVisible(true);
                this.dispose();
            }

        } catch (SQLException e){
            System.out.println("ERROR. " +e);
        }
    }//GEN-LAST:event_btnUpdateMousePressed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed

    public void  mostrarDatos() throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConnection();
    
        try{
            String sql = "SELECT materiales.id, materiales.titulo, autores.nombre_autor as Autor, materiales.numero_de_paginas, editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.fecha_publicacion, materiales.unidades_disponibles, tipo_material.tipo_material AS Tipo from materiales LEFT JOIN autores on autores.id = materiales.codigo_autor LEFT JOIN editoriales ON editoriales.id = materiales.codigo_editorial LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material where codigo_tipo_material=4";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            int count = 0;
            while(rs.next()){
                count++;
            }
            
            String list[][] = new String[count][9];
            int i = 0;
            ResultSet re = ps.executeQuery("SELECT materiales.id, materiales.titulo, autores.nombre_autor as Autor, materiales.numero_de_paginas, editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.fecha_publicacion, materiales.unidades_disponibles, tipo_material.tipo_material AS Tipo from materiales LEFT JOIN autores on autores.id = materiales.codigo_autor LEFT JOIN editoriales ON editoriales.id = materiales.codigo_editorial LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material where codigo_tipo_material=4");
            while(re.next()){
                list[i][0] = re.getString("id");
                list[i][1] = re.getString("titulo");
                list[i][2] = re.getString("Tipo");
                list[i][3] = re.getString("Autor");
                list[i][4] = re.getString("numero_de_paginas");
                list[i][5] = re.getString("Editorial");
                list[i][6] = re.getString("isbn");
                //list[i][7] = re.getString("periodicidad");
                list[i][7] = re.getString("fecha_publicacion");
               // list[i][9] = re.getString("codigo_artista");
                //list[i][10] = re.getString("codigo_genero");
               // list[i][11] = re.getString("duracion");
               // list[i][12] = re.getString("numero_de_canciones");
                //list[i][13] = re.getString("codigo_director");
                list[i][8] = re.getString("unidades_disponibles");
                i++;
            }
            
            tblLibros.setModel(new DefaultTableModel(
        list,
        new String [] {
            "ID", "Título","Material", "Autor","Número de Páginas", "Editorial","ISBN", "Fecha de Pub.", "Disponibles"
        }));
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        } finally{
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
            java.util.logging.Logger.getLogger(VistaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaLibros().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaLibros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLibrosTabla;
    private javax.swing.JTable tblLibros;
    // End of variables declaration//GEN-END:variables
}
