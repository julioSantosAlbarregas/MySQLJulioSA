<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    String error = request.getAttribute("error") != null ? (String) request.getAttribute("error") : "";

    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <fieldset style="width: 35%">
                <form action="Controlador" method="POST">
                    <table>
                        <tr align="center">
                            <th colspan="3"><h2>Base de datos</h2></th>
                        </tr>
                        <tr align="center">
                            <td>Anilla</td>
                            <td><input type="text" name="anilla" required/></td>
                        </tr>
                        <tr align="center">
                            <td colspan="3">
                                <input type="submit" name="buscar" value="Anilla"/>
                                <input type="submit" name="todos" value="Todos" formnovalidate />
                                <input type="submit" name="algunos" value="Algunos" formnovalidate />
                            </td>
                        </tr>
                        <tr align="center">
                            <td colspan="3" style="color: darkred">
                                <%= error %>
                            </td>
                        </tr>
                    </table>
                </form>
            </fieldset>

        </div>
    </body>
</html>
