package mediateca.form;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @erick alas
 */
public class EditarDVD extends javax.swing.JFrame {
   
   Conexion co = new Conexion();
   Connection con = co.getConnection();
   
    public EditarDVD(String codigo) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Agregar DVD al sistema");
        
       //Crear conexion y llamar datos 
       PreparedStatement ps = null;
       ResultSet rs = null;
       Conexion conn = new Conexion();
       Connection con = conn.getConnection();
       
       try{
           String sql = "SELECT materiales.id, materiales.titulo, directores.nombre_director as Director, materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material where materiales.id ='"+codigo+"'";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           if(rs.next()){           
                txtIdDvd.setText(rs.getString("id"));
                txtTitulodvd.setText(rs.getString("titulo"));
                txtDirector.setText(rs.getString("Director"));
                txtGenero.setText(rs.getString("Genero"));
                txtDuracion.setText(rs.getString("duracion"));
                txtTipo.setText(rs.getString("Tipo"));
           }
         
       } catch(Exception e){
           System.out.println(e);
       } finally {
           Conexion.close(con);
           Conexion.close(ps);
           Conexion.close(rs);
       }         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAgregarMenu = new javax.swing.JPanel();
        txtIdDvd = new javax.swing.JTextField();
        lblDVD = new javax.swing.JLabel();
        lblNewLibro = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        txtTitulodvd = new javax.swing.JTextField();
        lblTitulodvd = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtDirector = new javax.swing.JTextField();
        lblDirector = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        txtGenero = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        txtDuracion = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JSeparator();
        txtTipo = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlAgregarMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlAgregarMenu.setForeground(new java.awt.Color(102, 0, 204));
        pnlAgregarMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdDvd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtIdDvd.setForeground(new java.awt.Color(102, 102, 102));
        txtIdDvd.setText("Ingrese ID de DVD");
        txtIdDvd.setAlignmentX(0.8F);
        txtIdDvd.setBorder(null);
        txtIdDvd.setEnabled(false);
        txtIdDvd.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtIdDvd.setMinimumSize(new java.awt.Dimension(5, 20));
        txtIdDvd.setName("txtIdDvd"); // NOI18N
        txtIdDvd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIdDvdMousePressed(evt);
            }
        });
        txtIdDvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDvdActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtIdDvd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 260, 30));

        lblDVD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDVD.setForeground(new java.awt.Color(102, 0, 204));
        lblDVD.setText("ID DVD");
        lblDVD.setName("lblDVD"); // NOI18N
        pnlAgregarMenu.add(lblDVD, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lblNewLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNewLibro.setForeground(new java.awt.Color(102, 0, 204));
        lblNewLibro.setText("Editar DVD");
        pnlAgregarMenu.add(lblNewLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));
        pnlAgregarMenu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 92, -1, 170));
        pnlAgregarMenu.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 10, 440));

        jSeparator6.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator6.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 260, 10));

        jSeparator7.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator7.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 260, 10));

        txtTitulodvd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtTitulodvd.setForeground(new java.awt.Color(102, 102, 102));
        txtTitulodvd.setText("Ingrese título");
        txtTitulodvd.setAlignmentX(0.8F);
        txtTitulodvd.setBorder(null);
        txtTitulodvd.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtTitulodvd.setMinimumSize(new java.awt.Dimension(5, 20));
        txtTitulodvd.setName("txtTitulodvd"); // NOI18N
        txtTitulodvd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTitulodvdMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTitulodvdMousePressed(evt);
            }
        });
        txtTitulodvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitulodvdActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtTitulodvd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 260, 30));

        lblTitulodvd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulodvd.setForeground(new java.awt.Color(102, 0, 204));
        lblTitulodvd.setText("Título");
        lblTitulodvd.setName("llblTituloRevista"); // NOI18N
        pnlAgregarMenu.add(lblTitulodvd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jSeparator10.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator10.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 260, 10));

        txtDirector.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDirector.setForeground(new java.awt.Color(102, 102, 102));
        txtDirector.setText("Ingrese director");
        txtDirector.setAlignmentX(0.8F);
        txtDirector.setBorder(null);
        txtDirector.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtDirector.setMinimumSize(new java.awt.Dimension(5, 20));
        txtDirector.setName("txtDirector"); // NOI18N
        txtDirector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDirectorMousePressed(evt);
            }
        });
        txtDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirectorActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 260, 30));

        lblDirector.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDirector.setForeground(new java.awt.Color(102, 0, 204));
        lblDirector.setText("Director");
        lblDirector.setName("lblDirector"); // NOI18N
        pnlAgregarMenu.add(lblDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jSeparator12.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator12.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 260, 10));

        txtGenero.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtGenero.setForeground(new java.awt.Color(102, 102, 102));
        txtGenero.setText("Ingrese genero");
        txtGenero.setAlignmentX(0.8F);
        txtGenero.setBorder(null);
        txtGenero.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtGenero.setMinimumSize(new java.awt.Dimension(5, 20));
        txtGenero.setName("txtGenero"); // NOI18N
        txtGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtGeneroMousePressed(evt);
            }
        });
        txtGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGeneroActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 260, 30));

        lblGenero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(102, 0, 204));
        lblGenero.setText("Género");
        lblGenero.setName("lblGenero"); // NOI18N
        pnlAgregarMenu.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jSeparator13.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator13.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 260, 10));

        txtDuracion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDuracion.setForeground(new java.awt.Color(102, 102, 102));
        txtDuracion.setText("Ingrese duracion");
        txtDuracion.setAlignmentX(0.8F);
        txtDuracion.setBorder(null);
        txtDuracion.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtDuracion.setMinimumSize(new java.awt.Dimension(5, 20));
        txtDuracion.setName("txtDuracion"); // NOI18N
        txtDuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDuracionMousePressed(evt);
            }
        });
        txtDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 260, 30));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(102, 0, 204));
        lblFecha.setText("Duración");
        lblFecha.setName("lblFecha"); // NOI18N
        pnlAgregarMenu.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, 20));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(51, 0, 153));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-agregar.png"))); // NOI18N
        btnAgregar.setText("Actualizar");
        btnAgregar.setToolTipText("");
        btnAgregar.setBorder(null);
        btnAgregar.setName("btnAgregar"); // NOI18N
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
        });
        pnlAgregarMenu.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 110, 40));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 0, 153));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-salir.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
        });
        pnlAgregarMenu.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 110, 40));

        jSeparator15.setForeground(new java.awt.Color(102, 0, 204));
        jSeparator15.setPreferredSize(new java.awt.Dimension(200, 10));
        pnlAgregarMenu.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 260, 10));

        txtTipo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtTipo.setForeground(new java.awt.Color(102, 102, 102));
        txtTipo.setText("Ingrese tipo material");
        txtTipo.setAlignmentX(0.8F);
        txtTipo.setBorder(null);
        txtTipo.setMargin(new java.awt.Insets(5, 15, 5, 5));
        txtTipo.setMinimumSize(new java.awt.Dimension(5, 20));
        txtTipo.setName("txtTipo"); // NOI18N
        txtTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTipoMousePressed(evt);
            }
        });
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        pnlAgregarMenu.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 260, 30));

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(102, 0, 204));
        lblTipo.setText("Tipo material");
        lblTipo.setName("lblTipo"); // NOI18N
        pnlAgregarMenu.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAgregarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAgregarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdDvdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdDvdMousePressed
        // TODO add your handling code here:
