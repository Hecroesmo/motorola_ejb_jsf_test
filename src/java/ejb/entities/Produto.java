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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tio_hecro
 */
@Entity
@Table(catalog = "motorola", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByPkProduto", query = "SELECT p FROM Produto p WHERE p.pkProduto = :pkProduto"),
    @NamedQuery(name = "Produto.findByPre\u00e7o", query = "SELECT p FROM Produto p WHERE p.pre\u00e7o = :pre\u00e7o"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_produto", nullable = false)
    private Integer pkProduto;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double preço;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String nome;
    @JoinColumn(name = "fk_area_negocio", referencedColumnName = "pk_area_negocio", nullable = false)
    @ManyToOne(optional = false)
    private AreaNegocio fkAreaNegocio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<Encomenda> encomendaList;

    public Produto() {
    }

    public Produto(Integer pkProduto) {
        this.pkProduto = pkProduto;
    }

    public Produto(Integer pkProduto, double preço, String nome) {
        this.pkProduto = pkProduto;
        this.preço = preço;
        this.nome = nome;
    }

    public Integer getPkProduto() {
        return pkProduto;
    }

    public void setPkProduto(Integer pkProduto) {
        this.pkProduto = pkProduto;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AreaNegocio getFkAreaNegocio() {
        return fkAreaNegocio;
    }

    public void setFkAreaNegocio(AreaNegocio fkAreaNegocio) {
        this.fkAreaNegocio = fkAreaNegocio;
    }

    @XmlTransient
    public List<Encomenda> getEncomendaList() {
        return encomendaList;
    }

    public void setEncomendaList(List<Encomenda> encomendaList) {
        this.encomendaList = encomendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProduto != null ? pkProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.pkProduto == null && other.pkProduto != null) || (this.pkProduto != null && !this.pkProduto.equals(other.pkProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Produto[ pkProduto=" + pkProduto + " ]";
    }
    
}
