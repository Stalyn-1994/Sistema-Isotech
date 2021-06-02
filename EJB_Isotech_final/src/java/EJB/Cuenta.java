/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByIdCuenta", query = "SELECT c FROM Cuenta c WHERE c.idCuenta = :idCuenta"),
    @NamedQuery(name = "Cuenta.findByNumeroCuenta", query = "SELECT c FROM Cuenta c WHERE c.numeroCuenta = :numeroCuenta"),
    @NamedQuery(name = "Cuenta.findByDescripcionCuenta", query = "SELECT c FROM Cuenta c WHERE c.descripcionCuenta = :descripcionCuenta"),
    @NamedQuery(name = "Cuenta.findByMontoCuenta", query = "SELECT c FROM Cuenta c WHERE c.montoCuenta = :montoCuenta"),
    @NamedQuery(name = "Cuenta.findByNombreBancos", query = "SELECT c FROM Cuenta c WHERE c.nombreBancos = :nombreBancos"),
    @NamedQuery(name = "Cuenta.findByTipoCuenta", query = "SELECT c FROM Cuenta c WHERE c.tipoCuenta = :tipoCuenta"),
    @NamedQuery(name = "Cuenta.findByNumeroDocumento", query = "SELECT c FROM Cuenta c WHERE c.numeroDocumento = :numeroDocumento")})
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta")
    private Integer idCuenta;
    @Size(max = 255)
    @Column(name = "numero_cuenta")
    private String numeroCuenta;
    @Size(max = 255)
    @Column(name = "descripcion_cuenta")
    private String descripcionCuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_cuenta")
    private Double montoCuenta;
    @Size(max = 255)
    @Column(name = "nombre_bancos")
    private String nombreBancos;
    @Size(max = 255)
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @Size(max = 255)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @OneToMany(mappedBy = "idCuenta")
    private List<Pago> pagoList;
    @JoinColumn(name = "id_user", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUser;

    public Cuenta() {
    }

    public Cuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getDescripcionCuenta() {
        return descripcionCuenta;
    }

    public void setDescripcionCuenta(String descripcionCuenta) {
        this.descripcionCuenta = descripcionCuenta;
    }

    public Double getMontoCuenta() {
        return montoCuenta;
    }

    public void setMontoCuenta(Double montoCuenta) {
        this.montoCuenta = montoCuenta;
    }

    public String getNombreBancos() {
        return nombreBancos;
    }

    public void setNombreBancos(String nombreBancos) {
        this.nombreBancos = nombreBancos;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    public Usuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Usuario idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Cuenta[ idCuenta=" + idCuenta + " ]";
    }
    
}
