/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Cuenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface CuentaFacadeLocal {

    void create(Cuenta cuenta);

    void edit(Cuenta cuenta);

    void remove(Cuenta cuenta);

    Cuenta find(Object id);

    List<Cuenta> findAll();

    List<Cuenta> findRange(int[] range);

    int count();
    
}
