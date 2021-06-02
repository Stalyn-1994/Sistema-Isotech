/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Tarjeta;
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
public class TarjetaFacade extends AbstractFacade<Tarjeta> implements TarjetaFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarjetaFacade() {
        super(Tarjeta.class);
    }
    
    
    
    @Override
             public Tarjeta listarporcodigo (Tarjeta ta){
        Tarjeta tarjeta =null;
      try {
        
        Query sql=em.createNamedQuery("Tarjeta.findByalltarjeta").setParameter("coodigoTarjeta", ta.getCoodigoTarjeta()).setParameter("descripcionTarjeta",ta.getDecripcionTarjeta()).setParameter("codigoSeguridad", ta.getCodigoSeguridad()).setParameter("fechaVencer", ta.getFechaVencer());
          
        List<Tarjeta>tarjetas=sql.getResultList();
        
        if(!tarjetas.isEmpty()){
            tarjeta=tarjetas.get(0);
        }
        } catch (Exception e) {
               throw  e;
        }
        return tarjeta;
    }
    
    @Override
         public List<Tarjeta> listarporcodigoseg (String codigoseg){
        List<Tarjeta>tarjetas=new ArrayList();
        Query sql=em.createNamedQuery("Tarjeta.findByCodigoSeguridad").setParameter("idPago", codigoseg);
        tarjetas=sql.getResultList();
        return tarjetas;
    }
    @Override
         public List<Tarjeta> listarporfecha (String codfecha){
        List<Tarjeta>tarjetas=new ArrayList();
        Query sql=em.createNamedQuery("Tarjeta.findByFechaVencer").setParameter("idPago", codfecha);
        tarjetas=sql.getResultList();
        return tarjetas;
    }
    
    @Override
         public List<Tarjeta> listarpordescr (String descr){
        List<Tarjeta>tarjetas=new ArrayList();
        Query sql=em.createNamedQuery("Tarjeta.findByDecripcionTarjeta").setParameter("idPago", descr);
        tarjetas=sql.getResultList();
        return tarjetas;
    }
    
    
}
