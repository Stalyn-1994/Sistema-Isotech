/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Citas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface CitasFacadeLocal {

    void create(Citas citas);

    void edit(Citas citas);

    void remove(Citas citas);

    Citas find(Object id);

    List<Citas> findAll();

    List<Citas> findRange(int[] range);

    int count();
      public List<Citas> ListarCita1();
}
