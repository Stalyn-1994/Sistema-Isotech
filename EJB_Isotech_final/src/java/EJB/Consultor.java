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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "consultor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultor.findAll", query = "SELECT c FROM Consultor c"),
    @NamedQuery(name = "Consultor.findByIdConsultor", query = "SELECT c FROM Consultor c WHERE c.idConsultor = :idConsultor"),
    @NamedQuery(name = "Consultor.findByCiConsultor", query = "SELECT c FROM Consultor c WHERE c.ciConsultor = :ciConsultor"),
    @NamedQuery(name = "Consultor.findByNombreConsultor", query = "SELECT c FROM Consultor c WHERE c.nombreConsultor = :nombreConsultor"),
    @NamedQuery(name = "Consultor.findByApellidoConsultor", query = "SELECT c FROM Consultor c WHERE c.apellidoConsultor = :apellidoConsultor"),
    @NamedQuery(name = "Consultor.findByCorreoConsultor", query = "SELECT c FROM Consultor c WHERE c.correoConsultor = :correoConsultor"),
    @NamedQuery(name = "Consultor.findByTelefonoConsultor", query = "SELECT c FROM Consultor c WHERE c.telefonoConsultor = :telefonoConsultor"),
    @NamedQuery(name = "Consultor.findByUsuarioConsultor", query = "SELECT c FROM Consultor c WHERE c.usuarioConsultor = :usuarioConsultor"),
    @NamedQuery(name = "Consultor.findByContraseniaConsultor", query = "SELECT c FROM Consultor c WHERE c.contraseniaConsultor = :contraseniaConsultor"),
    @NamedQuery(name = "Consultor.consultor1", query = "SELECT c FROM Consultor c WHERE c.idConsultor = 1"),
     @NamedQuery(name = "Consultor.validarConsultor", query = "SELECT c FROM Consultor c WHERE c.usuarioConsultor = :usuarioConsultor and c.contraseniaConsultor = :contraseniaConsultor"),
    @NamedQuery(name = "Consultor.findByImagenConsultor", query = "SELECT c FROM Consultor c WHERE c.imagenConsultor = :imagenConsultor")})
public class Consultor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consultor")
    private Integer idConsultor;
    @Size(max = 255)
    @Column(name = "ci_consultor")
    private String ciConsultor;
    @Size(max = 255)
    @Column(name = "nombre_consultor")
    private String nombreConsultor;
    @Size(max = 255)
    @Column(name = "apellido_consultor")
    private String apellidoConsultor;
    @Size(max = 255)
    @Column(name = "correo_consultor")
    private String correoConsultor;
    @Size(max = 255)
    @Column(name = "telefono_consultor")
    private String telefonoConsultor;
    @Size(max = 255)
    @Column(name = "usuario_consultor")
    private String usuarioConsultor;
    @Size(max = 255)
    @Column(name = "contrasenia_consultor")
    private String contraseniaConsultor;
    @Size(max = 255)
    @Column(name = "imagen_consultor")
    private String imagenConsultor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsultor")
    private List<Documentos> documentosList;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private TipoUser idTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsultor")
    private List<CitaVisitante> citaVisitanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsultor")
    private List<Citas> citasList;

    public Consultor() {
    }

    public Consultor(Integer idConsultor) {
        this.idConsultor = idConsultor;
    }

    public Integer getIdConsultor() {
        return idConsultor;
    }

    public void setIdConsultor(Integer idConsultor) {
        this.idConsultor = idConsultor;
    }

    public String getCiConsultor() {
        return ciConsultor;
    }

    public void setCiConsultor(String ciConsultor) {
        this.ciConsultor = ciConsultor;
    }

    public String getNombreConsultor() {
        return nombreConsultor;
    }

    public void setNombreConsultor(String nombreConsultor) {
        this.nombreConsultor = nombreConsultor;
    }

    public String getApellidoConsultor() {
        return apellidoConsultor;
    }

    public void setApellidoConsultor(String apellidoConsultor) {
        this.apellidoConsultor = apellidoConsultor;
    }

    public String getCorreoConsultor() {
        return correoConsultor;
    }

    public void setCorreoConsultor(String correoConsultor) {
        this.correoConsultor = correoConsultor;
    }

    public String getTelefonoConsultor() {
        return telefonoConsultor;
    }

    public void setTelefonoConsultor(String telefonoConsultor) {
        this.telefonoConsultor = telefonoConsultor;
    }

    public String getUsuarioConsultor() {
        return usuarioConsultor;
    }

    public void setUsuarioConsultor(String usuarioConsultor) {
        this.usuarioConsultor = usuarioConsultor;
    }

    public String getContraseniaConsultor() {
        return contraseniaConsultor;
    }

    public void setContraseniaConsultor(String contraseniaConsultor) {
        this.contraseniaConsultor = contraseniaConsultor;
    }

    public String getImagenConsultor() {
        return imagenConsultor;
    }

    public void setImagenConsultor(String imagenConsultor) {
        this.imagenConsultor = imagenConsultor;
    }

    @XmlTransient
    public List<Documentos> getDocumentosList() {
        return documentosList;
    }

    public void setDocumentosList(List<Documentos> documentosList) {
        this.documentosList = documentosList;
    }

    public TipoUser getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoUser idTipo) {
        this.idTipo = idTipo;
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
        hash += (idConsultor != null ? idConsultor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultor)) {
            return false;
        }
        Consultor other = (Consultor) object;
        if ((this.idConsultor == null && other.idConsultor != null) || (this.idConsultor != null && !this.idConsultor.equals(other.idConsultor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Consultor[ idConsultor=" + idConsultor + " ]";
    }
    
}
