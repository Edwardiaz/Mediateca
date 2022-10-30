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
@Table(name = "editoriales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editoriales.findAll", query = "SELECT e FROM Editoriales e")
    , @NamedQuery(name = "Editoriales.findById", query = "SELECT e FROM Editoriales e WHERE e.id = :id")
    , @NamedQuery(name = "Editoriales.findByNombreEditorial", query = "SELECT e FROM Editoriales e WHERE e.nombreEditorial = :nombreEditorial")})
public class Editoriales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_editorial")
    private String nombreEditorial;
    @OneToMany(mappedBy = "codigoEditorial")
    private List<Materiales> materialesList;

    public Editoriales() {
    }

    public Editoriales(Integer id) {
        this.id = id;
    }

    public Editoriales(Integer id, String nombreEditorial) {
        this.id = id;
        this.nombreEditorial = nombreEditorial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
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
        if (!(object instanceof Editoriales)) {
            return false;
        }
        Editoriales other = (Editoriales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Editoriales[ id=" + id + " ]";
    }
    
}
