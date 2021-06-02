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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByRucEmpresa", query = "SELECT u FROM Usuario u WHERE u.rucEmpresa = :rucEmpresa"),
    @NamedQuery(name = "Usuario.findByNombreEmpresa", query = "SELECT u FROM Usuario u WHERE u.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "Usuario.findByTelefonoEmpresa", query = "SELECT u FROM Usuario u WHERE u.telefonoEmpresa = :telefonoEmpresa"),
    @NamedQuery(name = "Usuario.findByCorreoEmpresa", query = "SELECT u FROM Usuario u WHERE u.correoEmpresa = :correoEmpresa"),
    @NamedQuery(name = "Usuario.findByUbicacion", query = "SELECT u FROM Usuario u WHERE u.ubicacion = :ubicacion"),
    @NamedQuery(name = "Usuario.findByCiUser", query = "SELECT u FROM Usuario u WHERE u.ciUser = :ciUser"),
    @NamedQuery(name = "Usuario.findByNombreUser", query = "SELECT u FROM Usuario u WHERE u.nombreUser = :nombreUser"),
    @NamedQuery(name = "Usuario.findByApellidoUser", query = "SELECT u FROM Usuario u WHERE u.apellidoUser = :apellidoUser"),
    @NamedQuery(name = "Usuario.findByCorreoUser", query = "SELECT u FROM Usuario u WHERE u.correoUser = :correoUser"),
    @NamedQuery(name = "Usuario.findByTelefonoUser", query = "SELECT u FROM Usuario u WHERE u.telefonoUser = :telefonoUser"),
    @NamedQuery(name = "Usuario.findByUsuarioUser", query = "SELECT u FROM Usuario u WHERE u.usuarioUser = :usuarioUser"),
    @NamedQuery(name = "Usuario.validarUsuario", query = "SELECT u FROM Usuario u WHERE u.usuarioUser = :usuarioUser and u.contraseniaUser = :contraseniaUser"),
    @NamedQuery(name = "Usuario.primerCliente", query = "SELECT u FROM Usuario u WHERE u.idUsuario = 1"),
    @NamedQuery(name = "Usuario.segundoCliente", query = "SELECT u FROM Usuario u WHERE u.idUsuario = 2"),
    @NamedQuery(name = "Usuario.tercerCliente", query = "SELECT u FROM Usuario u WHERE u.idUsuario = 3"),
    @NamedQuery(name = "Usuario.cuartoCliente", query = "SELECT u FROM Usuario u WHERE u.idUsuario = 4"),
    @NamedQuery(name = "Usuario.findByContraseniaUser", query = "SELECT u FROM Usuario u WHERE u.contraseniaUser = :contraseniaUser")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "ruc_empresa")
    private Integer rucEmpresa;
    @Size(max = 255)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Size(max = 255)
    @Column(name = "telefono_empresa")
    private String telefonoEmpresa;
    @Size(max = 255)
    @Column(name = "correo_empresa")
    private String correoEmpresa;
    @Size(max = 255)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(max = 255)
    @Column(name = "ci_user")
    private String ciUser;
    @Size(max = 255)
    @Column(name = "nombre_user")
    private String nombreUser;
    @Size(max = 255)
    @Column(name = "apellido_user")
    private String apellidoUser;
    @Size(max = 255)
    @Column(name = "correo_user")
    private String correoUser;
    @Size(max = 255)
    @Column(name = "telefono_user")
    private String telefonoUser;
    @Size(max = 255)
    @Column(name = "usuario_user")
    private String usuarioUser;
    @Size(max = 255)
    @Column(name = "contrasenia_user")
    private String contraseniaUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<Pago> pagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<Documentos> documentosList;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne
    private TipoUser idTipo;
    @OneToMany(mappedBy = "idUsuario")
    private List<SolicitudCita> solicitudCitaList;
    @OneToMany(mappedBy = "idUser")
    private List<Tarjeta> tarjetaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<Cuenta> cuentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<Citas> citasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Cheque> chequeList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getRucEmpresa() {
        return rucEmpresa;
    }

    public void setRucEmpresa(Integer rucEmpresa) {
        this.rucEmpresa = rucEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCiUser() {
        return ciUser;
    }

    public void setCiUser(String ciUser) {
        this.ciUser = ciUser;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getApellidoUser() {
        return apellidoUser;
    }

    public void setApellidoUser(String apellidoUser) {
        this.apellidoUser = apellidoUser;
    }

    public String getCorreoUser() {
        return correoUser;
    }

    public void setCorreoUser(String correoUser) {
        this.correoUser = correoUser;
    }

    public String getTelefonoUser() {
        return telefonoUser;
    }

    public void setTelefonoUser(String telefonoUser) {
        this.telefonoUser = telefonoUser;
    }

    public String getUsuarioUser() {
        return usuarioUser;
    }

    public void setUsuarioUser(String usuarioUser) {
        this.usuarioUser = usuarioUser;
    }

    public String getContraseniaUser() {
        return contraseniaUser;
    }

    public void setContraseniaUser(String contraseniaUser) {
        this.contraseniaUser = contraseniaUser;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
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
    public List<SolicitudCita> getSolicitudCitaList() {
        return solicitudCitaList;
    }

    public void setSolicitudCitaList(List<SolicitudCita> solicitudCitaList) {
        this.solicitudCitaList = solicitudCitaList;
    }

    @XmlTransient
    public List<Tarjeta> getTarjetaList() {
        return tarjetaList;
    }

    public void setTarjetaList(List<Tarjeta> tarjetaList) {
        this.tarjetaList = tarjetaList;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    @XmlTransient
    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    @XmlTransient
    public List<Cheque> getChequeList() {
        return chequeList;
    }

    public void setChequeList(List<Cheque> chequeList) {
        this.chequeList = chequeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
