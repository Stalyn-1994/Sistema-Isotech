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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stalyn
 */
@Entity
@Table(name = "cita_visitante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CitaVisitante.findAll", query = "SELECT c FROM CitaVisitante c"),
    @NamedQuery(name = "CitaVisitante.findByIdCitaV", query = "SELECT c FROM CitaVisitante c WHERE c.idCitaV = :idCitaV"),
    @NamedQuery(name = "CitaVisitante.findByFechaCitaVisitante", query = "SELECT c FROM CitaVisitante c WHERE c.fechaCitaVisitante = :fechaCitaVisitante"),
    @NamedQuery(name = "CitaVisitante.findByHoraCita", query = "SELECT c FROM CitaVisitante c WHERE c.horaCita = :horaCita")})
public class CitaVisitante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cita_v")
    private Integer idCitaV;
    @Column(name = "fecha_cita_visitante")
    @Temporal(TemporalType.DATE)
    private Date fechaCitaVisitante;
    @Column(name = "hora_cita")
    @Temporal(TemporalType.TIME)
    private Date horaCita;
    @JoinColumn(name = "id_visitante", referencedColumnName = "id_visitante")
    @ManyToOne(optional = false)
    private Visitante idVisitante;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoCita idEstado;
    @JoinColumn(name = "id_consultor", referencedColumnName = "id_consultor")
    @ManyToOne(optional = false)
    private Consultor idConsultor;

    public CitaVisitante() {
    }

    public CitaVisitante(Integer idCitaV) {
        this.idCitaV = idCitaV;
    }

    public Integer getIdCitaV() {
        return idCitaV;
    }

    public void setIdCitaV(Integer idCitaV) {
        this.idCitaV = idCitaV;
    }

    public Date getFechaCitaVisitante() {
        return fechaCitaVisitante;
    }

    public void setFechaCitaVisitante(Date fechaCitaVisitante) {
        this.fechaCitaVisitante = fechaCitaVisitante;
    }

    public Date getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Date horaCita) {
        this.horaCita = horaCita;
    }

    public Visitante getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Visitante idVisitante) {
        this.idVisitante = idVisitante;
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
        hash += (idCitaV != null ? idCitaV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitaVisitante)) {
            return false;
        }
        CitaVisitante other = (CitaVisitante) object;
        if ((this.idCitaV == null && other.idCitaV != null) || (this.idCitaV != null && !this.idCitaV.equals(other.idCitaV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.CitaVisitante[ idCitaV=" + idCitaV + " ]";
    }
    
}