//        if(txtIdDvd.getText().equals("Ingrese ID de DVD"));
//            txtIdDvd.setText("");

        if(txtTitulodvd.getText().equals("") || txtTitulodvd.getText() == null)
            txtTitulodvd.setText("Ingrese título");

        if(txtDirector.getText().equals("") || txtDirector.getText() == null)
            txtDirector.setText("Ingrese director");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duración");
        
        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
            txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtIdDvdMousePressed

    private void txtIdDvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDvdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDvdActionPerformed

    private void txtTitulodvdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTitulodvdMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitulodvdMouseEntered

    private void txtTitulodvdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTitulodvdMousePressed
        // TODO add your handling code here:

        if(txtTitulodvd.getText().equals("Ingrese título"))
        txtTitulodvd.setText("");

        if(txtIdDvd.getText().equals("") || txtIdDvd.getText() == null)
            txtIdDvd.setText("Ingrese ID de DVD");

        if(txtDirector.getText().equals("") || txtDirector.getText() == null)
            txtDirector.setText("Ingrese director");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");

        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
            txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtTitulodvdMousePressed

    private void txtTitulodvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitulodvdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitulodvdActionPerformed

    private void txtDirectorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDirectorMousePressed
        // TODO add your handling code here:

        if(txtDirector.getText().equals("Ingrese director"))
        txtDirector.setText("");

        if(txtIdDvd.getText().equals("") || txtIdDvd.getText() == null)
            txtIdDvd.setText("Ingrese ID de DVD");

        if(txtTitulodvd.getText().equals("") || txtTitulodvd.getText() == null)
            txtTitulodvd.setText("Ingrese título");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");

        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
            txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtDirectorMousePressed

    private void txtDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirectorActionPerformed

    private void txtGeneroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGeneroMousePressed
        // TODO add your handling code here:

        if(txtGenero.getText().equals("Ingrese genero"))
            txtGenero.setText("");

        if(txtIdDvd.getText().equals("") || txtIdDvd.getText() == null)
            txtIdDvd.setText("Ingrese ID de DVD");

        if(txtTitulodvd.getText().equals("") || txtTitulodvd.getText() == null)
            txtTitulodvd.setText("Ingrese título");

        if(txtDirector.getText().equals("") || txtDirector.getText() == null)
            txtDirector.setText("Ingrese director");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");

        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
            txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtGeneroMousePressed

    private void txtGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroActionPerformed

    private void txtDuracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDuracionMousePressed
        // TODO add your handling code here:

        if(txtDuracion.getText().equals("Ingrese duracion"))
            txtDuracion.setText("");

        if(txtIdDvd.getText().equals("") || txtIdDvd.getText() == null)
            txtIdDvd.setText("Ingrese ID de DVD");

        if(txtTitulodvd.getText().equals("") || txtTitulodvd.getText() == null)
            txtTitulodvd.setText("Ingrese título");

        if(txtDirector.getText().equals("") || txtDirector.getText() == null)
            txtDirector.setText("Ingrese director");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtTipo.getText().equals("") || txtTipo.getText() == null)
            txtTipo.setText("Ingrese tipo material");
    }//GEN-LAST:event_txtDuracionMousePressed

    private void txtDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionActionPerformed

    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed

        //Comprobar que los datos no sean nulos ni vaciós
        if(txtIdDvd.getText().equals("Ingrese ID de DVD") || txtTitulodvd.getText().equals("Ingrese título")
            || txtDirector.getText().equals("Ingrese director")
            || txtGenero.getText().equals("Ingrese genero")
            || txtDuracion.getText().equals("Ingrese duracion")
            || txtTipo.getText().equals("Ingrese tipo material")){
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtIdDvd.requestFocus();
        } else {

            try {
                //Creación de variables que almacenan los datos introducidos
                String id = txtIdDvd.getText();
                String titulo = txtTitulodvd.getText();
                String director = txtDirector.getText();
                String genre = txtGenero.getText();
                String duracion = txtDuracion.getText();
                String tipo = txtTipo.getText();
                
                //Variable que almacenará el incremento del id artista y género
                int idDirector = 1;
                idDirector = incrementarDirector();

                int idGenero = 1;
                idGenero = incrementarGenero();

                //Condicional que evalua si se ha ingresado 8 caracteres dentro del apartado ID
                if(id.length()== 8){
                    //Condicional que lanza mensaje de error si hay algún dato con tipo erróneo
                    if(id == null || "".equals(id)
                        || titulo == null || "".equals(titulo)
                        || director == null || "".equals(director)
                        || genre == null || "".equals(genre)
                        || duracion == null || "".equals(duracion)
                        || tipo == null || "".equals(tipo)){
                        JOptionPane.showMessageDialog(this, "Rellenar los campos solicitados \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                        txtIdDvd.requestFocus();
                    } else {

                        //Llamar a los siguientes métodos, pasándole parámetros
                        insertarDirector(idDirector, director);
                        insertarGenero(idGenero, genre);

                        //Bloque de código para insertar información en tabla materiales
                        String sql = "UPDATE materiales SET titulo = ?,codigo_director = ?,codigo_genero = ?,duracion = ? WHERE materiales.id ='"+id+"'";
                        System.out.println(sql);
                        PreparedStatement stmt = null;
                        //ResultSet rs = null;
                        int rows = 0;

                        try{
                            con = Conexion.getConnection();
                            stmt = con.prepareStatement(sql);
                            int index = 1;
                            //stmt.setString(index++, id);
                            stmt.setString(index++, titulo);
                            stmt.setInt(index++, idDirector);
                            stmt.setInt(index++, idGenero);
                            stmt.setString(index, duracion);

                            rows = stmt.executeUpdate();
                            System.out.println("Registros afectados " + rows);
                        }catch(SQLException e){
                            System.out.println("Error" + e);
                        } finally{
                            Conexion.close(stmt);
                            Conexion.close(con);
                        }
                        //Llamada al método limpiar campos
                        limpiarCampos();
                        

                        //Cerrar ventana
                        try {
                            JOptionPane.showMessageDialog(this, "Datos ingresados correctamente. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                            Dashboard dash = new Dashboard();
                            dash.setVisible(true);
                            this.dispose();
                        } catch (SQLException ex) {
                            System.out.println("Error: " + ex);
                        }
                    }
                }else if(id.length()<8) {
                    JOptionPane.showMessageDialog(this, "Error en Campo ID. Pocos caracteres. Debe tener 8 caracteres \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                } else if(id.length()>8){
                    JOptionPane.showMessageDialog(this, "Error en Campo ID. Excede de 8 caracteres \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AgregarDVD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregarMousePressed

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
        // TODO add your handling code here:
        try{
            VistaDVD dvd = new VistaDVD();
            dvd.setVisible(true);
            this.dispose();
        } catch (SQLException e){
            System.out.println("ERROR. " +e);
        }
    }//GEN-LAST:event_btnCancelarMousePressed

    private void txtTipoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTipoMousePressed

        if(txtTipo.getText().equals("Ingrese tipo material"))
            txtTipo.setText("");

        if(txtIdDvd.getText().equals("") || txtIdDvd.getText() == null)
            txtIdDvd.setText("Ingrese ID de DVD");

        if(txtTitulodvd.getText().equals("") || txtTitulodvd.getText() == null)
            txtTitulodvd.setText("Ingrese título");

        if(txtDirector.getText().equals("") || txtDirector.getText() == null)
            txtDirector.setText("Ingrese director");

        if(txtGenero.getText().equals("") || txtGenero.getText() == null)
            txtGenero.setText("Ingrese genero");

        if(txtDuracion.getText().equals("") || txtDuracion.getText() == null)
            txtDuracion.setText("Ingrese duracion");
    }//GEN-LAST:event_txtTipoMousePressed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

  
    public int insertarDirector(int idDirector, String director){
        String sql = "INSERT INTO directores (id,nombre_director) values (?,?)";
                    PreparedStatement stmt = null;
                    //ResultSet rs = null;
                    int rows = 0;
                    
                    try{
                        con = Conexion.getConnection();
                        stmt = con.prepareStatement(sql);
                        int index = 1;
                        stmt.setInt(index++, idDirector);
                        stmt.setString(index, director);
                        
                        rows = stmt.executeUpdate();
                        System.out.println("Registros afectados " + rows);
                    }catch(SQLException e){
                        System.out.println("error" + e);
                    } finally{
                        Conexion.close(stmt);
                        Conexion.close(con);
                    }
                    return rows;
    }
    
    public int insertarGenero(int idGenero, String genre){
        String sql = "INSERT INTO generos (id,nombre_genero) values (?,?)";
                    PreparedStatement stmt = null;
                    //ResultSet rs = null;
                    int rows = 0;
                    
                    try{
                        con = Conexion.getConnection();
                        stmt = con.prepareStatement(sql);
                        int index = 1;
                        stmt.setInt(index++, idGenero);
                        stmt.setString(index, genre);
                        
                        rows = stmt.executeUpdate();
                        System.out.println("Registros afectados " + rows);
                    }catch(SQLException e){
                        System.out.println("error" + e);
                    } finally{
                        Conexion.close(stmt);
                        Conexion.close(con);
                    }
                    return rows;
    }
    
    public int incrementarDirector() throws SQLException{
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conexion.getConnection();
        try{
            ps = con.prepareStatement("SELECT MAX(id) FROM directores");
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt(1) + 1;
            }
        }catch(SQLException e){
            System.out.println("Error: " + e);
        } finally{
            Conexion.close(con);
            Conexion.close(ps);
            Conexion.close(rs);
        }
        return id;
    }
    
    
    public int incrementarGenero() throws SQLException{
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conexion.getConnection();
        try{
            ps = con.prepareStatement("SELECT MAX(id) FROM generos");
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt(1) + 1;
            }
        }catch(SQLException e){
            System.out.println("Error: " + e);
        } finally{
            Conexion.close(con);
            Conexion.close(ps);
            Conexion.close(rs);
        }
        return id;
    }
    
    public void limpiarCampos(){
        txtIdDvd.setText("");
        txtTitulodvd.setText("");
        txtDirector.setText("");
        txtGenero.setText("");
        txtDuracion.setText("");
        txtTipo.setText("");
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
            java.util.logging.Logger.getLogger(AgregarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarDVD().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarDVD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblDVD;
    private javax.swing.JLabel lblDirector;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNewLibro;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulodvd;
    private javax.swing.JPanel pnlAgregarMenu;
    private javax.swing.JTextField txtDirector;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtIdDvd;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTitulodvd;
    // End of variables declaration//GEN-END:variables
}
