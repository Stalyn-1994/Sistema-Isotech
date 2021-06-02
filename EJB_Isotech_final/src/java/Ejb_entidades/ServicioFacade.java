/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Servicio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Stalyn
 */
@Stateless
public class ServicioFacade extends AbstractFacade<Servicio> implements ServicioFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicioFacade() {
        super(Servicio.class);
    }
    
}
