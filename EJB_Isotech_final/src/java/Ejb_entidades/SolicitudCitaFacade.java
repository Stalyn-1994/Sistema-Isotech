/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.SolicitudCita;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Stalyn
 */
@Stateless
public class SolicitudCitaFacade extends AbstractFacade<SolicitudCita> implements SolicitudCitaFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudCitaFacade() {
        super(SolicitudCita.class);
    }
    
}
