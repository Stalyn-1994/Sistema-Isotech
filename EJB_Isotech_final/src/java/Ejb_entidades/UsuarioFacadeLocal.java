/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
       public List<Usuario> ListarUsuarios();

    public Usuario iniciariSesion(Usuario cli) throws Exception;
    
    

    public List<Usuario> ListarCliente1();

    public List<Usuario> ListarCliente2();

    public List<Usuario> ListarCliente3();

    public List<Usuario> ListarCliente4();

    public List<Usuario> ListarxCi(String ci);
    
    public Usuario encontrarUser (Integer usuario);
    
    
}
