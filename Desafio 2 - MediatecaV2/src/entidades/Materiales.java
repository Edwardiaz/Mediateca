package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jorge Díaz
 */
public class Materiales implements Serializable {

    private String id;
    
    private String titulo;
    
    private String numeroDePaginas;
    
    private String isbn;
    
    private String periodicidad;
    
    private Date fechaPublicacion;
    
    private String duracion;
    
    private String numeroDeCanciones;
    
    private Integer unidadesDisponibles;
    
    private Integer codigoArtista;
    private Integer codigoAutor;
    private Integer codigoDirector;
    private Integer codigoEditorial;
    private Integer codigoGenero;
    //private TipoMaterial codigoTipoMaterial;
    private Integer codigoTipoMaterial;
    private List<Prestamos> prestamosList;

    public Materiales() {
    }

    public Materiales(String id) {
        this.id = id;
    }

    public Materiales(String id, String titulo, String numeroDePaginas, String isbn, String periodicidad, Date fechaPublicacion, String duracion, String numeroDeCanciones, Integer unidadesDisponibles, Integer codigoArtista, Integer codigoAutor, Integer codigoDirector, Integer codigoEditorial, Integer codigoGenero, Integer codigoTipoMaterial) {
        this.id = id;
        this.titulo = titulo;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.periodicidad = periodicidad;
        this.fechaPublicacion = fechaPublicacion;
        this.duracion = duracion;
        this.numeroDeCanciones = numeroDeCanciones;
        this.unidadesDisponibles = unidadesDisponibles;
        this.codigoArtista = codigoArtista;
        this.codigoAutor = codigoAutor;
        this.codigoDirector = codigoDirector;
        this.codigoEditorial = codigoEditorial;
        this.codigoGenero = codigoGenero;
        this.codigoTipoMaterial = codigoTipoMaterial;
    }
    
//    public Materiales(String id, String titulo) {
//        this.id = id;
//        this.titulo = titulo;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(String numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNumeroDeCanciones() {
        return numeroDeCanciones;
    }

    public void setNumeroDeCanciones(String numeroDeCanciones) {
        this.numeroDeCanciones = numeroDeCanciones;
    }

    public Integer getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(Integer unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public Integer getCodigoArtista() {
        return codigoArtista;
    }

    public void setCodigoArtista(Integer codigoArtista) {
        this.codigoArtista = codigoArtista;
    }

    public Integer getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(Integer codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public Integer getCodigoDirector() {
        return codigoDirector;
    }

    public void setCodigoDirector(Integer codigoDirector) {
        this.codigoDirector = codigoDirector;
    }

    public Integer getCodigoEditorial() {
        return codigoEditorial;
    }

    public void setCodigoEditorial(Integer codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }

    public Integer getCodigoGenero() {
        return codigoGenero;
    }

    public void setCodigoGenero(Integer codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    public Integer getCodigoTipoMaterial() {
        return codigoTipoMaterial;
    }

    public void setCodigoTipoMaterial(Integer codigoTipoMaterial) {
        this.codigoTipoMaterial = codigoTipoMaterial;
    }

    public List<Prestamos> getPrestamosList() {
        return prestamosList;
    }

    public void setPrestamosList(List<Prestamos> prestamosList) {
        this.prestamosList = prestamosList;
    }
//
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
//        if (!(object instanceof Materiales)) {
//            return false;
//        }
//        Materiales other = (Materiales) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "entidades.Materiales[ id=" + id + " ]";
    }
    
}
