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
@Table(name = "tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t"),
    @NamedQuery(name = "Tarjeta.findByIdTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.idTarjeta = :idTarjeta"),
    @NamedQuery(name = "Tarjeta.findByCoodigoTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.coodigoTarjeta = :coodigoTarjeta"),
    @NamedQuery(name = "Tarjeta.findByDecripcionTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.decripcionTarjeta = :decripcionTarjeta"),
    @NamedQuery(name = "Tarjeta.findByCodigoSeguridad", query = "SELECT t FROM Tarjeta t WHERE t.codigoSeguridad = :codigoSeguridad"),
     @NamedQuery(name = "Tarjeta.findByalltarjeta", query = "SELECT t FROM Tarjeta t WHERE t.coodigoTarjeta=:coodigoTarjeta and t.decripcionTarjeta=:descripcionTarjeta and t.codigoSeguridad = :codigoSeguridad and t.fechaVencer=:fechaVencer"),
    @NamedQuery(name = "Tarjeta.findByFechaVencer", query = "SELECT t FROM Tarjeta t WHERE t.fechaVencer = :fechaVencer")})
public class Tarjeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarjeta")
    private Integer idTarjeta;
    @Size(max = 255)
    @Column(name = "coodigo_tarjeta")
    private String coodigoTarjeta;
    @Size(max = 255)
    @Column(name = "decripcion_tarjeta")
    private String decripcionTarjeta;
    @Size(max = 255)
    @Column(name = "codigo_seguridad")
    private String codigoSeguridad;
    @Size(max = 255)
    @Column(name = "fecha_vencer")
    private String fechaVencer;
    @OneToMany(mappedBy = "idTarjeta")
    private List<Pago> pagoList;
    @JoinColumn(name = "id_user", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUser;

    public Tarjeta() {
    }

    public Tarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getCoodigoTarjeta() {
        return coodigoTarjeta;
    }

    public void setCoodigoTarjeta(String coodigoTarjeta) {
        this.coodigoTarjeta = coodigoTarjeta;
    }

    public String getDecripcionTarjeta() {
        return decripcionTarjeta;
    }

    public void setDecripcionTarjeta(String decripcionTarjeta) {
        this.decripcionTarjeta = decripcionTarjeta;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getFechaVencer() {
        return fechaVencer;
    }

    public void setFechaVencer(String fechaVencer) {
        this.fechaVencer = fechaVencer;
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
        hash += (idTarjeta != null ? idTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.idTarjeta == null && other.idTarjeta != null) || (this.idTarjeta != null && !this.idTarjeta.equals(other.idTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Tarjeta[ idTarjeta=" + idTarjeta + " ]";
    }
    
}
