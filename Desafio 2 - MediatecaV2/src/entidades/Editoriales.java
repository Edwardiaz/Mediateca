/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jorge Díaz
 */
public class Editoriales implements Serializable {

    private Integer id;

    private String nombreEditorial;

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
//        if (!(object instanceof Editoriales)) {
//            return false;
//        }
//        Editoriales other = (Editoriales) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "entidades.Editoriales[ id=" + id + " ]";
    }
    
}
