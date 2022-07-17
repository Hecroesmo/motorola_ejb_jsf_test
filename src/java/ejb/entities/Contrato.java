/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tio_hecro
 */
@Entity
@Table(catalog = "motorola", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c"),
    @NamedQuery(name = "Contrato.findByPkContrato", query = "SELECT c FROM Contrato c WHERE c.pkContrato = :pkContrato"),
    @NamedQuery(name = "Contrato.findByEstadoContrato", query = "SELECT c FROM Contrato c WHERE c.estadoContrato = :estadoContrato"),
    @NamedQuery(name = "Contrato.findByDataCriacao", query = "SELECT c FROM Contrato c WHERE c.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "Contrato.findByDataCancelamento", query = "SELECT c FROM Contrato c WHERE c.dataCancelamento = :dataCancelamento")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_contrato", nullable = false)
    private Integer pkContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_contrato", nullable = false)
    private boolean estadoContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_criacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Column(name = "data_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dataCancelamento;
    @JoinColumn(name = "fk_area_negocio", referencedColumnName = "pk_area_negocio", nullable = false)
    @ManyToOne(optional = false)
    private AreaNegocio fkAreaNegocio;
    @JoinColumn(name = "fk_distribuidor ", referencedColumnName = "pk_distribuidor", nullable = false)
    @ManyToOne(optional = false)
    private Distribuidor fkDistribuidor;

    public Contrato() {
    }

    public Contrato(Integer pkContrato) {
        this.pkContrato = pkContrato;
    }

    public Contrato(Integer pkContrato, boolean estadoContrato, Date dataCriacao) {
        this.pkContrato = pkContrato;
        this.estadoContrato = estadoContrato;
        this.dataCriacao = dataCriacao;
    }

    public Integer getPkContrato() {
        return pkContrato;
    }

    public void setPkContrato(Integer pkContrato) {
        this.pkContrato = pkContrato;
    }

    public boolean getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(boolean estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public AreaNegocio getFkAreaNegocio() {
        return fkAreaNegocio;
    }

    public void setFkAreaNegocio(AreaNegocio fkAreaNegocio) {
        this.fkAreaNegocio = fkAreaNegocio;
    }

    public Distribuidor getFkDistribuidor() {
        return fkDistribuidor;
    }

    public void setFkDistribuidor(Distribuidor fkDistribuidor) {
        this.fkDistribuidor = fkDistribuidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkContrato != null ? pkContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.pkContrato == null && other.pkContrato != null) || (this.pkContrato != null && !this.pkContrato.equals(other.pkContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Contrato[ pkContrato=" + pkContrato + " ]";
    }
    
}
