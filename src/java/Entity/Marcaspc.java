package Entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexis Rubio
 */
@Entity
@Table(name = "marcaspc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcaspc.findAll", query = "SELECT m FROM Marcaspc m")
    , @NamedQuery(name = "Marcaspc.findByIdMarca", query = "SELECT m FROM Marcaspc m WHERE m.idMarca = :idMarca")
    , @NamedQuery(name = "Marcaspc.findByNombreMarcaEncuesta", query = "SELECT m FROM Marcaspc m WHERE m.nombreMarcaEncuesta = :nombreMarcaEncuesta")})
public class Marcaspc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marca")
    private Integer idMarca;
    @Size(max = 20)
    @Column(name = "nombreMarca_Encuesta")
    private String nombreMarcaEncuesta;
    @OneToMany(mappedBy = "marcaPCEncuesta")
    private Collection<Encuesta> encuestaCollection;

    public Marcaspc() {
    }

    public Marcaspc(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarcaEncuesta() {
        return nombreMarcaEncuesta;
    }

    public void setNombreMarcaEncuesta(String nombreMarcaEncuesta) {
        this.nombreMarcaEncuesta = nombreMarcaEncuesta;
    }

    @XmlTransient
    public Collection<Encuesta> getEncuestaCollection() {
        return encuestaCollection;
    }

    public void setEncuestaCollection(Collection<Encuesta> encuestaCollection) {
        this.encuestaCollection = encuestaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarca != null ? idMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcaspc)) {
            return false;
        }
        Marcaspc other = (Marcaspc) object;
        if ((this.idMarca == null && other.idMarca != null) || (this.idMarca != null && !this.idMarca.equals(other.idMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Marcaspc[ idMarca=" + idMarca + " ]";
    }
    
}
