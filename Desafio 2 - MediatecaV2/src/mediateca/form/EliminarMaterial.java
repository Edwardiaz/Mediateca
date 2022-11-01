package mediateca.form;

import datos.Conexion;
import java.sql.*;
import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 *
 * @erick alas
 */
public class EliminarMaterial extends JFrame {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Conexion conn = new Conexion();
    Connection con = conn.getConnection();

    public EliminarMaterial() throws SQLException {
        initComponents();
        mostrarMaterial();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 960, 310));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(102, 0, 153));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-eliminar.png"))); // NOI18N
        btnEliminar.setText("Borrar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setIconTextGap(10);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminarMousePressed(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 400, 100, 50));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMousePressed
        try {
            delete();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
            //Logger.getLogger(EliminarMaterial.class.getName()).log(Priority.ERROR, ex);
            Logger.getLogger(ConsultarMateriales.class.getName()).warn(ex);
        }
    }//GEN-LAST:event_btnEliminarMousePressed

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        try {
            Dashboard dash = new Dashboard();
            dash.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(EliminarMaterial.class.getName()).log(Priority.WARN, null, ex);
        }
    }//GEN-LAST:event_btnBackMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void delete() throws SQLException {
        try {
            int idCelda = jTable1.getSelectedRow();
            if (idCelda <= -1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar material a borrar. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                con = Conexion.getConnection();
                PreparedStatement ps = null;
                ResultSet rs = null;

                ps = con.prepareStatement("SELECT * FROM materiales");
                rs = ps.executeQuery();

                int count = 0;
                while (rs.next()) {
                    count++;
                }

                String lista[][] = new String[count][15];
                int i = 0;
                ResultSet re = ps.executeQuery("SELECT * FROM materiales");
                while (re.next()) {
                    lista[i][0] = re.getString("id");
                    lista[i][1] = re.getString("titulo");
                    lista[i][2] = re.getString("codigo_tipo_material");
                    lista[i][3] = re.getString("codigo_autor");
                    lista[i][4] = re.getString("numero_de_paginas");
                    lista[i][5] = re.getString("codigo_editorial");
                    lista[i][6] = re.getString("isbn");
                    lista[i][7] = re.getString("periodicidad");
                    lista[i][8] = re.getString("fecha_publicacion");
                    lista[i][9] = re.getString("codigo_artista");
                    lista[i][10] = re.getString("codigo_genero");
                    lista[i][11] = re.getString("duracion");
                    lista[i][12] = re.getString("numero_de_canciones");
                    lista[i][13] = re.getString("codigo_director");
                    lista[i][14] = re.getString("unidades_disponibles");
                    i++;
                }

                //Variable que almacena el identificador de la cleda seleccionada
                String id = lista[idCelda][0];
                if (id == null || id.equals("")) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar el material a borrar. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Statement stmt = null;
                    try {
                        stmt = con.createStatement();
                    } catch (SQLException ex) {
                        System.out.println("ERROR: " + ex);
                    }
                    try {
                        stmt.executeUpdate("DELETE FROM materiales WHERE `id` = '"+id+"' LIMIT 1");
                        JOptionPane.showMessageDialog(this, "¡Material eliminado! \n", "HECHO", JOptionPane.INFORMATION_MESSAGE);
                        mostrarMaterial();
                    } catch (SQLException ex) {
                        System.out.println("ERROR: " + ex);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }

    }

    public void mostrarMaterial() throws SQLException {
        con = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        ps = con.prepareStatement("SELECT materiales.id, materiales.titulo, autores.nombre_autor AS Autor, materiales.numero_de_paginas, editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.periodicidad, materiales.fecha_publicacion, artistas.nombre_artista AS Artista, materiales.duracion, materiales.numero_de_canciones, materiales.unidades_disponibles, directores.nombre_director as Director, materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material LEFT JOIN autores on autores.id = materiales.codigo_autor LEFT JOIN artistas ON artistas.id = materiales.codigo_artista LEFT JOIN editoriales ON editoriales.id = materiales.codigo_editorial");
        rs = ps.executeQuery();

        int count = 0;
        while (rs.next()) {
            count++;
        }

        String list[][] = new String[count][15];
        int i = 0;
        ResultSet re = ps.executeQuery("SELECT materiales.id, materiales.titulo, autores.nombre_autor AS Autor, materiales.numero_de_paginas, editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.periodicidad, materiales.fecha_publicacion, artistas.nombre_artista AS Artista, materiales.duracion, materiales.numero_de_canciones, materiales.unidades_disponibles, directores.nombre_director as Director, materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material LEFT JOIN autores on autores.id = materiales.codigo_autor LEFT JOIN artistas ON artistas.id = materiales.codigo_artista LEFT JOIN editoriales ON editoriales.id = materiales.codigo_editorial");
        while (re.next()) {
            list[i][0] = re.getString("id");
            list[i][1] = re.getString("titulo");
            list[i][2] = re.getString("Tipo");
            list[i][3] = re.getString("Autor");
            list[i][4] = re.getString("numero_de_paginas");
            list[i][5] = re.getString("Editorial");
            list[i][6] = re.getString("isbn");
            list[i][7] = re.getString("periodicidad");
            list[i][7] = re.getString("fecha_publicacion");
            list[i][9] = re.getString("Artista");
            list[i][10] = re.getString("Genero");
            list[i][11] = re.getString("duracion");
            list[i][12] = re.getString("numero_de_canciones");
            list[i][13] = re.getString("Director");
            list[i][14] = re.getString("unidades_disponibles");
            i++;
        }

        jTable1.setModel(new DefaultTableModel(
                list,
                new String[]{
                    "ID", "Título", "Material", "Autor", "Número de Páginas", "Editorial", "ISBN", "Periodicidad", "Fecha de Pub.", "Artista", "Género", "Duración", "Número de canciones", "Director", "Disponibles"
                }));
        Conexion.close(con);
        Conexion.close(ps);
        Conexion.close(rs);

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
            java.util.logging.Logger.getLogger(EliminarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EliminarMaterial().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(EliminarMaterial.class.getName()).warn(ex);//log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
