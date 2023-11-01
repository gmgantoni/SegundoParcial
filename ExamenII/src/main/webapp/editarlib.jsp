<%@page import="com.emergentes.clase.Libro"%>
<%
    Libro libro = (Libro) request.getAttribute("libro");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Libro</h1>
        <form action="LibroController" method="post">
            <input type="hidden" name="id" value="${libro.id}">
            <table>
                <tr>
                    <td>Titulo</td>
                    <td>
                        <input type="text" name="titulo" value="${libro.titulo}">
                    </td>
                </tr>
                <tr>
                    <td>Autor</td>
                    <td>
                        <input type="text" name="autor" value="${libro.autor}">
                    </td>
                </tr>
                <tr>
                    <td>Disponible</td>
                    <td>
                        <input type="text" name="disponible" value="${libro.disponible}">
                    </td>
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td>
                        <input type="text" name="categoria" value="${libro.categoria}">
                    </td>
                </tr>
            </table>
            <input type="submit"  value="Enviar">
        </form>
    </body>
</html>
