/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Consultor;
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
public class ConsultorFacade extends AbstractFacade<Consultor> implements ConsultorFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultorFacade() {
        super(Consultor.class);
    }
    
    @Override
                 public Consultor iniciarSesion(Consultor con) throws Exception{
    
        Consultor consultor = null;
        try{
        Query sql = em.createNamedQuery("Consultor.validarConsultor")
                .setParameter("usuarioConsultor",con.getUsuarioConsultor())
                .setParameter("contraseniaConsultor", con.getContraseniaConsultor());
        List<Consultor> listaConsultor = sql.getResultList();
        if (!listaConsultor.isEmpty()){
        consultor = listaConsultor.get(0);}
        }catch(Exception e){
        throw e;
        }
    return consultor;
    }
    
    @Override
        public List<Consultor> ListarConsultor1() {
        List<Consultor> listaCon = new ArrayList();
        Query sql = em.createNamedQuery("Consultor.consultor1");
        listaCon = sql.getResultList();
        return listaCon;
    
}
    
}
