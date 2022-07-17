/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.facades;

import ejb.entities.AreaNegocio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tio_hecro
 */
@Stateless
public class AreaNegocioFacade extends AbstractFacade<AreaNegocio> {

    @PersistenceContext(unitName = "motorolaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreaNegocioFacade() {
        super(AreaNegocio.class);
    }
    
}
