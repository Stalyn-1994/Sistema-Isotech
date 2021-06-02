/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.TipoUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface TipoUserFacadeLocal {

    void create(TipoUser tipoUser);

    void edit(TipoUser tipoUser);

    void remove(TipoUser tipoUser);

    TipoUser find(Object id);

    List<TipoUser> findAll();

    List<TipoUser> findRange(int[] range);

    int count();
    
}
