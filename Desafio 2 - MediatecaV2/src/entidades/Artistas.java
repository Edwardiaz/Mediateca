package entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jorge Díaz
 */
public class Artistas implements Serializable {

    private Integer id;

    private String nombreArtista;

    private List<Materiales> materialesList;

    public Artistas() {
    }

    public Artistas(Integer id) {
        this.id = id;
    }

    public Artistas(Integer id, String nombreArtista) {
        this.id = id;
        this.nombreArtista = nombreArtista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public List<Materiales> getMaterialesList() {
        return materialesList;
    }

    public void setMaterialesList(List<Materiales> materialesList) {
        this.materialesList = materialesList;
    }

    @Override
    public String toString() {
        return "entidades.Artistas[ id=" + id + " ]";
    }
    
}
