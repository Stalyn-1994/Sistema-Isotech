/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Cheque;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface ChequeFacadeLocal {

    void create(Cheque cheque);

    void edit(Cheque cheque);

    void remove(Cheque cheque);

    Cheque find(Object id);

    List<Cheque> findAll();

    List<Cheque> findRange(int[] range);

    int count();
    
}
