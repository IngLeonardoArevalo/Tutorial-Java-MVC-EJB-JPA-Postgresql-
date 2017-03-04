/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo Arevalo
 */
@Entity
@Table(name = "detfactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detfactura.findAll", query = "SELECT d FROM Detfactura d"),
    @NamedQuery(name = "Detfactura.findByIddetalle", query = "SELECT d FROM Detfactura d WHERE d.iddetalle = :iddetalle"),
    @NamedQuery(name = "Detfactura.findByMonto", query = "SELECT d FROM Detfactura d WHERE d.monto = :monto")})
public class Detfactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle")
    private Integer iddetalle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @JoinColumn(name = "idfactura", referencedColumnName = "idfactura")
    @ManyToOne(optional = false)
    private Factura idfactura;
    @JoinColumn(name = "idarticulo", referencedColumnName = "idarticulo")
    @ManyToOne(optional = false)
    private Articulos idarticulo;

    public Detfactura() {
    }

    public Detfactura(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Integer getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Factura getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Factura idfactura) {
        this.idfactura = idfactura;
    }

    public Articulos getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Articulos idarticulo) {
        this.idarticulo = idarticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalle != null ? iddetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detfactura)) {
            return false;
        }
        Detfactura other = (Detfactura) object;
        if ((this.iddetalle == null && other.iddetalle != null) || (this.iddetalle != null && !this.iddetalle.equals(other.iddetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Detfactura[ iddetalle=" + iddetalle + " ]";
    }
    
}
