/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Documentos;
import java.util.ArrayList;
import java.util.Date;
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
public class DocumentosFacade extends AbstractFacade<Documentos> implements DocumentosFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentosFacade() {
        super(Documentos.class);
    }
    
       @Override
        public List<Documentos> ListarDoc1() {
        List<Documentos> listaDoc = new ArrayList();
        Query sql = em.createNamedQuery("Documentos.documento1");
        listaDoc = sql.getResultList();
        return listaDoc;
    
}
    @Override
             public List<Documentos> ListarDoc2() {
        List<Documentos> listaDoc = new ArrayList();
        Query sql = em.createNamedQuery("Documentos.documento2");
        listaDoc = sql.getResultList();
        return listaDoc;
    
}
    @Override
              public List<Documentos> ListarDoc3() {
        List<Documentos> listaDoc = new ArrayList();
        Query sql = em.createNamedQuery("Documentos.documento3");
        listaDoc = sql.getResultList();
        return listaDoc;
    
}
    @Override
               public List<Documentos> ListarDoc4() {
        List<Documentos> listaDoc = new ArrayList();
        Query sql = em.createNamedQuery("Documentos.documento4");
        listaDoc = sql.getResultList();
        return listaDoc;
    
}
    @Override
                   public List<Documentos> ListarDocumentos() {
        List<Documentos> listaDoc = new ArrayList();
        Query sql = em.createNamedQuery("Documentos.findByIdConsultor");
        listaDoc = sql.getResultList();
        return listaDoc;
    
}
    @Override
                       public List<Documentos> ListarDocumentos1() {
        List<Documentos> listaDoc = new ArrayList();
        Query sql = em.createNamedQuery("Documentos.findByIdEstado");
        listaDoc = sql.getResultList();
        return listaDoc;
    
}
    @Override
                 public List<Documentos> ListarDocumentoxCedula(Integer numUsuario) {
        List<Documentos> listarCedula = new ArrayList();
        Query sql = em.createNamedQuery("Documentos.findByNumCedula").setParameter("idUser", numUsuario);
        listarCedula = sql.getResultList();
        return listarCedula;
    }   
      
    @Override
                     public List<Documentos> ListarDocumentoxIso(String nomIso) {
        List<Documentos> listarIso = new ArrayList();
        Query sql = em.createNamedQuery("Documentos.findByTipoIso").setParameter("tipoIso", nomIso);
        listarIso = sql.getResultList();
        return listarIso;
    }         
    @Override
                         public List<Documentos> ListarDocumentoxFecha(Date fechaI) {
        List<Documentos> listarFechaI = new ArrayList();
        Query sql = em.createNamedQuery("Documentos.findByFechaInicio").setParameter("fechaInicio", fechaI);
        listarFechaI = sql.getResultList();
        return listarFechaI;
    }         
    @Override
                         public List<Documentos> ListarDocumentoxFechaf(Date fechaF) {
        List<Documentos> listarFechaF = new ArrayList();
        Query sql = em.createNamedQuery("Documentos.findByFechaFin").setParameter("fechaFin", fechaF);
        listarFechaF = sql.getResultList();
        return listarFechaF;
    }     
    
}
