/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Detalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface DetalleFacadeLocal {

    void create(Detalle detalle);

    void edit(Detalle detalle);

    void remove(Detalle detalle);

    Detalle find(Object id);

    List<Detalle> findAll();

    List<Detalle> findRange(int[] range);

    int count();
    
       public List<Detalle> listarporpago (Integer pago);
    public Double subtotal(List<Detalle> detalles);
    public Double iva(Double subtotal);
    public Double total(Double subtotal,Double iva);
    public Double transformar(Double valor);
      public Double desc(Double total);
       public Double totalDesc(Double total,Double desc);
}
