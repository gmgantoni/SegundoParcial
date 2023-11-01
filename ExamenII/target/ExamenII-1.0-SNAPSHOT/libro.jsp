<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.clase.Libro"%>
<%@page import="java.util.List"%>

<%
    List<Libro> lista =(List<Libro>) request.getAttribute("lista");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center></center><h1>Libros</h1></center>
        <a href="LibroController?op=nuevo">Nuevo</a>
        <center></center><table border="1" cellspacing="0">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Disponible</th>
                <th>Categoria</th>
                <th colspan="2">Acciones</th>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.autor}</td>
                    <td>${item.disponible}</td>
                    <td>${item.categoria}</td>
                    <td><a href="LibroController?op=eliminar&id=${item.id}"
                           onclick="return(confirm('Eliminar??'))">Eliminar</a></td>
                    <td><a href="LibroController?op=editar&id=${item.id}"
                           >Editar</a></td>
                </tr>
            </c:forEach>
        </table></center>
    </body>
</html>
