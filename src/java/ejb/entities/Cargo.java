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
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByPkCargo", query = "SELECT c FROM Cargo c WHERE c.pkCargo = :pkCargo"),
    @NamedQuery(name = "Cargo.findByTitulo", query = "SELECT c FROM Cargo c WHERE c.titulo = :titulo")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cargo", nullable = false)
    private Integer pkCargo;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String titulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCargo")
    private List<Pessoa> pessoaList;

    public Cargo() {
    }

    public Cargo(Integer pkCargo) {
        this.pkCargo = pkCargo;
    }

    public Integer getPkCargo() {
        return pkCargo;
    }

    public void setPkCargo(Integer pkCargo) {
        this.pkCargo = pkCargo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCargo != null ? pkCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.pkCargo == null && other.pkCargo != null) || (this.pkCargo != null && !this.pkCargo.equals(other.pkCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Cargo[ pkCargo=" + pkCargo + " ]";
    }
    
}
