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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tio_hecro
 */
@Embeddable
public class EncomendaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_produto", nullable = false)
    private int fkProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_distribuidor", nullable = false)
    private int fkDistribuidor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    public EncomendaPK() {
    }

    public EncomendaPK(int fkProduto, int fkDistribuidor, Date dataHora) {
        this.fkProduto = fkProduto;
        this.fkDistribuidor = fkDistribuidor;
        this.dataHora = dataHora;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

    public int getFkDistribuidor() {
        return fkDistribuidor;
    }

    public void setFkDistribuidor(int fkDistribuidor) {
        this.fkDistribuidor = fkDistribuidor;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkProduto;
        hash += (int) fkDistribuidor;
        hash += (dataHora != null ? dataHora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncomendaPK)) {
            return false;
        }
        EncomendaPK other = (EncomendaPK) object;
        if (this.fkProduto != other.fkProduto) {
            return false;
        }
        if (this.fkDistribuidor != other.fkDistribuidor) {
            return false;
        }
        if ((this.dataHora == null && other.dataHora != null) || (this.dataHora != null && !this.dataHora.equals(other.dataHora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.EncomendaPK[ fkProduto=" + fkProduto + ", fkDistribuidor=" + fkDistribuidor + ", dataHora=" + dataHora + " ]";
    }
    
}
