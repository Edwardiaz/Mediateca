/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "generos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Generos.findAll", query = "SELECT g FROM Generos g")
    , @NamedQuery(name = "Generos.findById", query = "SELECT g FROM Generos g WHERE g.id = :id")
    , @NamedQuery(name = "Generos.findByNombreGenero", query = "SELECT g FROM Generos g WHERE g.nombreGenero = :nombreGenero")})
public class Generos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_genero")
    private String nombreGenero;
    @OneToMany(mappedBy = "codigoGenero")
    private List<Materiales> materialesList;

    public Generos() {
    }

    public Generos(Integer id) {
        this.id = id;
    }

    public Generos(Integer id, String nombreGenero) {
        this.id = id;
        this.nombreGenero = nombreGenero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    @XmlTransient
    public List<Materiales> getMaterialesList() {
        return materialesList;
    }

    public void setMaterialesList(List<Materiales> materialesList) {
        this.materialesList = materialesList;
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
        if (!(object instanceof Generos)) {
            return false;
        }
        Generos other = (Generos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Generos[ id=" + id + " ]";
    }
    
}
