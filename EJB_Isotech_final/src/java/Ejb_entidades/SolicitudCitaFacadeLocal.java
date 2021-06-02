/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.SolicitudCita;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface SolicitudCitaFacadeLocal {

    void create(SolicitudCita solicitudCita);

    void edit(SolicitudCita solicitudCita);

    void remove(SolicitudCita solicitudCita);

    SolicitudCita find(Object id);

    List<SolicitudCita> findAll();

    List<SolicitudCita> findRange(int[] range);

    int count();
    
}
