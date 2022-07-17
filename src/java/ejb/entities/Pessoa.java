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
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByPkPessoa", query = "SELECT p FROM Pessoa p WHERE p.pkPessoa = :pkPessoa"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_pessoa", nullable = false)
    private Integer pkPessoa;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nome;
    @JoinColumn(name = "fk_cargo", referencedColumnName = "pk_cargo", nullable = false)
    @ManyToOne(optional = false)
    private Cargo fkCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPessoa")
    private List<Distribuidor> distribuidorList;

    public Pessoa() {
    }

    public Pessoa(Integer pkPessoa) {
        this.pkPessoa = pkPessoa;
    }

    public Integer getPkPessoa() {
        return pkPessoa;
    }

    public void setPkPessoa(Integer pkPessoa) {
        this.pkPessoa = pkPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getFkCargo() {
        return fkCargo;
    }

    public void setFkCargo(Cargo fkCargo) {
        this.fkCargo = fkCargo;
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
        hash += (pkPessoa != null ? pkPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.pkPessoa == null && other.pkPessoa != null) || (this.pkPessoa != null && !this.pkPessoa.equals(other.pkPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Pessoa[ pkPessoa=" + pkPessoa + " ]";
    }
    
}
