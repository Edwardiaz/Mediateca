package entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jorge Díaz
 */
public class TipoMaterial implements Serializable {

    private Integer id;

    private String tipoMaterial;

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

    public List<Materiales> getMaterialesList() {
        return materialesList;
    }

    public void setMaterialesList(List<Materiales> materialesList) {
        this.materialesList = materialesList;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof TipoMaterial)) {
//            return false;
//        }
//        TipoMaterial other = (TipoMaterial) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "entidades.TipoMaterial[ id=" + id + " ]";
    }
    
}
