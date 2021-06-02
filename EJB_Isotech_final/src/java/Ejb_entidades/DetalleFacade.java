/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Detalle;
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
public class DetalleFacade extends AbstractFacade<Detalle> implements DetalleFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleFacade() {
        super(Detalle.class);
    }
    
    
    
    @Override
    public List<Detalle> listarporpago (Integer pago){
        List<Detalle>detalles=new ArrayList();
        Query sql=em.createNamedQuery("Detalle.findbypay").setParameter("idPago", pago);
        detalles=sql.getResultList();
        return detalles;
        
    }
    
    
    
    @Override
    public Double subtotal(List<Detalle> detalles){       
        Double subtotales=0.0;
        for (int i = 0; i < detalles.size(); i++) {
            subtotales=detalles.get(i).getIdServicio().getCostoServicio()+subtotales;
        }
        subtotales=transformar(subtotales);
        return subtotales;
        
    }
    
    
    @Override
    public Double iva(Double subtotal){
       Double iv=0.0;       
       iv=subtotal*0.12;
       iv=transformar(iv);
       return iv;
 }
    
    
    
      
    @Override
    public Double total(Double subtotal,Double iva){
       Double total=0.0;       
       total=subtotal+iva;
       total=transformar(total);
       return total;
 }
    
    
    @Override
    public Double transformar(Double valor){
       valor = Math.round(valor * 100) / 100d;     
       return valor;
   }
    
    
 @Override
        public Double desc(Double total){
       Double iv=0.0; 
       if(total==134.38){
           
       iv=total*0.05;
       }else if(total==201.57){
       iv=total*0.1;
       }else if(total==268.76){
        iv=total*0.20;   
       }
       
       iv=transformar(iv);
       return iv;
 }
 @Override
            public Double totalDesc(Double total,Double desc){
       Double totalDesc=0.0;   
       
       if(total==134.38){
       totalDesc=total-desc;
       }else if (total==201.57){
           totalDesc=total-desc;
                   }else if(total==268.76){
        totalDesc=total-desc;  
       }else{
                   totalDesc=total;}
       totalDesc=transformar(totalDesc);
       
       return totalDesc;
 }
    
    
}
