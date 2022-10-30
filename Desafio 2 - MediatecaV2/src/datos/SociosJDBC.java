package datos;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import entidades.Socios;
/**
 *
 * @erick alas
 */
public class SociosJDBC {
     private final String SQL_INSERT_INTO_SOCIOS
            = "INSERT INTO socios\n" +
              "(id, nombre, documento, telefono, "
            + "correo_electronico, fecha_nacimiento)\n" +
              "VALUES\n" +
              "(?, ?, ?, ?, ?, ?)";
     
    private final String SQL_UPDATE_SOCIOS
            = "UPDATE socios SET, nombre=?, documento=?, "
            + "telefono=?, correo_electronico=?, fecha_nacimiento=?";
    
    private final String SQL_DELETE_SOCIOS
            = "DELETE FROM socios WHERE documento=?";
    
    private final String SQL_SELECT_SOCIOS
            = "SELECT * FROM socios ORDER BY documento";
    
    /**
     * Metodo que inserta un registro en la tabla Materiales
     *
     * @param id
     * @param nombre
     * @param documento
     * @param telefono
     * @param correo_electronico
     * @param fecha_nacimiento
     * @return int con el num de registros afectadas
     */
    
        public int insert(int id, String nombre, String documento,
            String telefono, String correo_electronico, Date fecha_nacimiento) {
            
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;	
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_INTO_SOCIOS);
            int index = 1;//contador de columnas
            
            stmt.setInt(index++, id);
            stmt.setString(index++, nombre);
            stmt.setString(index++, documento);
            stmt.setString(index++, telefono);
            stmt.setString(index++, correo_electronico);
            stmt.setDate(index, fecha_nacimiento);
            
            System.out.println("Ejecutando query:" + SQL_INSERT_INTO_SOCIOS);
            rows = stmt.executeUpdate();//no. registros afectados
            System.out.println("Registros afectados:" + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
        
        /**
     * Metodo que actualiza un registro en la tabla Materiales
     *
     * @param id
     * @param nombre
     * @param documento
     * @param telefono
     * @param correo_electronico
     * @param fecha_nacimiento
     * @return int con el num de registros afectadas
     */
        
         public int update(int id, String nombre, String documento,
            String telefono, String correo_electronico, Date fecha_nacimiento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE_SOCIOS);
            stmt = conn.prepareStatement(SQL_UPDATE_SOCIOS);
            int index = 1;
            
            stmt.setInt(index++, id);
            stmt.setString(index++, nombre);
            stmt.setString(index++, documento);
            stmt.setString(index++, telefono);
            stmt.setString(index++, correo_electronico);
            stmt.setDate(index, fecha_nacimiento);
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }


   /**
     * Metodo que elimina un registro existente
     *
     * @param id Es la llave primaria de la tabla Materiales
     * @return int numero de registros afectados
     */
         
      public int delete(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE_SOCIOS);
            stmt = conn.prepareStatement(SQL_DELETE_SOCIOS);
            stmt.setString(1, id);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
        }
      
      public List<Socios> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Socios socio = null;
        List<Socios> socios = new ArrayList<Socios>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_SOCIOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String doc = rs.getString(3);
                /*System.out.print(" " + id_persona);
                 System.out.print(" " + nombre);
                 System.out.print(" " + apellido);
                 System.out.println();
                 */
                socio = new Socios();
                socio.setId(id);
                socio.setNombre(nombre);
                socio.setDocumento(doc);
                //material.setCodigoTipoMaterial(codigoTipoMaterial);
                socios.add(socio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return socios;
    
    }
      
}
      
     
