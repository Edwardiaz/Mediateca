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
@Table(name = "directores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Directores.findAll", query = "SELECT d FROM Directores d")
    , @NamedQuery(name = "Directores.findById", query = "SELECT d FROM Directores d WHERE d.id = :id")
    , @NamedQuery(name = "Directores.findByNombreDirector", query = "SELECT d FROM Directores d WHERE d.nombreDirector = :nombreDirector")})
public class Directores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_director")
    private String nombreDirector;
    @OneToMany(mappedBy = "codigoDirector")
    private List<Materiales> materialesList;

    public Directores() {
    }

    public Directores(Integer id) {
        this.id = id;
    }

    public Directores(Integer id, String nombreDirector) {
        this.id = id;
        this.nombreDirector = nombreDirector;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
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
        if (!(object instanceof Directores)) {
            return false;
        }
        Directores other = (Directores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Directores[ id=" + id + " ]";
    }
    
}
