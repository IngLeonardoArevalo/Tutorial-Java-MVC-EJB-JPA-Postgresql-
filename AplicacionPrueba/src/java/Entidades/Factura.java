/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leonardo Arevalo
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdfactura", query = "SELECT f FROM Factura f WHERE f.idfactura = :idfactura"),
    @NamedQuery(name = "Factura.findByFecfac", query = "SELECT f FROM Factura f WHERE f.fecfac = :fecfac"),
    @NamedQuery(name = "Factura.findByMontofactura", query = "SELECT f FROM Factura f WHERE f.montofactura = :montofactura"),
    @NamedQuery(name = "Factura.findByIva", query = "SELECT f FROM Factura f WHERE f.iva = :iva")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactura")
    private Integer idfactura;
    @Column(name = "fecfac")
    @Temporal(TemporalType.DATE)
    private Date fecfac;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "montofactura")
    private BigDecimal montofactura;
    @Column(name = "iva")
    private BigDecimal iva;
    @JoinColumn(name = "idmoneda", referencedColumnName = "idmoneda")
    @ManyToOne(optional = false)
    private Moneda idmoneda;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfactura")
    private List<Detfactura> detfacturaList;

    public Factura() {
    }

    public Factura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Factura(Integer idfactura, BigDecimal montofactura) {
        this.idfactura = idfactura;
        this.montofactura = montofactura;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Date getFecfac() {
        return fecfac;
    }

    public void setFecfac(Date fecfac) {
        this.fecfac = fecfac;
    }

    public BigDecimal getMontofactura() {
        return montofactura;
    }

    public void setMontofactura(BigDecimal montofactura) {
        this.montofactura = montofactura;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public Moneda getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(Moneda idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @XmlTransient
    public List<Detfactura> getDetfacturaList() {
        return detfacturaList;
    }

    public void setDetfacturaList(List<Detfactura> detfacturaList) {
        this.detfacturaList = detfacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Factura[ idfactura=" + idfactura + " ]";
    }
    
}
