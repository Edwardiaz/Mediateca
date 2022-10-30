package datos;

import entidades.Materiales;
import entidades.TipoMaterial;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge Díaz
 */
public class MaterialesJDBC {
    
    private final String SQL_INSERT_INTO_MATERIALES
            = "INSERT INTO materiales\n" +
              "(id, titulo, codigo_tipo_material, codigo_autor, "
            + "numero_de_paginas, codigo_editorial, isbn, periodicidad, "
            + "fecha_publicacion, codigo_artista, codigo_genero, duracion, "
            + "numero_de_canciones, codigo_director, unidades_disponibles)\n" +
              "VALUES\n" +
              "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_UPDATE_MATERIALES
            = "UPDATE materiales SET, titulo=?, codigo_tipo_material=?, "
            + "codigo_autor=?, numero_de_paginas=?, codigo_editorial=?, isbn=?, "
            + "periodicidad=?, fecha_publicacion=?, codigo_artista=?, "
            + "codigo_genero=?, duracion=?, numero_de_canciones=?, "
            + "codigo_director=?, unidades_disponibles=?";
    private final String SQL_DELETE_MATERIALES
            = "DELETE FROM materiales WHERE id=?";
    private final String SQL_SELECT_MATERIALES
            = "SELECT * FROM `materiales` ORDER BY `isbn` ASC ";
    
    /**
     * Metodo que inserta un registro en la tabla Materiales
     *
     * @param id
     * @param titulo
     * @param codigo_tipo_material
     * @param codigo_autor
     * @param numero_de_paginas
     * @param codigo_editorial
     * @param isbn
     * @param periodicidad
     * @param fecha_publicacion
     * @param codigo_artista
     * @param codigo_genero
     * @param duracion
     * @param numero_de_canciones
     * @param codigo_director
     * @param unidades_disponibles
     * @return int con el num de registros afectadas
     */
    public int insert(String id, String titulo, int codigo_tipo_material, 
            int codigo_autor, String numero_de_paginas, int codigo_editorial, 
            String isbn, String periodicidad, Date fecha_publicacion, 
            int codigo_artista, int codigo_genero, String duracion, 
            int numero_de_canciones, int codigo_director, int unidades_disponibles) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;	
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_INTO_MATERIALES);
            int index = 1;//contador de columnas
            
            stmt.setString(index++, id);
            stmt.setString(index++, titulo);
            stmt.setInt(index++, codigo_tipo_material);
            stmt.setInt(index++, codigo_autor);
            stmt.setString(index++, numero_de_paginas);
            stmt.setInt(index++, codigo_editorial);
            stmt.setString(index++, isbn);
            stmt.setString(index++, periodicidad);
            stmt.setDate(index++, fecha_publicacion);
            stmt.setInt(index++, codigo_artista);
            stmt.setInt(index++, codigo_genero);
            stmt.setString(index++, duracion);
            stmt.setInt(index++, numero_de_canciones);
            stmt.setInt(index++, codigo_director);
            stmt.setInt(index++, unidades_disponibles);
            
            System.out.println("Ejecutando query:" + SQL_INSERT_INTO_MATERIALES);
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
     * Metodo que inserta un registro en la tabla Materiales
     *
     * @param id
     * @param titulo
     * @param codigo_tipo_material
     * @param codigo_autor
     * @param numero_de_paginas
     * @param codigo_editorial
     * @param isbn
     * @param periodicidad
     * @param fecha_publicacion
     * @param codigo_artista
     * @param codigo_genero
     * @param duracion
     * @param numero_de_canciones
     * @param codigo_director
     * @param unidades_disponibles
     * @return int con el num de registros afectadas
     */
    public int update(String id, String titulo, int codigo_tipo_material, 
            int codigo_autor, String numero_de_paginas, int codigo_editorial, 
            String isbn, String periodicidad, Date fecha_publicacion, 
            int codigo_artista, int codigo_genero, String duracion, 
            int numero_de_canciones, int codigo_director, int unidades_disponibles) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE_MATERIALES);
            stmt = conn.prepareStatement(SQL_UPDATE_MATERIALES);
            int index = 1;
            
            stmt.setString(index++, id);
            stmt.setString(index++, titulo);
            stmt.setInt(index++, codigo_tipo_material);
            stmt.setInt(index++, codigo_autor);
            stmt.setString(index++, numero_de_paginas);
            stmt.setInt(index++, codigo_editorial);
            stmt.setString(index++, isbn);
            stmt.setString(index++, periodicidad);
            stmt.setDate(index++, fecha_publicacion);
            stmt.setInt(index++, codigo_artista);
            stmt.setInt(index++, codigo_genero);
            stmt.setString(index++, duracion);
            stmt.setInt(index++, numero_de_canciones);
            stmt.setInt(index++, codigo_director);
            stmt.setInt(index++, unidades_disponibles);
            
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
            System.out.println("Ejecutando query:" + SQL_DELETE_MATERIALES);
            stmt = conn.prepareStatement(SQL_DELETE_MATERIALES);
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
    
    /**
     * Metodo que regresa el contenido de la tabla de personas
     */
    public List<Materiales> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Materiales material = null;
        List<Materiales> materiales = new ArrayList<Materiales>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_MATERIALES);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String titulo = rs.getString(2);
                //String codigoTipoMaterial = rs.getString(3);
                //String codigoAutor = rs.getString(4);
                String num_paginas = rs.getString(5);
                /*System.out.print(" " + id_persona);
                 System.out.print(" " + nombre);
                 System.out.print(" " + apellido);
                 System.out.println();
                 */
                material = new Materiales();
                material.setId(id);
                material.setTitulo(titulo);
                material.setNumeroDePaginas(num_paginas);
                
                
                //material.setCodigoTipoMaterial(codigoTipoMaterial);
                materiales.add(material);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return materiales;
    }
    
    
}
