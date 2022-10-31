package mediateca.form;

import datos.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.log4j.Logger;

/**
 *
 * @Jorge Díaz
 */
public class ConsultarMateriales extends JFrame {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Conexion conn = new Conexion();
    Connection con = conn.getConnection();

    public ConsultarMateriales() throws SQLException {
        initComponents();
        mostrarMaterial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 970, 310));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(102, 0, 153));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setIconTextGap(10);
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBuscarMousePressed(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 100, 50));

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
        jPanel2.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 90, 50));

        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 220, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMousePressed
        try {
            buscador();
        } catch (SQLException ex) {
            //System.out.println("ERROR: " + ex);
            Logger.getLogger(ConsultarMateriales.class.getName()).warn(ex);
        }
    }//GEN-LAST:event_btnBuscarMousePressed

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        try {
            Dashboard dash = new Dashboard();
            dash.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            //Logger.getLogger(ConsultarMateriales.class.getName()).log(Priority.WARN, null, ex);
            Logger.getLogger(ConsultarMateriales.class.getName()).warn(ex);
        }
    }//GEN-LAST:event_btnBackMousePressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        
    }//GEN-LAST:event_jTextField1KeyReleased
    
    public void buscador() throws SQLException {
        try {
            int idCelda = jTable1.getSelectedRow();
            String texto = jTextField1.getText();
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe escribir el titulo del material a buscar. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                con = Conexion.getConnection();
                PreparedStatement ps = null;
                ResultSet rs = null;

                ps = con.prepareStatement("SELECT * FROM materiales WHERE materiales.titulo like '"+texto+"%'");
                rs = ps.executeQuery();

                int count = 0;
                while (rs.next()) {
                    count++;
                }

                String lista[][] = new String[count][15];
                int i = 0;
                ResultSet re = ps.executeQuery("SELECT * FROM materiales WHERE materiales.titulo like '"+texto+"%'");
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
                String titulo = lista[0][1];
                if (titulo == null || titulo.equals("")) {
                    JOptionPane.showMessageDialog(this, "Debe escribir el titulo del material a buscar. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Statement stmt = null;
                    try {
                        stmt = con.createStatement();
                    } catch (SQLException ex) {
                        //System.out.println("ERROR: " + ex);
                        Logger.getLogger(ConsultarMateriales.class.getName()).warn(ex);
                    }
                    try {
                        /*stmt.executeUpdate("SELECT * FROM materiales WHERE `titulo` like '"+texto+"%'");
                        JOptionPane.showMessageDialog(this, "¡Material Encontrado! \n", "HECHO", JOptionPane.INFORMATION_MESSAGE);*/
                        mostrarResultado(texto);
                    } catch (SQLException ex) {
                        //System.out.println("ERROR: " + ex);
                        Logger.getLogger(ConsultarMateriales.class.getName()).warn(ex);
                    }
                }
            }
        } catch (SQLException ex) {
            //System.out.println("ERROR" + ex);
            Logger.getLogger(ConsultarMateriales.class.getName()).warn(ex);
        }

    }
    
    public void mostrarResultado(String titulo) throws SQLException {
        con = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        ps = con.prepareStatement("SELECT materiales.id, materiales.titulo, autores.nombre_autor AS Autor, materiales.numero_de_paginas, editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.periodicidad, materiales.fecha_publicacion, artistas.nombre_artista AS Artista, materiales.duracion, materiales.numero_de_canciones, materiales.unidades_disponibles, directores.nombre_director as Director, materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material LEFT JOIN autores on autores.id = materiales.codigo_autor LEFT JOIN artistas ON artistas.id = materiales.codigo_artista LEFT JOIN editoriales ON editoriales.id = materiales.codigo_editorial WHERE materiales.titulo like '"+titulo+"%'");
        rs = ps.executeQuery();

        int count = 0;
        while (rs.next()) {
            count++;
        }

        String list[][] = new String[count][15];
        int i = 0;
        ResultSet re = ps.executeQuery("SELECT materiales.id, materiales.titulo, autores.nombre_autor AS Autor, materiales.numero_de_paginas, editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.periodicidad, materiales.fecha_publicacion, artistas.nombre_artista AS Artista, materiales.duracion, materiales.numero_de_canciones, materiales.unidades_disponibles, directores.nombre_director as Director, materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material LEFT JOIN autores on autores.id = materiales.codigo_autor LEFT JOIN artistas ON artistas.id = materiales.codigo_artista LEFT JOIN editoriales ON editoriales.id = materiales.codigo_editorial WHERE materiales.titulo like '"+titulo+"%'");
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConsultarMateriales().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultarMateriales.class.getName()).warn(ex);//log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
