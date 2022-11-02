package entidades;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jorge Díaz
 */
public class Prestamos implements Serializable {

    private Integer id;

    private Date fechaPrestamo;

    private Date fechaDevolucion;

    private String codigoMaterial;

    private Integer codigoSocio;

    public Prestamos() {
    }

    public Prestamos(Integer id) {
        this.id = id;
    }

    public Prestamos(Integer id, Date fechaPrestamo, Date fechaDevolucion) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public Integer getCodigoSocio() {
        return codigoSocio;
    }

    public void setCodigoSocio(Integer codigoSocio) {
        this.codigoSocio = codigoSocio;
    }

    @Override
    public String toString() {
        return "entidades.Prestamos[ id=" + id + " ]";
    }
    
}
