/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.entities.Distribuidor;
import ejb.entities.Produto;
import ejb.facades.ContratoFacade;
import ejb.facades.DistribuidorFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author tio_hecro
 */
@Named(value = "findProdByDistBean")
@ViewScoped
public class FindProdByDistBean implements Serializable {

    private List<Distribuidor> distribuidors;
    private Integer pkDistribuidor;
    private List<Produto> produtos;

    @EJB
    private DistribuidorFacade distribuidorFacade;

    @EJB
    private ContratoFacade contratoFacade;

    @PostConstruct
    public void init() {
        pkDistribuidor = 1;
        distribuidors = distribuidorFacade.findAll();
        produtos = contratoFacade.findProdutosByDistribuidor(pkDistribuidor);
    }

    public FindProdByDistBean() {
    }

    public List<Produto> findProdutosByPkDistribuidor() {
        return this.contratoFacade.findProdutosByDistribuidor(pkDistribuidor);
    }

    public List<Distribuidor> getDistribuidors() {
        return distribuidors;
    }

    public void setDistribuidors(List<Distribuidor> distribuidors) {
        this.distribuidors = distribuidors;
    }

    public Integer getPkDistribuidor() {
        return pkDistribuidor;
    }

    public void setPkDistribuidor(Integer pkDistribuidor) {
        this.pkDistribuidor = pkDistribuidor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
