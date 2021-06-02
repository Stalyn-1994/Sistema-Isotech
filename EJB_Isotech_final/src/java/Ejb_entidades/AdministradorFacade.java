/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Administrador;
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
public class AdministradorFacade extends AbstractFacade<Administrador> implements AdministradorFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministradorFacade() {
        super(Administrador.class);
    }
      @Override
                    public Administrador iniciarSesion(Administrador adm) throws Exception{
    
        Administrador administrador = null;
        try{
        Query sql = em.createNamedQuery("Administrador.validarAdministrador")
                .setParameter("usuarioAdministrador",adm.getUsuarioAdministrador())
                .setParameter("contraseniaAdministrador", adm.getContraseniaAdministrador());
        List<Administrador> listaAdministrador = sql.getResultList();
        if (!listaAdministrador.isEmpty()){
        administrador = listaAdministrador.get(0);}
        }catch(Exception e){
        throw e;
        }
    return administrador;
    }
}
