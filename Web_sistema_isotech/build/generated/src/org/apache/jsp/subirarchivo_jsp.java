package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.File;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

public final class subirarchivo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\"\n");
      out.write("      xmlns:h=\"http://java.sun.com/jsf/html\"\n");
      out.write("      xmlns:f=\"http://java.sun.com/jsf/core\"\n");
      out.write("      xmlns:p=\"http://primefaces.org/ui\">\n");
      out.write("    <f:view contentType=\"text/html\" encoding=\"UTF-8\">\n");
      out.write("        <h:head>\n");
      out.write("        <title>PROYECTO ISOTECH</title>\n");
      out.write("        <link href=\"../recursos/css/estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </h:head>\n");
      out.write("    \n");
      out.write("    <h:head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \n");
      out.write("        <title>Subiendo Archivo.....</title>\n");
      out.write("        </meta>\n");
      out.write("    </h:head>\n");
      out.write("    <body>\n");
      out.write("   <div class=\"main\">\n");
      out.write("            <div class=\"navbar\">\n");
      out.write("                <div class=\"link \">\n");
      out.write("                   <a href=\"index.xhtml\">Inicio</a>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            <div class=\"link\">\n");
      out.write("                   <a href=\"normasIso.xhtml\">Normas Iso</a>\n");
      out.write("            </div>\n");
      out.write("                <div class=\"link \">\n");
      out.write("                   <a href=\"formularioDatos.xhtml\">Contactanos</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"link \">\n");
      out.write("                   <a href=\"aboutUs.xhtml\">Acerca de Nosotros</a>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <h:form>\n");
      out.write("                    <div class=\"caratula\">\n");
      out.write("                    </div>\n");
      out.write("                </h:form>\n");
      out.write("                \n");
      out.write("                <div class=\"link\">\n");
      out.write("               \n");
      out.write("                  </div>\n");
      out.write("                <br/>\n");
      out.write("                <br/>\n");
      out.write("           \n");
      out.write("                \n");
      out.write("                 <h:form>\n");
      out.write("                <FONT COLOR=\"orange\"> <h1>SUBIR ARCHIVOS</h1> </FONT>\n");
      out.write("                <br/>\n");
      out.write("                <br/>           \n");
      out.write("              ");
   
            String archivourl = "D:\\Imágenes\\archivo";
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024);
            factory.setRepository(new File(archivourl));
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            try{
                List<FileItem> partes = upload.parseRequest(request);
                
                for(FileItem items: partes){
                    File file = new File(archivourl,items.getName());
                    items.write(file);
                    
                }
                out.print("<h2>Archivo correctamente subido......</h2>");
            }catch(Exception e){
                
                out.print("Exception: "+ e.getMessage()+"");
            }
                    
                    
        
        
        
      out.write("\n");
      out.write("                </h:form>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            </div>     \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("       \n");
      out.write("        \n");
      out.write("        <h:head>\n");
      out.write("           \n");
      out.write("<style>\n");
      out.write(".cities {\n");
      out.write("  background-color: black;\n");
      out.write("  color: white;\n");
      out.write("  margin: 20px;\n");
      out.write("  padding: 20px;\n");
      out.write("} \n");
      out.write("</style>\n");
      out.write("</h:head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"cities\">\n");
      out.write("   \n");
      out.write("  <h2>Direccion</h2>\n");
      out.write("  <p>Alejandro Valdez y la Gasca / Ciudadela Universitaria</p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"cities\">\n");
      out.write("  <h2>Telefonos</h2>\n");
      out.write("  <p>0998075827</p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"cities\">\n");
      out.write("  <h2>Horarios de Atencion</h2>\n");
      out.write("  <p>Administración: 08h00 - 12h30 13h00- 16h00</p>\n");
      out.write("  <p>Telefonos: 0998075827</p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    <div class=\"cities\">\n");
      out.write("  <h2>Soporte en Tecnologias de la Informacion</h2>\n");
      out.write("  <p>Correo: ebchalacan@uce.edu.ec</p>\n");
      out.write("  <p>Telefonos: 0998075827</p>\n");
      out.write("  <p>Horarios de Atension: 07h00 - 21h00</p>\n");
      out.write("</div>\n");
      out.write("    \n");
      out.write("    <div class=\"cities\">\n");
      out.write("  <h2>BLOGS</h2>\n");
      out.write("   <A HREF=\"http://isotechucentral.blogspot.com\"><FONT COLOR=\"ORANGE\">Blog de Prueba</FONT></A>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("    </body>\n");
      out.write("        </f:view>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
