/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Detalle;
import EJB.Visitante;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Stalyn
 */
@Stateless
public class VisitanteFacade extends AbstractFacade<Visitante> implements VisitanteFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VisitanteFacade() {
        super(Visitante.class);
    }
    @Override
                public void CrearVisitante(String numCedula, String nombre, String apellido, String telefono, String correo, String ciudad, String empresa, String mensaje) {
        Visitante visitante = new Visitante();
        visitante.setCiVisitante(numCedula);
        visitante.setNombreVisitante(nombre);
        visitante.setApellidoVisitante(apellido);
        visitante.setTelefonoVisitante(telefono);
        visitante.setCorreoVisitante(correo);
        visitante.setCiudad(ciudad);
        visitante.setEmpresa(empresa);
        visitante.setMensaje(mensaje);
        em.persist(visitante);
    }
    
    
    @Override
            public List<Visitante> ListarVisitante() {
        List<Visitante> listarVisitante = new ArrayList();
        Query sql = em.createNamedQuery("Visitante.findAll");
        listarVisitante = sql.getResultList();
        return listarVisitante;
    }
    
    
 
    @Override
   public Visitante busqueda_visitante (String ci){
      Visitante vi =null;
      try {
        
        Query sql=em.createNamedQuery("Visitante.findByCiVisitante").setParameter("ciVisitante",ci);
          
        List<Visitante>visitantes=sql.getResultList();
        
        if(!visitantes.isEmpty()){
            vi=visitantes.get(0);
        }
        } catch (Exception e) {
               throw  e;
        }
        return vi;
    }
    
    
}
