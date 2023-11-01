<%@page import="com.emergentes.clase.Categoria"%>
<%
    Categoria categoria = (Categoria) request.getAttribute("categoria");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo</h1>
        <form action="CategoriaController" method="post">
            <input type="hidden" name="id" value="${categoria.id}">
            <table>
                <tr>
                    <th>Categoria</th>
                    <th>
                        <input type="text" name="categoria" value="${categoria.categoria}">
                    </th>
                </tr>
            </table>
            <input type="submit"  value="Enviar">
        </form>
    </body>
</html>
