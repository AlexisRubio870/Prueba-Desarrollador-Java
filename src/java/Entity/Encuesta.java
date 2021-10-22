package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexis Rubio
 */
@Entity
@Table(name = "encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e")
    , @NamedQuery(name = "Encuesta.findByIdEncuesta", query = "SELECT e FROM Encuesta e WHERE e.idEncuesta = :idEncuesta")
    , @NamedQuery(name = "Encuesta.findByNoDocumentoEncuesta", query = "SELECT e FROM Encuesta e WHERE e.noDocumentoEncuesta = :noDocumentoEncuesta")
    , @NamedQuery(name = "Encuesta.findByEmailEncuesta", query = "SELECT e FROM Encuesta e WHERE e.emailEncuesta = :emailEncuesta")
    , @NamedQuery(name = "Encuesta.findByComentariosEncuesta", query = "SELECT e FROM Encuesta e WHERE e.comentariosEncuesta = :comentariosEncuesta")
    , @NamedQuery(name = "Encuesta.findByFechaRespuestaEncuesta", query = "SELECT e FROM Encuesta e WHERE e.fechaRespuestaEncuesta = :fechaRespuestaEncuesta")})
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_encuesta")
    private Integer idEncuesta;
    @Column(name = "noDocumento_Encuesta")
    private Integer noDocumentoEncuesta;
    @Size(max = 30)
    @Column(name = "email_Encuesta")
    private String emailEncuesta;
    @Size(max = 150)
    @Column(name = "comentarios_Encuesta")
    private String comentariosEncuesta;
    @Column(name = "fechaRespuesta_Encuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRespuestaEncuesta;
    @JoinColumn(name = "marcaPC_Encuesta", referencedColumnName = "id_marca")
    @ManyToOne
    private Marcaspc marcaPCEncuesta;

    public Encuesta() {
    }

    public Encuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Integer getNoDocumentoEncuesta() {
        return noDocumentoEncuesta;
    }

    public void setNoDocumentoEncuesta(Integer noDocumentoEncuesta) {
        this.noDocumentoEncuesta = noDocumentoEncuesta;
    }

    public String getEmailEncuesta() {
        return emailEncuesta;
    }

    public void setEmailEncuesta(String emailEncuesta) {
        this.emailEncuesta = emailEncuesta;
    }

    public String getComentariosEncuesta() {
        return comentariosEncuesta;
    }

    public void setComentariosEncuesta(String comentariosEncuesta) {
        this.comentariosEncuesta = comentariosEncuesta;
    }

    public Date getFechaRespuestaEncuesta() {
        return fechaRespuestaEncuesta;
    }

    public void setFechaRespuestaEncuesta(Date fechaRespuestaEncuesta) {
        this.fechaRespuestaEncuesta = fechaRespuestaEncuesta;
    }

    public Marcaspc getMarcaPCEncuesta() {
        return marcaPCEncuesta;
    }

    public void setMarcaPCEncuesta(Marcaspc marcaPCEncuesta) {
        this.marcaPCEncuesta = marcaPCEncuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncuesta != null ? idEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.idEncuesta == null && other.idEncuesta != null) || (this.idEncuesta != null && !this.idEncuesta.equals(other.idEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Encuesta[ idEncuesta=" + idEncuesta + " ]";
    }
    
}
