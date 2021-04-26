/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Local;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claud
 */
public class Locales extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         
              String rut = request.getParameter("txtRutLocal");
            String digitoVerificador = request.getParameter("txtDigitoVerificadorLocal");
            String razonSocial = request.getParameter("txtRazonSocial");
            String nombreComercial = request.getParameter("txtNombreComercial");
            String identificador = request.getParameter("InputValue");
            String id = request.getParameter("id");
            String btnEliminar = request.getParameter("btnEliminar");
            String redirectURL = "Local.jsp";
            Local xd = new Local();

            
            switch(identificador){
                case "btnEliminar" :
                     xd.deleteLocal(btnEliminar);
                  response.sendRedirect(redirectURL);

                    break;
            
                 case "modificar" :
               
                 xd.updatelocal(id, rut, razonSocial, nombreComercial);
                 response.sendRedirect(redirectURL);
                    
                    break;
                 case "insertar" :
                     xd.insertLocal(rut, digitoVerificador, razonSocial, nombreComercial);
                    response.sendRedirect(redirectURL);
                    break;
                    
                    
                 case "Editar" :
                     
              int ids = Integer.parseInt(id);
                
              LinkedList <Local> listas = Local.getLocal2(ids);
             
              request.setAttribute("idLocal", listas.get(0).getId_local());
              request.setAttribute("rutLocal", listas.get(0).getRut());
              request.setAttribute("DigitoVerificador", listas.get(0).getDigito_verificardor());
              request.setAttribute("NombreComercial", listas.get(0).getNombre_comercial());
              request.setAttribute("RazonSocial", listas.get(0).getRazon_Social());
              
              request.getRequestDispatcher("EditarLocal.jsp").forward(request, response);
              
                    break;
            }
               
            
            
        }
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
