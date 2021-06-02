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
@Table(name = "tipo_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUser.findAll", query = "SELECT t FROM TipoUser t"),
    @NamedQuery(name = "TipoUser.findByIdTipo", query = "SELECT t FROM TipoUser t WHERE t.idTipo = :idTipo"),
    @NamedQuery(name = "TipoUser.findByNombreTipo", query = "SELECT t FROM TipoUser t WHERE t.nombreTipo = :nombreTipo"),
    @NamedQuery(name = "TipoUser.findByDescripcionTipo", query = "SELECT t FROM TipoUser t WHERE t.descripcionTipo = :descripcionTipo")})
public class TipoUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Size(max = 255)
    @Column(name = "nombre_tipo")
    private String nombreTipo;
    @Size(max = 255)
    @Column(name = "descripcion_tipo")
    private String descripcionTipo;
    @OneToMany(mappedBy = "idTipo")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private List<Consultor> consultorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private List<Administrador> administradorList;

    public TipoUser() {
    }

    public TipoUser(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Consultor> getConsultorList() {
        return consultorList;
    }

    public void setConsultorList(List<Consultor> consultorList) {
        this.consultorList = consultorList;
    }

    @XmlTransient
    public List<Administrador> getAdministradorList() {
        return administradorList;
    }

    public void setAdministradorList(List<Administrador> administradorList) {
        this.administradorList = administradorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUser)) {
            return false;
        }
        TipoUser other = (TipoUser) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.TipoUser[ idTipo=" + idTipo + " ]";
    }
    
}
