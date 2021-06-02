/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "EJB_Isotech_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    
      @Override
             public List<Usuario> ListarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList();
        Query sql = em.createNamedQuery("Usuario.findAll");
        listaUsuarios = sql.getResultList();
        return listaUsuarios;
    
}
    
    @Override
            public Usuario iniciariSesion(Usuario cli) throws Exception{
    
        Usuario usuario = null;
        try{
        Query sql = em.createNamedQuery("Usuario.validarUsuario")
                .setParameter("usuarioUser",cli.getUsuarioUser())
                .setParameter("contraseniaUser", cli.getContraseniaUser());
        List<Usuario> listaUsuario = sql.getResultList();
        if (!listaUsuario.isEmpty()){
        usuario = listaUsuario.get(0);}
        }catch(Exception e){
        throw e;
        }
    return usuario;
    }
    
    @Override
                public List<Usuario> ListarCliente1() {
        List<Usuario> listaCliente = new ArrayList();
        Query sql = em.createNamedQuery("Usuario.primerCliente");
        listaCliente = sql.getResultList();
        return listaCliente;
    
}
    @Override
               public List<Usuario> ListarCliente2() {
        List<Usuario> listaCliente = new ArrayList();
        Query sql = em.createNamedQuery("Usuario.segundoCliente");
        listaCliente = sql.getResultList();
        return listaCliente;
    
}
    @Override
                     public List<Usuario> ListarCliente3() {
        List<Usuario> listaCliente = new ArrayList();
        Query sql = em.createNamedQuery("Usuario.tercerCliente");
        listaCliente = sql.getResultList();
        return listaCliente;
   
}
    @Override
        public List<Usuario> ListarCliente4() {
        List<Usuario> listaCliente = new ArrayList();
        Query sql = em.createNamedQuery("Usuario.cuartoCliente");
        listaCliente = sql.getResultList();
        return listaCliente;
    
}
    @Override
    public List<Usuario> ListarxCi(String ci) {
        List<Usuario> listaCliente = new ArrayList();
        Query sql = em.createNamedQuery("Usuario.findByCiUser").setParameter("ciUser", ci);
        listaCliente = sql.getResultList();
        return listaCliente;
}
    
       
    @Override
    public Usuario encontrarUser(Integer usuario){
        Usuario usr=null;
        try {
            List<Usuario>users=new ArrayList();
        Query sql=em.createNamedQuery("Usuario.findByIdUsuario").setParameter("idUsuario", usuario);
        users=sql.getResultList();
         if(!users.isEmpty()){
            usr=users.get(0);
         }
        } catch (Exception e) {
            throw e;
        }
        
        
        return usr;
        
    } 
    
    
    
}
