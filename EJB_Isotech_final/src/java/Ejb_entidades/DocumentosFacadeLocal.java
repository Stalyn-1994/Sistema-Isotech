/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb_entidades;

import EJB.Documentos;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stalyn
 */
@Local
public interface DocumentosFacadeLocal {

    void create(Documentos documentos);

    void edit(Documentos documentos);

    void remove(Documentos documentos);

    Documentos find(Object id);

    List<Documentos> findAll();

    List<Documentos> findRange(int[] range);

    int count();
    
       public List<Documentos> ListarDoc1();

    public List<Documentos> ListarDoc2();

    public List<Documentos> ListarDoc3();

    public List<Documentos> ListarDoc4();

    public List<Documentos> ListarDocumentos();

    public List<Documentos> ListarDocumentos1();

   
   

    public List<Documentos> ListarDocumentoxIso(String nomIso);

    public List<Documentos> ListarDocumentoxCedula(Integer numUsuario);

    public List<Documentos> ListarDocumentoxFecha(Date fechaI);

    public List<Documentos> ListarDocumentoxFechaf(Date fechaF);
    
    
}
