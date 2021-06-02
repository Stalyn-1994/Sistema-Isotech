/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Citas;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Stalyn
 */
@Stateless
public class CitasFacade extends AbstractFacade<Citas> implements CitasFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CitasFacade() {
        super(Citas.class);
    }
    
       @Override
           public List<Citas> ListarCita1() {
        List<Citas> listaCita = new ArrayList();
        Query sql = em.createNamedQuery("Citas.citaCliente1");
        listaCita = sql.getResultList();
        return listaCita;
    
}
}
