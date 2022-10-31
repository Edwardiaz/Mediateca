package entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jorge Díaz
 */
public class Directores implements Serializable {

    private Integer id;

    private String nombreDirector;

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
//        if (!(object instanceof Directores)) {
//            return false;
//        }
//        Directores other = (Directores) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
    @Override
    public String toString() {
        return "entidades.Directores[ id=" + id + " ]";
    }
    
}
