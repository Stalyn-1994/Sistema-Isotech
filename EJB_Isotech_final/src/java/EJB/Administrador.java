/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stalyn
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.idAdministrador = :idAdministrador"),
    @NamedQuery(name = "Administrador.findByCiAdministrador", query = "SELECT a FROM Administrador a WHERE a.ciAdministrador = :ciAdministrador"),
    @NamedQuery(name = "Administrador.findByNombreAdministrador", query = "SELECT a FROM Administrador a WHERE a.nombreAdministrador = :nombreAdministrador"),
    @NamedQuery(name = "Administrador.findByApellidoAdministrador", query = "SELECT a FROM Administrador a WHERE a.apellidoAdministrador = :apellidoAdministrador"),
    @NamedQuery(name = "Administrador.findByUsuarioAdministrador", query = "SELECT a FROM Administrador a WHERE a.usuarioAdministrador = :usuarioAdministrador"),
     @NamedQuery(name = "Administrador.validarAdministrador", query = "SELECT a FROM Administrador a WHERE a.usuarioAdministrador = :usuarioAdministrador and a.contraseniaAdministrador = :contraseniaAdministrador"),
    @NamedQuery(name = "Administrador.findByContraseniaAdministrador", query = "SELECT a FROM Administrador a WHERE a.contraseniaAdministrador = :contraseniaAdministrador")})
public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_administrador")
    private Integer idAdministrador;
    @Column(name = "ci_administrador")
    private Integer ciAdministrador;
    @Size(max = 255)
    @Column(name = "nombre_administrador")
    private String nombreAdministrador;
    @Size(max = 255)
    @Column(name = "apellido_administrador")
    private String apellidoAdministrador;
    @Size(max = 255)
    @Column(name = "usuario_administrador")
    private String usuarioAdministrador;
    @Size(max = 255)
    @Column(name = "contrasenia_administrador")
    private String contraseniaAdministrador;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private TipoUser idTipo;

    public Administrador() {
    }

    public Administrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Integer getCiAdministrador() {
        return ciAdministrador;
    }

    public void setCiAdministrador(Integer ciAdministrador) {
        this.ciAdministrador = ciAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getApellidoAdministrador() {
        return apellidoAdministrador;
    }

    public void setApellidoAdministrador(String apellidoAdministrador) {
        this.apellidoAdministrador = apellidoAdministrador;
    }

    public String getUsuarioAdministrador() {
        return usuarioAdministrador;
    }

    public void setUsuarioAdministrador(String usuarioAdministrador) {
        this.usuarioAdministrador = usuarioAdministrador;
    }

    public String getContraseniaAdministrador() {
        return contraseniaAdministrador;
    }

    public void setContraseniaAdministrador(String contraseniaAdministrador) {
        this.contraseniaAdministrador = contraseniaAdministrador;
    }

    public TipoUser getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoUser idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministrador != null ? idAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idAdministrador == null && other.idAdministrador != null) || (this.idAdministrador != null && !this.idAdministrador.equals(other.idAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Administrador[ idAdministrador=" + idAdministrador + " ]";
    }
    
}
