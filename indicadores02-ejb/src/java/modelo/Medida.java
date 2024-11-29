/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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
 * @author felip
 */
@Entity
@Table(name = "medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medida.findAll", query = "SELECT m FROM Medida m"),
    @NamedQuery(name = "Medida.findByIdMedida", query = "SELECT m FROM Medida m WHERE m.idMedida = :idMedida"),
    @NamedQuery(name = "Medida.findByPeso", query = "SELECT m FROM Medida m WHERE m.peso = :peso"),
    @NamedQuery(name = "Medida.findByCintura", query = "SELECT m FROM Medida m WHERE m.cintura = :cintura"),
    @NamedQuery(name = "Medida.findByFecha", query = "SELECT m FROM Medida m WHERE m.fecha = :fecha")})
public class Medida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medida")
    private Integer idMedida;
    @Column(name = "peso")
    private Integer peso;
    @Column(name = "cintura")
    private Integer cintura;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPersona;

    public Medida() {
    }

    public Medida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getCintura() {
        return cintura;
    }

    public void setCintura(Integer cintura) {
        this.cintura = cintura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedida != null ? idMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medida)) {
            return false;
        }
        Medida other = (Medida) object;
        if ((this.idMedida == null && other.idMedida != null) || (this.idMedida != null && !this.idMedida.equals(other.idMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Medida[ idMedida=" + idMedida + " ]";
    }
    
}
