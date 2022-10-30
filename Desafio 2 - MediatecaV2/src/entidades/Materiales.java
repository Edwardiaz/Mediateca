package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorge Díaz
 */
public class Materiales implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    
    private String titulo;
    
    private String numeroDePaginas;
    
    private String isbn;
    
    private String periodicidad;
    
    private Date fechaPublicacion;
    
    private String duracion;
    
    private String numeroDeCanciones;
    
    private Integer unidadesDisponibles;
    
    private Artistas codigoArtista;
    @JoinColumn(name = "codigo_autor", referencedColumnName = "id")
    @ManyToOne
    private Autores codigoAutor;
    @JoinColumn(name = "codigo_director", referencedColumnName = "id")
    @ManyToOne
    private Directores codigoDirector;
    @JoinColumn(name = "codigo_editorial", referencedColumnName = "id")
    @ManyToOne
    private Editoriales codigoEditorial;
    @JoinColumn(name = "codigo_genero", referencedColumnName = "id")
    @ManyToOne
    private Generos codigoGenero;
    @JoinColumn(name = "codigo_tipo_material", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoMaterial codigoTipoMaterial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoMaterial")
    private List<Prestamos> prestamosList;

    public Materiales() {
    }

    public Materiales(String id) {
        this.id = id;
    }

    public Materiales(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

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

    public Artistas getCodigoArtista() {
        return codigoArtista;
    }

    public void setCodigoArtista(Artistas codigoArtista) {
        this.codigoArtista = codigoArtista;
    }

    public Autores getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(Autores codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public Directores getCodigoDirector() {
        return codigoDirector;
    }

    public void setCodigoDirector(Directores codigoDirector) {
        this.codigoDirector = codigoDirector;
    }

    public Editoriales getCodigoEditorial() {
        return codigoEditorial;
    }

    public void setCodigoEditorial(Editoriales codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }

    public Generos getCodigoGenero() {
        return codigoGenero;
    }

    public void setCodigoGenero(Generos codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    public TipoMaterial getCodigoTipoMaterial() {
        return codigoTipoMaterial;
    }

    public void setCodigoTipoMaterial(TipoMaterial codigoTipoMaterial) {
        this.codigoTipoMaterial = codigoTipoMaterial;
    }

    @XmlTransient
    public List<Prestamos> getPrestamosList() {
        return prestamosList;
    }

    public void setPrestamosList(List<Prestamos> prestamosList) {
        this.prestamosList = prestamosList;
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
        if (!(object instanceof Materiales)) {
            return false;
        }
        Materiales other = (Materiales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Materiales[ id=" + id + " ]";
    }
    
}
