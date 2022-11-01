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
public class VerPrestamos extends javax.swing.JFrame {

    Conexion conn = new Conexion();
    Connection con = conn.getConnection();
    
    public VerPrestamos() throws SQLException {
        initComponents();
        this.setTitle("Prestamos en sistema");
        this.setLocationRelativeTo(null);
        mostrarPrestamos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestamos = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        lblLibrosTabla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPrestamos.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        tblPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPrestamos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 530, 280));

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
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 90, 40));

        lblLibrosTabla.setBackground(new java.awt.Color(255, 255, 255));
        lblLibrosTabla.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        lblLibrosTabla.setForeground(new java.awt.Color(102, 0, 153));
        lblLibrosTabla.setText("Prestamos - Mediateca");
        jPanel1.add(lblLibrosTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 250, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMousePressed
        ElegirOpcion op = new ElegirOpcion();
        op.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasMousePressed

    
    public void  mostrarPrestamos() throws SQLException{
        //Variables a utilizar
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
        try{
            //Sentencia que permite seleccionar los datos de la tabla prestamos
            String sql = "SELECT prestamos.id, prestamos.codigo_material AS Material, socios.documento AS Socio, prestamos.fecha_prestamo, prestamos.fecha_devolucion FROM prestamos LEFT JOiN materiales ON materiales.id = prestamos.codigo_material LEFT JOIN socios on socios.id = prestamos.codigo_socio";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(); //Ejecución
            
            //Contador que ayuda a recorrer uno a uno las filas de la lista
            int count = 0;
            while(rs.next()){
                count++;
            }
            
            String lista[][] = new String[count][9];
            int i = 0;
            ResultSet re = stmt.executeQuery("SELECT prestamos.id, prestamos.codigo_material AS Material, socios.documento AS Socio, prestamos.fecha_prestamo, prestamos.fecha_devolucion FROM prestamos LEFT JOiN materiales ON materiales.id = prestamos.codigo_material LEFT JOIN socios on socios.id = prestamos.codigo_socio");
            while(re.next()){
                lista[i][0] = re.getString("id");
                lista[i][1] = re.getString("Material");
                lista[i][2] = re.getString("Socio");
                lista[i][3] = re.getString("fecha_prestamo");
                lista[i][4] = re.getString("fecha_devolucion");
                i++;
            }
            
            //Ingresar los dtaos en la tabla
            tblPrestamos.setModel(new DefaultTableModel(
        lista,
        new String [] {
            "ID", "Material", "Socio", "Fecha de Prestamo", "Fecha de Devolución"
        }));
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        } finally{
            Conexion.close(con);
            Conexion.close(rs);
        }
    } 
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VerPrestamos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VerPrestamos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLibrosTabla;
    private javax.swing.JTable tblPrestamos;
    // End of variables declaration//GEN-END:variables
}
