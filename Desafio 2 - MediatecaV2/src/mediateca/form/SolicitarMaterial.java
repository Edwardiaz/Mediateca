package mediateca.form;

import datos.Conexion;
import entidades.Socios;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @erick alas
 */
public class SolicitarMaterial extends javax.swing.JFrame {

    Conexion conn = new Conexion();
    Connection con = conn.getConnection();
    Socios socios = new Socios();
    BuscarSocio buscar = new BuscarSocio();

    public SolicitarMaterial() throws SQLException {
        initComponents();
        this.setTitle("Realizar prestamo.");

        mostrarMaterial();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlcontenedor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSolicitud = new javax.swing.JTable();
        btnSolicitar = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtSocio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlcontenedor.setBackground(new java.awt.Color(255, 255, 255));
        pnlcontenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSolicitud.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        tblSolicitud.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSolicitudMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSolicitud);

        pnlcontenedor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 960, 180));

        btnSolicitar.setBackground(new java.awt.Color(255, 255, 255));
        btnSolicitar.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        btnSolicitar.setForeground(new java.awt.Color(102, 0, 153));
        btnSolicitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-prestar.png"))); // NOI18N
        btnSolicitar.setText("Solicitar");
        btnSolicitar.setBorder(null);
        btnSolicitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSolicitar.setIconTextGap(10);
        btnSolicitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSolicitarMousePressed(evt);
            }
        });
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });
        pnlcontenedor.add(btnSolicitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 400, 130, 50));

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
        pnlcontenedor.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 90, 50));
        pnlcontenedor.add(txtSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 130, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jLabel1.setText("Ingrese documento de Socio:");
        pnlcontenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlcontenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlcontenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        ElegirOpcion op = new ElegirOpcion();
        op.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMousePressed

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void btnSolicitarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSolicitarMousePressed

        //Bloque de código que ayuda a obtener el valor de la columna ID en la tabla 
        try {
            //Variable para almacenar el valor de la fla seleccionada
            int fila = tblSolicitud.getSelectedRow();

            String idMater = tblSolicitud.getValueAt(fila, 0).toString();
            String carnet = txtSocio.getText();
            
            //Condicionales
            if (!existeMaterial(idMater)) {
                JOptionPane.showMessageDialog(this, "No existe ningún material con ese ID. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            } else if (carnet.equals("") || carnet == null) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", JOptionPane.ERROR_MESSAGE);
            }
            
            //Bloque de código para verificar si el socio existe en el sistema
            boolean aceptado = existeSocio(carnet);
            if (!aceptado) {
                JOptionPane.showMessageDialog(this, "No existe ningún socio con ese documento. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                txtSocio.setText("");
                txtSocio.requestFocus();
            } else if (verificarPrestamo(carnet, idMater)) {
                JOptionPane.showMessageDialog(this, "El socio " + carnet +" ya cuenta con el material seleccionado. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                txtSocio.setText("");
            } else if (!materialDisp(idMater)){
                 JOptionPane.showMessageDialog(this, "No contamos con unidades de ese material. Intenta con otro \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                 txtSocio.setText("");
                 txtSocio.requestFocus();
            }  
            
            else {
                // Insertar el prestamo a la DB.
                insertarPrestamo(carnet, idMater);
                JOptionPane.showMessageDialog(this, "¡Prestamo realizado exitosamente! \n", "HECHO", JOptionPane.INFORMATION_MESSAGE);
                txtSocio.setText("");
                ElegirOpcion op = new ElegirOpcion();
                op.setVisible(true);
                this.dispose();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSolicitarMousePressed

    private void tblSolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSolicitudMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSolicitudMouseClicked

     public boolean materialDisp(String id_material) throws SQLException {
        boolean res = false;
        PreparedStatement stmt = con.prepareStatement("SELECT unidades_disponibles FROM materiales WHERE id = '" + id_material + "' LIMIT 1");
        ResultSet re = stmt.executeQuery();
        if (re.next()) {
            int d = Integer.parseInt(re.getString("unidades_disponibles"));
            if (d >= 1) {
                res = true;
            }
        }
        return res;
    }
    
    //Método para verificar si existe el material dentro del sistema
    public boolean existeMaterial(String id_material) throws SQLException {
        boolean res = false;
        Statement stm = con.createStatement();
        ResultSet re = stm.executeQuery("SELECT id FROM materiales WHERE id = '" + id_material + "' LIMIT 1");
        if (re.next()) {
            res = true;
        }
        return res;
    }
    
    //Método para verificar si existe el socio dentro del sistema
    public boolean existeSocio(String carne) throws SQLException {
        boolean res = false;
        Statement stm = con.createStatement();
        ResultSet re = stm.executeQuery("SELECT * FROM socios WHERE documento = '" + carne + "' LIMIT 1");
        if (re.next()) {
            res = true;
            socios.setDocumento(carne);
            //String doc = socios.getDocumento();
            //System.out.println(doc);
        }
        return res;
    }

    //Método para verificar si el prestamo ya existe
    public boolean verificarPrestamo(String carne, String id_material) throws SQLException {
        boolean res = false;
        Statement stm = con.createStatement();
        //SELECT prestamos.id, prestamos.codigo_material AS Material, socios.documento AS Socio, prestamos.fecha_prestamo, prestamos.fecha_devolucion FROM prestamos LEFT JOiN materiales ON materiales.id = prestamos.codigo_material LEFT JOIN socios on socios.id = prestamos.codigo_socio
        ResultSet re = stm.executeQuery("SELECT prestamos.id, prestamos.codigo_material AS Material, socios.documento AS Socio, prestamos.fecha_prestamo, prestamos.fecha_devolucion FROM prestamos LEFT JOiN materiales ON materiales.id = prestamos.codigo_material LEFT JOIN socios on socios.id = prestamos.codigo_socio WHERE codigo_material = '" +id_material+ "'AND socios.documento= '"+carne+"'");
        if (re.next()) {
            res = true;
        }
        return res;
    }
    
    //Método para insertar datos del prestamo (documento (carnet) y el id del material)
    public void insertarPrestamo(String carne, String id_material) throws SQLException {
        
        int idSocio = 0;
        int idPrestamo = 0;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //Convertir fecha de prestamo a tipo Date, para evitar problemas en tabla prestamos
        Date hoy = new Date();
        Date ahora = establecerFecha(hoy, 0);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String prestamo_hoy = formato.format(ahora);
        java.sql.Date conversion = null;

        try {
            Date fecha = formato.parse(prestamo_hoy);
            conversion = new java.sql.Date(fecha.getTime());
        }catch(Exception e){
            System.out.println("Error" + e);
        }
        
        //Convertir fecha de devolución a tipo Date, para evitar problemas en tabla prestamos
        Date actual = new Date();
        //Adicionar 5 días a la fecha actual.
        Date regresar = fechaDevolucion(actual, 5);
        SimpleDateFormat formato_dev = new SimpleDateFormat("dd-MM-yyyy");
        String prestamo_dev = formato_dev.format(regresar);
        java.sql.Date devolver = null;
        
        try {
           
            Date fecha = formato.parse(prestamo_dev);
            devolver = new java.sql.Date(fecha.getTime());
        }catch(Exception e){
            System.out.println("Error" + e);
        }
        
        //Sentencia para seleccionar el id del socio y almacenarlo en variable
        //Variable se pasará como parámetro del insert
        stmt = con.prepareStatement("SELECT socios.id FROM socios WHERE socios.documento = '" + carne + "'");
        rs = stmt.executeQuery();
        if (rs.next()) {
            idSocio = rs.getInt("id");
        }
        System.out.println(idSocio);
        
        //Bloque para seleccionar el id máximo de tabla prestamos y evitar que se salte y almacenarlo en variable
        //Variable se pasará como parámetro del insert
        //Será el id de prestamos
        stmt = con.prepareStatement("SELECT MAX(id) FROM prestamos");
        rs = stmt.executeQuery();
        while (rs.next()) {
            idPrestamo = rs.getInt(1) + 1;
        }
        System.out.println(idPrestamo);
        
        //Bloque de código para insertar información en tabla prestamos
        String sql = "INSERT INTO prestamos (id, codigo_material, codigo_socio, fecha_prestamo, fecha_devolucion)"
                + "values (?,?,?,?,?)";
        
        int rows = 0;

        try{
            stmt = con.prepareStatement(sql);
            
            int index = 1;
            stmt.setInt(index++, idPrestamo);
            stmt.setString(index++, id_material);
            stmt.setInt(index++, idSocio);
            stmt.setDate(index++,conversion);
            stmt.setDate(index, devolver);

            rows = stmt.executeUpdate();
            
            //Actualizar unidades disponibles de materiales
            stmt = con.prepareStatement("UPDATE materiales SET unidades_disponibles = unidades_disponibles -1 WHERE `id` = '" + id_material + "';");
            stmt.executeUpdate();
            
            System.out.println("Registros afectados " + rows);
        }catch(SQLException e){
            System.out.println("Error" + e);
        } finally{            
            Conexion.close(stmt);
            Conexion.close(con);
        }      
    }
    
    //Método para establecer fecha
    public static Date establecerFecha(java.util.Date ahora, int dia) {
        Calendar cale = new GregorianCalendar();
        cale.setTimeInMillis(ahora.getTime());
        cale.add(Calendar.DATE, dia);
        return new java.sql.Date(cale.getTimeInMillis());
    }
    
    //Método para establecer fecha de devolución
    public static java.sql.Date fechaDevolucion(java.util.Date fch, int dias) {
        Calendar cale = new GregorianCalendar();
        cale.setTimeInMillis(fch.getTime());
        cale.add(Calendar.DATE, dias);
        return new java.sql.Date(cale.getTimeInMillis());
    }
    
    //Método para mostrar el material
    public void mostrarMaterial() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConnection();

        try {
            String sql = "SELECT materiales.id, materiales.titulo, autores.nombre_autor AS Autor, materiales.numero_de_paginas, editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.periodicidad, materiales.fecha_publicacion, artistas.nombre_artista AS Artista, materiales.duracion, materiales.numero_de_canciones, materiales.unidades_disponibles, directores.nombre_director as Director, materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material LEFT JOIN autores on autores.id = materiales.codigo_autor LEFT JOIN artistas ON artistas.id = materiales.codigo_artista LEFT JOIN editoriales ON editoriales.id = materiales.codigo_editorial";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int count = 0;
            while (rs.next()) {
                count++;
            }

            String lista[][] = new String[count][15];
            int i = 0;
            ResultSet re = ps.executeQuery("SELECT materiales.id, materiales.titulo, autores.nombre_autor AS Autor, materiales.numero_de_paginas, editoriales.nombre_editorial AS Editorial, materiales.isbn, materiales.periodicidad, materiales.fecha_publicacion, artistas.nombre_artista AS Artista, materiales.duracion, materiales.numero_de_canciones, materiales.unidades_disponibles, directores.nombre_director as Director, materiales.duracion, generos.nombre_genero AS Genero,tipo_material.tipo_material AS Tipo from materiales LEFT JOIN directores on directores.id = materiales.codigo_director LEFT JOIN generos ON generos.id = materiales.codigo_genero LEFT JOIN tipo_material ON tipo_material.id = materiales.codigo_tipo_material LEFT JOIN autores on autores.id = materiales.codigo_autor LEFT JOIN artistas ON artistas.id = materiales.codigo_artista LEFT JOIN editoriales ON editoriales.id = materiales.codigo_editorial");
            while (re.next()) {
                lista[i][0] = re.getString("id");
                lista[i][1] = re.getString("titulo");
                lista[i][2] = re.getString("Tipo");
                lista[i][3] = re.getString("Autor");
                lista[i][4] = re.getString("numero_de_paginas");
                lista[i][5] = re.getString("Editorial");
                lista[i][6] = re.getString("isbn");
                lista[i][7] = re.getString("periodicidad");
                lista[i][8] = re.getString("fecha_publicacion");
                lista[i][9] = re.getString("Artista");
                lista[i][10] = re.getString("Genero");
                lista[i][11] = re.getString("duracion");
                lista[i][12] = re.getString("numero_de_canciones");
                lista[i][13] = re.getString("Director");
                lista[i][14] = re.getString("unidades_disponibles");
                i++;
            }

            tblSolicitud.setModel(new DefaultTableModel(
                    lista,
                    new String[]{
                        "ID", "Título", "Material", "Autor", "Número de Páginas", "Editorial", "ISBN", "Periodicidad", "Fecha de Pub.", "Artista", "Género", "Duración", "Número de canciones", "Director", "Disponibles"
                    }));
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
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
            java.util.logging.Logger.getLogger(SolicitarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitarMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SolicitarMaterial().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SolicitarMaterial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlcontenedor;
    private javax.swing.JTable tblSolicitud;
    private javax.swing.JTextField txtSocio;
    // End of variables declaration//GEN-END:variables
}
