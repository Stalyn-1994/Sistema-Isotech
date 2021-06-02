<%-- 
    Document   : uploadfile
    Created on : 07/06/2019, 10:42:37 PM
    Author     : AspireV3
--%>

<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:p="http://primefaces.org/ui">
    <f:view contentType="text/html" encoding="UTF-8">
        <h:head>
        <title>PROYECTO ISOTECH</title>
        <link href="../recursos/css/estilos.css" rel="stylesheet" type="text/css"/>
    </h:head>
    
    <h:head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Subiendo Archivo.....</title>
        </meta>
    </h:head>
    <body>
   <div class="main">
            <div class="navbar">
              <div class="link ">
                  <a href="../PaginasUsuarios/1_PagInicio.xhtml">Pagina Principal</a>
                </div>
                <div class="link ">
                  <a href="../PaginasUsuarios/1_agendamientoCitas_3.xhtml">Agenda una Cita</a>
                </div>
                <div class="link ">
                  <a href="../PaginasUsuarios/1_documentacion.xhtml">Documentacion</a>
                </div>
                <div class="link ">
                  <a href="../PaginasUsuarios/1_progreso.xhtml">Consulta tu Progreso</a>
                </div>
                
                <div class="link ">
                   <a href="../PaginasUsuarios/1_Administrar.xhtml">Datos Personales</a>
                </div>
                
           </div>
            <div class="content">
                <h:form>
                    <div class="caratula">
                    </div>
                    <FONT SIZE="+2"><p align="right"><i><b>
                     <p:commandLink  value="Cerrar Sesion" action="../PaginaInicial/index.xhtml" ajax="false"/>
                    </b></i></p></FONT>
                </h:form>
                
                <div class="link">
               
                  </div>
                <br/>
                <br/>
           
                
                 <h:form>
                <FONT COLOR="orange"> <h1>SUBIR ARCHIVOS</h1> </FONT>
                <br/>
                <br/>           
            <% 
            String archivourl = "C:\\Users\\Stalyn\\Desktop";
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
                    
                    
        
        
        %>
                </h:form>
                
            </div>
            </div>     
        
        
        
        
        
        
        
       
        
        <h:head>
           
<style>
.cities {
  background-color: black;
  color: white;
  margin: 20px;
  padding: 20px;
} 
</style>
</h:head>
<body>

<div class="cities">
   
  <h2>Direccion</h2>
  <p>Alejandro Valdez y la Gasca / Ciudadela Universitaria</p>
</div>

<div class="cities">
  <h2>Telefonos</h2>
  <p>0998075827</p>
</div>

<div class="cities">
  <h2>Horarios de Atencion</h2>
  <p>Administración: 08h00 - 12h30 13h00- 16h00</p>
  <p>Telefonos: 0998075827</p>
</div>

    <div class="cities">
  <h2>Soporte en Tecnologias de la Informacion</h2>
  <p>Correo: ebchalacan@uce.edu.ec</p>
  <p>Telefonos: 0998075827</p>
  <p>Horarios de Atension: 07h00 - 21h00</p>
</div>
    
    <div class="cities">
  <h2>BLOGS</h2>
   <A HREF="http://isotechucentral.blogspot.com"><FONT COLOR="ORANGE">Blog de Prueba</FONT></A>
</div>
</body>
    </body>
        </f:view>
</html>
