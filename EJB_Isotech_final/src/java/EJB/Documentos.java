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
@Table(name = "documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentos.findAll", query = "SELECT d FROM Documentos d"),
    @NamedQuery(name = "Documentos.findByIdDocumentos", query = "SELECT d FROM Documentos d WHERE d.idDocumentos = :idDocumentos"),
    @NamedQuery(name = "Documentos.findByFechaInicio", query = "SELECT d FROM Documentos d WHERE d.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Documentos.findByFechaFin", query = "SELECT d FROM Documentos d WHERE d.fechaFin = :fechaFin"),
    @NamedQuery(name = "Documentos.findByTipoIso", query = "SELECT d FROM Documentos d WHERE d.tipoIso = :tipoIso"),
     @NamedQuery(name = "Documentos.documento1", query = "SELECT d FROM Documentos d WHERE d.idDocumentos = 1"),
    @NamedQuery(name = "Documentos.documento2", query = "SELECT d FROM Documentos d WHERE d.idDocumentos = 2"),
    @NamedQuery(name = "Documentos.documento3", query = "SELECT d FROM Documentos d WHERE d.idDocumentos = 3"),
    @NamedQuery(name = "Documentos.documento4", query = "SELECT d FROM Documentos d WHERE d.idDocumentos = 4"),
    @NamedQuery(name = "Documentos.findByIdConsultor", query = "SELECT d FROM Documentos d WHERE d.idEstado.idEstado < 3"),
    @NamedQuery(name = "Documentos.findByIdEstado", query = "SELECT d FROM Documentos d WHERE d.idEstado.idEstado = 3"),
    @NamedQuery(name = "Documentos.findByNumCedula", query = "SELECT d FROM Documentos d WHERE d.idUser.idUsuario = :idUser"),
    @NamedQuery(name = "Documentos.findByObservacion", query = "SELECT d FROM Documentos d WHERE d.observacion = :observacion")})
public class Documentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documentos")
    private Integer idDocumentos;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 255)
    @Column(name = "tipo_iso")
    private String tipoIso;
    @Size(max = 255)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_user", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUser;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoCita idEstado;
    @JoinColumn(name = "id_consultor", referencedColumnName = "id_consultor")
    @ManyToOne(optional = false)
    private Consultor idConsultor;

    public Documentos() {
    }

    public Documentos(Integer idDocumentos) {
        this.idDocumentos = idDocumentos;
    }

    public Integer getIdDocumentos() {
        return idDocumentos;
    }

    public void setIdDocumentos(Integer idDocumentos) {
        this.idDocumentos = idDocumentos;
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

    public String getTipoIso() {
        return tipoIso;
    }

    public void setTipoIso(String tipoIso) {
        this.tipoIso = tipoIso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Usuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Usuario idUser) {
        this.idUser = idUser;
    }

    public EstadoCita getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoCita idEstado) {
        this.idEstado = idEstado;
    }

    public Consultor getIdConsultor() {
        return idConsultor;
    }

    public void setIdConsultor(Consultor idConsultor) {
        this.idConsultor = idConsultor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentos != null ? idDocumentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentos)) {
            return false;
        }
        Documentos other = (Documentos) object;
        if ((this.idDocumentos == null && other.idDocumentos != null) || (this.idDocumentos != null && !this.idDocumentos.equals(other.idDocumentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Documentos[ idDocumentos=" + idDocumentos + " ]";
    }
    
}
