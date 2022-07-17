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
    @NamedQuery(name = "Distribuidor.findAll", query = "SELECT d FROM Distribuidor d"),
    @NamedQuery(name = "Distribuidor.findByPkDistribuidor", query = "SELECT d FROM Distribuidor d WHERE d.pkDistribuidor = :pkDistribuidor"),
    @NamedQuery(name = "Distribuidor.findByEmail", query = "SELECT d FROM Distribuidor d WHERE d.email = :email"),
    @NamedQuery(name = "Distribuidor.findByTelefone", query = "SELECT d FROM Distribuidor d WHERE d.telefone = :telefone"),
    @NamedQuery(name = "Distribuidor.findByFax", query = "SELECT d FROM Distribuidor d WHERE d.fax = :fax")})
public class Distribuidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_distribuidor", nullable = false)
    private Integer pkDistribuidor;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String telefone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String fax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDistribuidor")
    private List<Contrato> contratoList;
    @JoinColumn(name = "fk_localizacao", referencedColumnName = "pk_localizacao", nullable = false)
    @ManyToOne(optional = false)
    private Localizacao fkLocalizacao;
    @JoinColumn(name = "fk_pessoa", referencedColumnName = "pk_pessoa", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa fkPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distribuidor")
    private List<Encomenda> encomendaList;

    public Distribuidor() {
    }

    public Distribuidor(Integer pkDistribuidor) {
        this.pkDistribuidor = pkDistribuidor;
    }

    public Distribuidor(Integer pkDistribuidor, String email, String telefone, String fax) {
        this.pkDistribuidor = pkDistribuidor;
        this.email = email;
        this.telefone = telefone;
        this.fax = fax;
    }

    public Integer getPkDistribuidor() {
        return pkDistribuidor;
    }

    public void setPkDistribuidor(Integer pkDistribuidor) {
        this.pkDistribuidor = pkDistribuidor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public Localizacao getFkLocalizacao() {
        return fkLocalizacao;
    }

    public void setFkLocalizacao(Localizacao fkLocalizacao) {
        this.fkLocalizacao = fkLocalizacao;
    }

    public Pessoa getFkPessoa() {
        return fkPessoa;
    }

    public void setFkPessoa(Pessoa fkPessoa) {
        this.fkPessoa = fkPessoa;
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
        hash += (pkDistribuidor != null ? pkDistribuidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distribuidor)) {
            return false;
        }
        Distribuidor other = (Distribuidor) object;
        if ((this.pkDistribuidor == null && other.pkDistribuidor != null) || (this.pkDistribuidor != null && !this.pkDistribuidor.equals(other.pkDistribuidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Distribuidor[ pkDistribuidor=" + pkDistribuidor + " ]";
    }
    
}
