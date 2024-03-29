/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Pago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface PagoFacadeLocal {

    void create(Pago pago);

    void edit(Pago pago);

    void remove(Pago pago);

    Pago find(Object id);

    List<Pago> findAll();

    List<Pago> findRange(int[] range);

    int count();
    public Pago listarporpago (Integer pago);
    
}
