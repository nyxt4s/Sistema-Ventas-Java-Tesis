/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.SolicitudMercaderiad;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claud
 */
public class create_solicitud extends HttpServlet {

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
         String usuarioaEliminar = request.getParameter("usuario");
             String id = request.getParameter("idSolicitud");
             String nombreProducto = request.getParameter("txtProducto");
             String cantidad = request.getParameter("txtCantidad");
             String usuario = request.getParameter("id");
             String htmlFormName = request.getParameter("InputValue");
                                                            
            String redirectURL = "AdminitradorDeSolicitud.jsp";
            
            SolicitudMercaderiad xds = new SolicitudMercaderiad();
            
            switch (htmlFormName){
               //case "3487 es insert"
               case "insertar" : 
                   
                    if(cantidad.equals("")){
                       
                    request.setAttribute("msg1", "Por favor rellene todos los campos");
                    RequestDispatcher rd = request.getRequestDispatcher(redirectURL);
                    rd.forward(request, response);

                   }else {
                          
                    xds.insertSolicitud(nombreProducto, cantidad, usuario);
                    response.sendRedirect(redirectURL);
                    
                      }                    
               break;
               
               case "btnEliminar":
                   
                   xds.deleteProducto(id, usuarioaEliminar);
                    response.sendRedirect(redirectURL);
                    
                   
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
