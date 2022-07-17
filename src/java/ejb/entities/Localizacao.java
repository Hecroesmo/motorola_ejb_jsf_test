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
@Table(catalog = "motorola", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localizacao.findAll", query = "SELECT l FROM Localizacao l"),
    @NamedQuery(name = "Localizacao.findByPkLocalizacao", query = "SELECT l FROM Localizacao l WHERE l.pkLocalizacao = :pkLocalizacao"),
    @NamedQuery(name = "Localizacao.findByDesignacao", query = "SELECT l FROM Localizacao l WHERE l.designacao = :designacao"),
    @NamedQuery(name = "Localizacao.findByFkLocalizacao", query = "SELECT l FROM Localizacao l WHERE l.fkLocalizacao = :fkLocalizacao")})
public class Localizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_localizacao", nullable = false)
    private Integer pkLocalizacao;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String designacao;
    @Column(name = "fk_localizacao")
    private Integer fkLocalizacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkLocalizacao")
    private List<Distribuidor> distribuidorList;

    public Localizacao() {
    }

    public Localizacao(Integer pkLocalizacao) {
        this.pkLocalizacao = pkLocalizacao;
    }

    public Integer getPkLocalizacao() {
        return pkLocalizacao;
    }

    public void setPkLocalizacao(Integer pkLocalizacao) {
        this.pkLocalizacao = pkLocalizacao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public Integer getFkLocalizacao() {
        return fkLocalizacao;
    }

    public void setFkLocalizacao(Integer fkLocalizacao) {
        this.fkLocalizacao = fkLocalizacao;
    }

    @XmlTransient
    public List<Distribuidor> getDistribuidorList() {
        return distribuidorList;
    }

    public void setDistribuidorList(List<Distribuidor> distribuidorList) {
        this.distribuidorList = distribuidorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkLocalizacao != null ? pkLocalizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizacao)) {
            return false;
        }
        Localizacao other = (Localizacao) object;
        if ((this.pkLocalizacao == null && other.pkLocalizacao != null) || (this.pkLocalizacao != null && !this.pkLocalizacao.equals(other.pkLocalizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Localizacao[ pkLocalizacao=" + pkLocalizacao + " ]";
    }
    
}
