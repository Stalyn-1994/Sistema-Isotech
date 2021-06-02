/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

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
 * @author Stalyn
 */
@Entity
@Table(name = "solicitud_cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudCita.findAll", query = "SELECT s FROM SolicitudCita s"),
    @NamedQuery(name = "SolicitudCita.findByIdSolicitud", query = "SELECT s FROM SolicitudCita s WHERE s.idSolicitud = :idSolicitud"),
    @NamedQuery(name = "SolicitudCita.findByDescripcion", query = "SELECT s FROM SolicitudCita s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SolicitudCita.findByFechaInicio", query = "SELECT s FROM SolicitudCita s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "SolicitudCita.findByFechaFin", query = "SELECT s FROM SolicitudCita s WHERE s.fechaFin = :fechaFin")})
public class SolicitudCita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "id_visitante", referencedColumnName = "id_visitante")
    @ManyToOne
    private Visitante idVisitante;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    public SolicitudCita() {
    }

    public SolicitudCita(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Visitante getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Visitante idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCita)) {
            return false;
        }
        SolicitudCita other = (SolicitudCita) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.SolicitudCita[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
