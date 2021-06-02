/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.EstadoCita;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface EstadoCitaFacadeLocal {

    void create(EstadoCita estadoCita);

    void edit(EstadoCita estadoCita);

    void remove(EstadoCita estadoCita);

    EstadoCita find(Object id);

    List<EstadoCita> findAll();

    List<EstadoCita> findRange(int[] range);

    int count();
    
}
