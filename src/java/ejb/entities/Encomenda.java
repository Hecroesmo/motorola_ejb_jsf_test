/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tio_hecro
 */
@Entity
@Table(catalog = "motorola", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encomenda.findAll", query = "SELECT e FROM Encomenda e"),
    @NamedQuery(name = "Encomenda.findByFkProduto", query = "SELECT e FROM Encomenda e WHERE e.encomendaPK.fkProduto = :fkProduto"),
    @NamedQuery(name = "Encomenda.findByFkDistribuidor", query = "SELECT e FROM Encomenda e WHERE e.encomendaPK.fkDistribuidor = :fkDistribuidor"),
    @NamedQuery(name = "Encomenda.findByDataHora", query = "SELECT e FROM Encomenda e WHERE e.encomendaPK.dataHora = :dataHora")})
public class Encomenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EncomendaPK encomendaPK;
    @JoinColumn(name = "fk_distribuidor", referencedColumnName = "pk_distribuidor", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Distribuidor distribuidor;
    @JoinColumn(name = "fk_produto", referencedColumnName = "pk_produto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public Encomenda() {
    }

    public Encomenda(EncomendaPK encomendaPK) {
        this.encomendaPK = encomendaPK;
    }

    public Encomenda(int fkProduto, int fkDistribuidor, Date dataHora) {
        this.encomendaPK = new EncomendaPK(fkProduto, fkDistribuidor, dataHora);
    }

    public EncomendaPK getEncomendaPK() {
        return encomendaPK;
    }

    public void setEncomendaPK(EncomendaPK encomendaPK) {
        this.encomendaPK = encomendaPK;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (encomendaPK != null ? encomendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encomenda)) {
            return false;
        }
        Encomenda other = (Encomenda) object;
        if ((this.encomendaPK == null && other.encomendaPK != null) || (this.encomendaPK != null && !this.encomendaPK.equals(other.encomendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Encomenda[ encomendaPK=" + encomendaPK + " ]";
    }
    
}
