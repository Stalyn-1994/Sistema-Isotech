/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.CitaVisitante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface CitaVisitanteFacadeLocal {

    void create(CitaVisitante citaVisitante);

    void edit(CitaVisitante citaVisitante);

    void remove(CitaVisitante citaVisitante);

    CitaVisitante find(Object id);

    List<CitaVisitante> findAll();

    List<CitaVisitante> findRange(int[] range);

    int count();
    
}
