/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Visitante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface VisitanteFacadeLocal {

    void create(Visitante visitante);

    void edit(Visitante visitante);

    void remove(Visitante visitante);

    Visitante find(Object id);

    List<Visitante> findAll();

    List<Visitante> findRange(int[] range);

    int count();
    
    
    public void CrearVisitante(String numCedula, String nombre, String apellido, String telefono, String correo, String ciudad, String empresa, String mensaje);

    public List<Visitante> ListarVisitante();
    
    
     public Visitante busqueda_visitante (String ci);
}
