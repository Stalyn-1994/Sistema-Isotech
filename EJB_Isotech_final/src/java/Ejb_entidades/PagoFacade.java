/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Pago;
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
public class PagoFacade extends AbstractFacade<Pago> implements PagoFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagoFacade() {
        super(Pago.class);
    }
    
    
    @Override
    public Pago listarporpago (Integer usuario){
        Pago pago=null;
        try {
            List<Pago>pagos=new ArrayList();
        Query sql=em.createNamedQuery("Pago.findByUsuario").setParameter("idUsuario", usuario);
        pagos=sql.getResultList();
         if(!pagos.isEmpty()){
            pago=pagos.get(0);
         }
        } catch (Exception e) {
            throw e;
        }
        
        
        return pago;
        
    } 
    
    
    
}
