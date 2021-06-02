/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Tarjeta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface TarjetaFacadeLocal {

    void create(Tarjeta tarjeta);

    void edit(Tarjeta tarjeta);

    void remove(Tarjeta tarjeta);

    Tarjeta find(Object id);

    List<Tarjeta> findAll();

    List<Tarjeta> findRange(int[] range);

    int count();
    
    
     public Tarjeta listarporcodigo (Tarjeta ta);
     public List<Tarjeta> listarpordescr (String descr);
     public List<Tarjeta> listarporfecha (String codfecha);
      public List<Tarjeta> listarporcodigoseg (String codigoseg);
}
