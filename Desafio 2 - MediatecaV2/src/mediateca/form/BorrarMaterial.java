package mediateca.form;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class BorrarMaterial extends javax.swing.JFrame {


    Conexion conn = new Conexion();
    Connection con = conn.getConnection();
    
    public BorrarMaterial() throws SQLException {
        initComponents();
        
        mostrarMaterial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 960, 310));

        btnModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnModificar.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(102, 0, 153));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnActualizar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setIconTextGap(10);
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnModificarMousePressed(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 400, 130, 50));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(153, 0, 0));
        btnBack.setText("Atrás");
        btnBack.setBorder(null);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBackMousePressed(evt);
            }
        });
        jPanel2.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 90, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMousePressed
            actualizarDatos();
    }//GEN-LAST:event_btnModificarMousePressed

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        try {
            Dashboard dash = new Dashboard();
            dash.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }
    }//GEN-LAST:event_btnBackMousePressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    
    public void mostrarMaterial() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConnection();
    
        try{
            String sql = "SELECT materiales.id, materiales.titulo, autores.nombre_autor, materiales.numero_de_paginas, editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.fecha_publicacion, materiales.unidades_disponibles, tipo_material.tipo_material AS Tipo from materiales LEFT JOIN autores on autores.id = materiales.codigo_autor LEFT JOIN editoriales ON editoriales.id = materiales.codigo_editorial LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material where codigo_tipo_material=4";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            int count = 0;
            while(rs.next()){
                count++;
            }
            
            String list[][] = new String[count][9];
            int i = 0;
            ResultSet re = ps.executeQuery("SELECT materiales.id, materiales.titulo, autores.nombre_autor, materiales.numero_de_paginas, editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.fecha_publicacion, materiales.unidades_disponibles, tipo_material.tipo_material AS Tipo from materiales LEFT JOIN autores on autores.id = materiales.codigo_autor LEFT JOIN editoriales ON editoriales.id = materiales.codigo_editorial LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material where codigo_tipo_material=4");
            while(re.next()){
                list[i][0] = re.getString("id");
                list[i][1] = re.getString("titulo");
                list[i][2] = re.getString("Tipo");
                list[i][3] = re.getString("nombre_autor");
                list[i][4] = re.getString("numero_de_paginas");
                list[i][5] = re.getString("Editorial");
                list[i][6] = re.getString("isbn");
                list[i][7] = re.getString("fecha_publicacion");
                list[i][8] = re.getString("unidades_disponibles");
                i++;
            }
            
            jTable1.setModel(new DefaultTableModel(
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
    
    public void actualizarDatos(){
        
         try {
            //Variable para almacenar el valor de la fla seleccionada
            int fila = jTable1.getSelectedRow();

            String id = jTable1.getValueAt(fila, 0).toString();
            String titu = jTable1.getValueAt(fila, 1).toString();
            //String material = jTable1.getValueAt(fila, 2).toString();
            String autor = jTable1.getValueAt(fila, 3).toString();
            int num_pag = Integer.parseInt(this.jTable1.getValueAt(fila, 4).toString());
            String editorial = jTable1.getValueAt(fila, 5).toString();
            String isbn = jTable1.getValueAt(fila, 6).toString();
            //String fecha_pub = jTable1.getValueAt(fila, 7).toString();
            String unidades = jTable1.getValueAt(fila, 8).toString();
        
             System.out.println(id);
        
            //materiales.id, materiales.titulo, autores.nombre_autor as Autor, materiales.numero_de_paginas, editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.fecha_publicacion, materiales.unidades_disponibles, tipo_material.tipo_material AS Tipo from materiales LEFT JOIN autores on autores.id = materiales.codigo_autor LEFT JOIN editoriales ON editoriales.id = materiales.codigo_editorial LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material
            try {
                PreparedStatement ps = con.prepareStatement("UPDATE autores SET nombre_autor='"+autor+"' WHERE id LIKE '"+id+"' ");
                ps.executeUpdate();
                    try {
                        PreparedStatement ps2 = con.prepareStatement("UPDATE editoriales SET nombre_editorial='"+editorial+"' WHERE id='"+id+"'");
                        ps2.executeUpdate();
                    } catch (Exception e) {
                        System.out.println("Error" + e);
                    }
                    
                    try {
                        PreparedStatement ps3 = con.prepareStatement("UPDATE materiales SET titulo='"+titu+"', numero_de_paginas='"+num_pag+"', isbn='"+isbn+"', unidades_disponibles='"+unidades+"' WHERE id = '"+id+"'");
                        ps3.executeUpdate();
                    } catch (Exception e) {
                        System.out.println("Error" + e);
                    }
                JOptionPane.showMessageDialog(this, "Datos actualizados. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (Exception e) {
                System.out.println("Error" + e);
                JOptionPane.showMessageDialog(this, "Error en dato seleccionado \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
             System.out.println("ERROR" + e);
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
            java.util.logging.Logger.getLogger(BorrarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BorrarMaterial().setVisible(true);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnModificar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
