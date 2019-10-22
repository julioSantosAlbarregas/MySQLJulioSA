/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Ave;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author julio
 */
public class Controlador extends HttpServlet {

    @Override
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;
        String url = "";
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebasjava", "java2019", "2019");

            sentencia = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (request.getParameter("todos") != null) {

            try {

                String sentenciaSQL = "SELECT * FROM aves";
                resultado = sentencia.executeQuery(sentenciaSQL);
                ArrayList<Ave> aves = new ArrayList<>();

                resultado.beforeFirst();

                while (resultado.next()) {

                    Ave ave = new Ave();

                    ave.setAnilla(resultado.getString("anilla"));
                    ave.setEspecie(resultado.getString("especie"));
                    ave.setLugar(resultado.getString("lugar"));
                    ave.setFecha(resultado.getString("fecha"));

                    aves.add(ave);

                }

                request.setAttribute("aves", aves);

                url = "JSP/mostrarVarios.jsp";

            } catch (SQLException ex) {
                request.setAttribute("error", "No existen aves");
            }

        } else if (request.getParameter("algunos") != null) {

            try {

                String sentenciaSQL = "SELECT * FROM aves ORDER BY rand() LIMIT 2";
                resultado = sentencia.executeQuery(sentenciaSQL);
                ArrayList<Ave> aves = new ArrayList<>();

                resultado.beforeFirst();

                while (resultado.next()) {

                    Ave ave = new Ave();

                    ave.setAnilla(resultado.getString("anilla"));
                    ave.setEspecie(resultado.getString("especie"));
                    ave.setLugar(resultado.getString("lugar"));
                    ave.setFecha(resultado.getString("fecha"));

                    aves.add(ave);

                }

                request.setAttribute("aves", aves);

                url = "JSP/mostrarVarios.jsp";

            } catch (SQLException ex) {
                request.setAttribute("error", "No existen aves");
            }

        } else if (request.getParameter("buscar") != null) {

            try {

                String sentenciaSQL = "SELECT * FROM `aves` WHERE anilla='" + (String) request.getParameter("anilla") + "'";
                
                System.out.println(sentenciaSQL);
                
                resultado = sentencia.executeQuery(sentenciaSQL);

                resultado.beforeFirst();

                resultado.next();

                Ave ave = new Ave();

                ave.setAnilla(resultado.getString("anilla"));
                ave.setEspecie(resultado.getString("especie"));
                ave.setLugar(resultado.getString("lugar"));
                ave.setFecha(resultado.getString("fecha"));

                request.setAttribute("ave", ave);

                url = "JSP/mostrarUno.jsp";

            } catch (SQLException ex) {
                request.setAttribute("error", "No existe una ave con esa anilla");
            }

        }
        
        try {
            if (conexion != null) {
            conexion.close();
            }
            if (sentencia != null) {
            sentencia.close();
            }
            if (resultado != null) {
            resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher(url).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
