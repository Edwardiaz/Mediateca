/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamos.findAll", query = "SELECT p FROM Prestamos p")
    , @NamedQuery(name = "Prestamos.findById", query = "SELECT p FROM Prestamos p WHERE p.id = :id")
    , @NamedQuery(name = "Prestamos.findByFechaPrestamo", query = "SELECT p FROM Prestamos p WHERE p.fechaPrestamo = :fechaPrestamo")
    , @NamedQuery(name = "Prestamos.findByFechaDevolucion", query = "SELECT p FROM Prestamos p WHERE p.fechaDevolucion = :fechaDevolucion")})
public class Prestamos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Basic(optional = false)
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @JoinColumn(name = "codigo_material", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Materiales codigoMaterial;
    @JoinColumn(name = "codigo_socio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Socios codigoSocio;

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

    public Materiales getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(Materiales codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public Socios getCodigoSocio() {
        return codigoSocio;
    }

    public void setCodigoSocio(Socios codigoSocio) {
        this.codigoSocio = codigoSocio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamos)) {
            return false;
        }
        Prestamos other = (Prestamos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Prestamos[ id=" + id + " ]";
    }
    
}
