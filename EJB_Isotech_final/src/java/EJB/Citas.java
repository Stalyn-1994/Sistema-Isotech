/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stalyn
 */
@Entity
@Table(name = "citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c"),
    @NamedQuery(name = "Citas.findByIdCitas", query = "SELECT c FROM Citas c WHERE c.idCitas = :idCitas"),
    @NamedQuery(name = "Citas.citaCliente1", query = "SELECT c FROM Citas c WHERE c.idCitas = 1"),
    @NamedQuery(name = "Citas.findByFechaCitas", query = "SELECT c FROM Citas c WHERE c.fechaCitas = :fechaCitas")})
public class Citas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_citas")
    private Integer idCitas;
    @Column(name = "fecha_citas")
    @Temporal(TemporalType.DATE)
    private Date fechaCitas;
    @JoinColumn(name = "id_user", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUser;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoCita idEstado;
    @JoinColumn(name = "id_consultor", referencedColumnName = "id_consultor")
    @ManyToOne(optional = false)
    private Consultor idConsultor;

    public Citas() {
    }

    public Citas(Integer idCitas) {
        this.idCitas = idCitas;
    }

    public Integer getIdCitas() {
        return idCitas;
    }

    public void setIdCitas(Integer idCitas) {
        this.idCitas = idCitas;
    }

    public Date getFechaCitas() {
        return fechaCitas;
    }

    public void setFechaCitas(Date fechaCitas) {
        this.fechaCitas = fechaCitas;
    }

    public Usuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Usuario idUser) {
        this.idUser = idUser;
    }

    public EstadoCita getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoCita idEstado) {
        this.idEstado = idEstado;
    }

    public Consultor getIdConsultor() {
        return idConsultor;
    }

    public void setIdConsultor(Consultor idConsultor) {
        this.idConsultor = idConsultor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCitas != null ? idCitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.idCitas == null && other.idCitas != null) || (this.idCitas != null && !this.idCitas.equals(other.idCitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Citas[ idCitas=" + idCitas + " ]";
    }
    
}
