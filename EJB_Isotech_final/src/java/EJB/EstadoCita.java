/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Stalyn
 */
@Entity
@Table(name = "estado_cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCita.findAll", query = "SELECT e FROM EstadoCita e"),
    @NamedQuery(name = "EstadoCita.findByIdEstado", query = "SELECT e FROM EstadoCita e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "EstadoCita.findByDescripcionEstado", query = "SELECT e FROM EstadoCita e WHERE e.descripcionEstado = :descripcionEstado")})
public class EstadoCita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Integer idEstado;
    @Size(max = 255)
    @Column(name = "descripcion_estado")
    private String descripcionEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<Documentos> documentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<CitaVisitante> citaVisitanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<Citas> citasList;

    public EstadoCita() {
    }

    public EstadoCita(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    @XmlTransient
    public List<Documentos> getDocumentosList() {
        return documentosList;
    }

    public void setDocumentosList(List<Documentos> documentosList) {
        this.documentosList = documentosList;
    }

    @XmlTransient
    public List<CitaVisitante> getCitaVisitanteList() {
        return citaVisitanteList;
    }

    public void setCitaVisitanteList(List<CitaVisitante> citaVisitanteList) {
        this.citaVisitanteList = citaVisitanteList;
    }

    @XmlTransient
    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCita)) {
            return false;
        }
        EstadoCita other = (EstadoCita) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.EstadoCita[ idEstado=" + idEstado + " ]";
    }
    
}
