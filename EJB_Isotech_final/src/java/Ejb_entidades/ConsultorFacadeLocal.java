/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Consultor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface ConsultorFacadeLocal {

    void create(Consultor consultor);

    void edit(Consultor consultor);

    void remove(Consultor consultor);

    Consultor find(Object id);

    List<Consultor> findAll();

    List<Consultor> findRange(int[] range);

    int count();
    
     public Consultor iniciarSesion(Consultor con) throws Exception;

    public List<Consultor> ListarConsultor1();
    
}
