<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <h1>Registro Día del Internet</h1>
        <p><a href="FormularioController?action=add">Nuevo</p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Seminario</th>
                <th>Confirmados</th>
                <th>Fecha Inscripcion</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${formularios}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombres}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.seminario}</td>
                    <td>${item.confirmados == 1 ? 'Sí' : 'No'}</td>
                    <td>${item.fechainscripcion}</td>
                    <td><a href="FormularioController?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="FormularioController?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>
            </c:forEach>
                
        </table>
    </body>
</html>
