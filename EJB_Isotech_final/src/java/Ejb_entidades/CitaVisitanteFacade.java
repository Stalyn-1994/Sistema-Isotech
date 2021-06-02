/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.CitaVisitante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Stalyn
 */
@Stateless
public class CitaVisitanteFacade extends AbstractFacade<CitaVisitante> implements CitaVisitanteFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitaVisitanteFacade() {
        super(CitaVisitante.class);
    }
    
}
