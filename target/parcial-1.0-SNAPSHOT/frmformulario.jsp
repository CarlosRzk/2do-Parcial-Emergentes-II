<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Formulario"%>
<%
    Formulario formulario = (Formulario) request.getAttribute("formulario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <textarea rows="5" cols="50">

        PRIMER PARCIAL TEM-742 
        Nombre: Carlos Ariel Quispe Yujra
        Carnet: 11064494
        </textarea>
        <h1>Nuevo Registro</h1>
        <form action="FormularioController" method="post">
            <input type="hidden" name="id" value="${formulario.id}">
            <table>
                <tr>
                    <td>Nombres</td>
                    <td><input type="text" name="nombres" value="${formulario.nombres}"/></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos" value="${formulario.apellidos}"/></td>
                </tr>
                <tr>
                    <td>Seminarios</td>
                    <td><input type="text" name="seminario" value="${formulario.seminario}"/></td>
                </tr>
                <tr>
                    <td>confirmados</td>
                    <td><input type="checkbox" name="confirmados" value="1" <c:if test="${formulario.confirmados == 1}">checked</c:if> /></td>
                </tr>
                <tr>
                    <td>Fecha Inscripcion</td>
                    <td><input type="date" name="fechainscripcion" value="${formulario.fechainscripcion}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"/></td>
                </tr>
            </table>
        </form>      
    </body>
</html>
