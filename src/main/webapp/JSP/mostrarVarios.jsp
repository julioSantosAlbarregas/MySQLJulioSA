<%-- 
    Document   : mostrarVarios
    Created on : 22-oct-2019, 10:06:15
    Author     : julio
--%>

<%@page import="java.util.ArrayList"%>
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

                <table>
                    <tr>
                        <th>Anilla</th>
                        <th>Especie</th>
                        <th>Lugar</th>
                        <th>Fecha</th>
                    </tr>
                    <%
                        ArrayList<Ave> aves = new ArrayList<>();

                        aves = (ArrayList<Ave>) request.getAttribute("aves");

                        for (int i = 0; i < aves.size(); i++) {
                    %>
                    <tr>

                        <td> <%= aves.get(i).getAnilla()%></td>
                        <td> <%= aves.get(i).getEspecie()%></td>
                        <td> <%= aves.get(i).getLugar()%></td>
                        <td> <%= aves.get(i).getFecha()%></td>

                    </tr>
                    <%

                        }
                    %>
                </table>
                <form action="Controlador" method="POST">
                    <input type="submit" name="volver" value="Volver" />
                </form>
            </fieldset>
        </div>
    </body>
</html>
