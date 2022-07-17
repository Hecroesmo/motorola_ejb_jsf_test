/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tio_hecro
 */
@Entity
@Table(name = "area_negocio", catalog = "motorola", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaNegocio.findAll", query = "SELECT a FROM AreaNegocio a"),
    @NamedQuery(name = "AreaNegocio.findByPkAreaNegocio", query = "SELECT a FROM AreaNegocio a WHERE a.pkAreaNegocio = :pkAreaNegocio"),
    @NamedQuery(name = "AreaNegocio.findByDesignacao", query = "SELECT a FROM AreaNegocio a WHERE a.designacao = :designacao")})
public class AreaNegocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_area_negocio", nullable = false)
    private Integer pkAreaNegocio;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAreaNegocio")
    private List<Produto> produtoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAreaNegocio")
    private List<Contrato> contratoList;

    public AreaNegocio() {
    }

    public AreaNegocio(Integer pkAreaNegocio) {
        this.pkAreaNegocio = pkAreaNegocio;
    }

    public Integer getPkAreaNegocio() {
        return pkAreaNegocio;
    }

    public void setPkAreaNegocio(Integer pkAreaNegocio) {
        this.pkAreaNegocio = pkAreaNegocio;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkAreaNegocio != null ? pkAreaNegocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaNegocio)) {
            return false;
        }
        AreaNegocio other = (AreaNegocio) object;
        if ((this.pkAreaNegocio == null && other.pkAreaNegocio != null) || (this.pkAreaNegocio != null && !this.pkAreaNegocio.equals(other.pkAreaNegocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.AreaNegocio[ pkAreaNegocio=" + pkAreaNegocio + " ]";
    }
    
}
