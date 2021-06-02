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
@Table(name = "cheque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cheque.findAll", query = "SELECT c FROM Cheque c"),
    @NamedQuery(name = "Cheque.findByNumeroCheque", query = "SELECT c FROM Cheque c WHERE c.numeroCheque = :numeroCheque"),
    @NamedQuery(name = "Cheque.findByCuentaCliente", query = "SELECT c FROM Cheque c WHERE c.cuentaCliente = :cuentaCliente"),
    @NamedQuery(name = "Cheque.findByNombreBanco", query = "SELECT c FROM Cheque c WHERE c.nombreBanco = :nombreBanco"),
    @NamedQuery(name = "Cheque.findByPagado", query = "SELECT c FROM Cheque c WHERE c.pagado = :pagado"),
    @NamedQuery(name = "Cheque.findByIdCheque", query = "SELECT c FROM Cheque c WHERE c.idCheque = :idCheque"),
    @NamedQuery(name = "Cheque.findByNombreTitular", query = "SELECT c FROM Cheque c WHERE c.nombreTitular = :nombreTitular"),
    @NamedQuery(name = "Cheque.findByTipoCheque", query = "SELECT c FROM Cheque c WHERE c.tipoCheque = :tipoCheque"),
    @NamedQuery(name = "Cheque.findByNumeroDocumento", query = "SELECT c FROM Cheque c WHERE c.numeroDocumento = :numeroDocumento")})
public class Cheque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_cheque")
    private Integer numeroCheque;
    @Size(max = 255)
    @Column(name = "cuenta_cliente")
    private String cuentaCliente;
    @Size(max = 255)
    @Column(name = "nombre_banco")
    private String nombreBanco;
    @Column(name = "pagado")
    private Boolean pagado;
    @Size(max = 255)
    @Column(name = "id_cheque")
    private String idCheque;
    @Size(max = 255)
    @Column(name = "nombre_titular")
    private String nombreTitular;
    @Size(max = 255)
    @Column(name = "tipo_cheque")
    private String tipoCheque;
    @Size(max = 255)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @OneToMany(mappedBy = "idCheque")
    private List<Pago> pagoList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Cheque() {
    }

    public Cheque(Integer numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public Integer getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(Integer numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public String getCuentaCliente() {
        return cuentaCliente;
    }

    public void setCuentaCliente(String cuentaCliente) {
        this.cuentaCliente = cuentaCliente;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public String getIdCheque() {
        return idCheque;
    }

    public void setIdCheque(String idCheque) {
        this.idCheque = idCheque;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getTipoCheque() {
        return tipoCheque;
    }

    public void setTipoCheque(String tipoCheque) {
        this.tipoCheque = tipoCheque;
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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCheque != null ? numeroCheque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cheque)) {
            return false;
        }
        Cheque other = (Cheque) object;
        if ((this.numeroCheque == null && other.numeroCheque != null) || (this.numeroCheque != null && !this.numeroCheque.equals(other.numeroCheque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Cheque[ numeroCheque=" + numeroCheque + " ]";
    }
    
}
