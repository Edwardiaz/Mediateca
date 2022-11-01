/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tipo_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMaterial.findAll", query = "SELECT t FROM TipoMaterial t")
    , @NamedQuery(name = "TipoMaterial.findById", query = "SELECT t FROM TipoMaterial t WHERE t.id = :id")
    , @NamedQuery(name = "TipoMaterial.findByTipoMaterial", query = "SELECT t FROM TipoMaterial t WHERE t.tipoMaterial = :tipoMaterial")})
public class TipoMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo_material")
    private String tipoMaterial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoMaterial")
    private List<Materiales> materialesList;

    public TipoMaterial() {
    }

    public TipoMaterial(Integer id) {
        this.id = id;
    }

    public TipoMaterial(Integer id, String tipoMaterial) {
        this.id = id;
        this.tipoMaterial = tipoMaterial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
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
        if (!(object instanceof TipoMaterial)) {
            return false;
        }
        TipoMaterial other = (TipoMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoMaterial[ id=" + id + " ]";
    }
    
}
