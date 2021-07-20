<%-- 
    Document   : index
    Created on : 15/09/2020, 09:00:04 PM
    Author     : Admin
--%>

<%@page import="java.util.Iterator"%>
<%@page import="modelo.Rol"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.RolDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        

        
        <title>Pagina Principal</title>
    </head>
    
    <body class="col-lg-5 container text-center">
        <h1 class="text-center">Bienvenido</h1>
        <br>
        <div class="text-center">   
            <form action="Controlador" >

            <div >
                <label >Usuario</label>
                <input type="text" class="form-control" name="txtUsuario" placeholder="Nombre" required autofocus>
                
            </div>
            
            <div class="" >
                <label >Password</label>
                <input type="password" name="txtPassword" class="form-control" placeholder="Contraseña" required>            
            </div>
            <label for="inputRol">Rol</label>
<!--            <div>
                <select class="btn btn-primary" name="combolista">
                    <%
                    RolDAO rolDAO = new RolDAO();
                    List<Rol> listaUsuario = rolDAO.listar();
                    Iterator<Rol> iterator = listaUsuario.iterator();                    
                        Rol rol = null;
                    while(iterator.hasNext()){
                    rol = iterator.next();
                    %>
                    <option name="cmbRol" items="<%=rol.getCodigoRol() %>"><%=rol.getNombreRol() %></option>
                    <% } %>      
                </select>
            </div>-->
                    <select name="cmbRol">
                            <option value="1">Administrador</option>
                            <option value="2">Usuario</option>
                        </select>
            
            <div >
            <input class="btn btn-success btn-lg" type="submit" name="accion" value="Ingresar">
            </div>
            </form>
        </div>
    </body>
    
    
</html>
