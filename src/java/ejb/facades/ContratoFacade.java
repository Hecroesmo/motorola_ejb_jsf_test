/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.facades;

import ejb.entities.Contrato;
import ejb.entities.Distribuidor;
import ejb.entities.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tio_hecro
 */
@Stateless
public class ContratoFacade extends AbstractFacade<Contrato> {

    @EJB
    ProdutoFacade produtoFacade;

    @PersistenceContext(unitName = "motorolaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratoFacade() {
        super(Contrato.class);
    }

    public List<Produto> findProdutosByDistribuidor(Integer pkDistribuidor) {

        List<Produto> produtoTotal = new ArrayList<>();
        List<Contrato> contratos = new ArrayList<>();

        //  retorna a lista de contratos de um dado distribuidor
        Query query = em.createQuery("SELECT c FROM Contrato c "
                + "WHERE c.fkDistribuidor.pkDistribuidor =:pkDistribuidor")
                .setParameter("pkDistribuidor", pkDistribuidor);

        //  Para cada contrato
        //  Pesquisa produtos de uma dada área de negocio
        //  e armazena na lista de produtos total
        for (Contrato contrato : contratos) {
            Integer pkAreaNegocio = contrato.getFkAreaNegocio().getPkAreaNegocio();
            List<Produto> produtos = produtoFacade.findProdutosByAreaNegocio(pkAreaNegocio);
            produtoTotal.addAll(produtos);
        }

        return produtoTotal;
    }

}
