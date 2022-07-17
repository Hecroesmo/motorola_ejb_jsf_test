/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.facades;

import ejb.entities.AreaNegocio;
import ejb.entities.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tio_hecro
 */
@Stateless
public class ProdutoFacade extends AbstractFacade<Produto> {

    @PersistenceContext(unitName = "motorolaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutoFacade() {
        super(Produto.class);
    }

    public List<Produto> findProdutosByAreaNegocio(Integer pkAreaNegocio) {
        Query query = em.createQuery("SELECT p FROM Produto p "
                + "WHERE p.fkAreaNegocio.pkAreaNegocio =:pkAreaNegocio")
                .setParameter("pkAreaNegocio", pkAreaNegocio);
        return query.getResultList();
    }
}
