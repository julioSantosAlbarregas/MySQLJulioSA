<%-- 
    Document   : mostrarUno
    Created on : 22-oct-2019, 10:06:40
    Author     : julio
--%>

<%@page import="es.albarregas.beans.Ave"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <fieldset style="width: 35%">
                <h2>Resultados</h2>
                <%
                    Ave ave = new Ave();

                    ave = (Ave) request.getAttribute("ave");
                %>
                <ul>

                    <li>Anilla -> <%= ave.getAnilla()%></li>
                    <li>Especie -> <%= ave.getEspecie()%></li>
                    <li>Lugar -> <%= ave.getLugar()%></li>
                    <li>Fecha -> <%= ave.getFecha()%></li>

                </ul>
                <form action="Controlador" method="POST">
                    <input type="submit" name="volver" value="Volver" />
                </form>
            </fieldset>
        </div>
    </body>
</html>
