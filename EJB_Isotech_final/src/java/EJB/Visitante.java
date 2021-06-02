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
@Table(name = "visitante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitante.findAll", query = "SELECT v FROM Visitante v"),
    @NamedQuery(name = "Visitante.findByIdVisitante", query = "SELECT v FROM Visitante v WHERE v.idVisitante = :idVisitante"),
    @NamedQuery(name = "Visitante.findByCiVisitante", query = "SELECT v FROM Visitante v WHERE v.ciVisitante = :ciVisitante"),
    @NamedQuery(name = "Visitante.findByNombreVisitante", query = "SELECT v FROM Visitante v WHERE v.nombreVisitante = :nombreVisitante"),
    @NamedQuery(name = "Visitante.findByApellidoVisitante", query = "SELECT v FROM Visitante v WHERE v.apellidoVisitante = :apellidoVisitante"),
    @NamedQuery(name = "Visitante.findByCorreoVisitante", query = "SELECT v FROM Visitante v WHERE v.correoVisitante = :correoVisitante"),
    @NamedQuery(name = "Visitante.findByTelefonoVisitante", query = "SELECT v FROM Visitante v WHERE v.telefonoVisitante = :telefonoVisitante"),
    @NamedQuery(name = "Visitante.findByCiudad", query = "SELECT v FROM Visitante v WHERE v.ciudad = :ciudad"),
    @NamedQuery(name = "Visitante.findByEmpresa", query = "SELECT v FROM Visitante v WHERE v.empresa = :empresa"),
    @NamedQuery(name = "Visitante.findByMensaje", query = "SELECT v FROM Visitante v WHERE v.mensaje = :mensaje")})
public class Visitante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_visitante")
    private Integer idVisitante;
    @Size(max = 255)
    @Column(name = "ci_visitante")
    private String ciVisitante;
    @Size(max = 255)
    @Column(name = "nombre_visitante")
    private String nombreVisitante;
    @Size(max = 255)
    @Column(name = "apellido_visitante")
    private String apellidoVisitante;
    @Size(max = 255)
    @Column(name = "correo_visitante")
    private String correoVisitante;
    @Size(max = 255)
    @Column(name = "telefono_visitante")
    private String telefonoVisitante;
    @Size(max = 255)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 255)
    @Column(name = "empresa")
    private String empresa;
    @Size(max = 255)
    @Column(name = "mensaje")
    private String mensaje;
    @OneToMany(mappedBy = "idVisitante")
    private List<SolicitudCita> solicitudCitaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVisitante")
    private List<CitaVisitante> citaVisitanteList;

    public Visitante() {
    }

    public Visitante(Integer idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Integer getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Integer idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getCiVisitante() {
        return ciVisitante;
    }

    public void setCiVisitante(String ciVisitante) {
        this.ciVisitante = ciVisitante;
    }

    public String getNombreVisitante() {
        return nombreVisitante;
    }

    public void setNombreVisitante(String nombreVisitante) {
        this.nombreVisitante = nombreVisitante;
    }

    public String getApellidoVisitante() {
        return apellidoVisitante;
    }

    public void setApellidoVisitante(String apellidoVisitante) {
        this.apellidoVisitante = apellidoVisitante;
    }

    public String getCorreoVisitante() {
        return correoVisitante;
    }

    public void setCorreoVisitante(String correoVisitante) {
        this.correoVisitante = correoVisitante;
    }

    public String getTelefonoVisitante() {
        return telefonoVisitante;
    }

    public void setTelefonoVisitante(String telefonoVisitante) {
        this.telefonoVisitante = telefonoVisitante;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @XmlTransient
    public List<SolicitudCita> getSolicitudCitaList() {
        return solicitudCitaList;
    }

    public void setSolicitudCitaList(List<SolicitudCita> solicitudCitaList) {
        this.solicitudCitaList = solicitudCitaList;
    }

    @XmlTransient
    public List<CitaVisitante> getCitaVisitanteList() {
        return citaVisitanteList;
    }

    public void setCitaVisitanteList(List<CitaVisitante> citaVisitanteList) {
        this.citaVisitanteList = citaVisitanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisitante != null ? idVisitante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitante)) {
            return false;
        }
        Visitante other = (Visitante) object;
        if ((this.idVisitante == null && other.idVisitante != null) || (this.idVisitante != null && !this.idVisitante.equals(other.idVisitante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Visitante[ idVisitante=" + idVisitante + " ]";
    }
    
}
