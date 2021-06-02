/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stalyn
 */
@Entity
@Table(name = "pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findByIdPago", query = "SELECT p FROM Pago p WHERE p.idPago = :idPago"),
    @NamedQuery(name = "Pago.findByFechaPago", query = "SELECT p FROM Pago p WHERE p.fechaPago = :fechaPago"),
    @NamedQuery(name = "Pago.findByTotalPago", query = "SELECT p FROM Pago p WHERE p.totalPago = :totalPago"),
    @NamedQuery(name = "Pago.findByTipoPago", query = "SELECT p FROM Pago p WHERE p.tipoPago = :tipoPago"),
    @NamedQuery(name = "Pago.findByIvaPago", query = "SELECT p FROM Pago p WHERE p.ivaPago = :ivaPago"),
     @NamedQuery(name = "Pago.findByUsuario", query = "SELECT p FROM Pago p WHERE p.idUser.idUsuario = :idUsuario"),
    @NamedQuery(name = "Pago.findBySubtotalPago", query = "SELECT p FROM Pago p WHERE p.subtotalPago = :subtotalPago")})
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_pago")
    private Double totalPago;
    @Size(max = 255)
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Column(name = "iva_pago")
    private Double ivaPago;
    @Column(name = "subtotal_pago")
    private Double subtotalPago;
    @JoinColumn(name = "id_user", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUser;
    @JoinColumn(name = "id_tarjeta", referencedColumnName = "id_tarjeta")
    @ManyToOne
    private Tarjeta idTarjeta;
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    @ManyToOne
    private Cuenta idCuenta;
    @JoinColumn(name = "id_cheque", referencedColumnName = "numero_cheque")
    @ManyToOne
    private Cheque idCheque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPago")
    private List<Detalle> detalleList;

    public Pago() {
    }

    public Pago(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(Double totalPago) {
        this.totalPago = totalPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Double getIvaPago() {
        return ivaPago;
    }

    public void setIvaPago(Double ivaPago) {
        this.ivaPago = ivaPago;
    }

    public Double getSubtotalPago() {
        return subtotalPago;
    }

    public void setSubtotalPago(Double subtotalPago) {
        this.subtotalPago = subtotalPago;
    }

    public Usuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Usuario idUser) {
        this.idUser = idUser;
    }

    public Tarjeta getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Tarjeta idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cheque getIdCheque() {
        return idCheque;
    }

    public void setIdCheque(Cheque idCheque) {
        this.idCheque = idCheque;
    }

    @XmlTransient
    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Pago[ idPago=" + idPago + " ]";
    }
    
}
