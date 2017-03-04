/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EntidadesEJB;

import Entidades.Moneda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Leonardo Arevalo
 */
@Stateless
public class MonedaFacade extends AbstractFacade<Moneda> implements MonedaFacadeLocal {
    @PersistenceContext(unitName = "AplicacionPruebaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MonedaFacade() {
        super(Moneda.class);
    }
    
}
