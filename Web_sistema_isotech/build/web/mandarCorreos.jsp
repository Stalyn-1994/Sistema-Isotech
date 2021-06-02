<%-- 
    Document   : uploadfile
    Created on : 07/06/2019, 10:42:37 PM
    Author     : AspireV3
--%>

<%@page import="mngBeans.sistemaBean" %>
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
                  <a href="../faces/Pagos/Administrador.xhtml">Administrador</a>
                </div>
                
            </div>
            <div class="content">
                <h:form>
                    <div class="caratula">
                    </div>
                </h:form>
                
                <div class="link">
               
                  </div>
                <br/>
                <br/>
           
                
                 <h:form>
                <FONT COLOR="orange"> <h1>Resultado Correo Electronico</h1> </FONT>
                <br/>
                <br/>           
             <%
            
            sistemaBean email = new sistemaBean();
            
            String de ="isguairacaja@uce.edu.ec";
            String clave ="CWVJ.232";
            String para = request.getParameter("para");
            String mensaje = request.getParameter("mensaje");
            String asunto ="Isotech Contraseña";
            
            /* 
                
                String[] direcciones = {"correo numero 1","correo numero 2","correo numero 3","correo ..."}
                boolean resultado = email.enviarCorreo(de, clave, direcciones, mensaje, asunto);
            
            */
            
            boolean resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);
            
            if(resultado){
                out.print("CORREO ELECTRONICO CORRECTAMENTE ENVIADO....."+"\n\n"+"<a href='../mandarCorreo.xhtml'>VOLVER AL INDEX</a>");
            }else{
                out.print("CORREO ELECTRONICO NO ENVIADO....."+"\n\n"+"<a href='../mandarCorreo.xhtml'>VOLVER AL INDEX</a>"); 
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
