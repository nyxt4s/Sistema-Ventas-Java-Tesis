/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claud
 */
@WebServlet(name = "create_provider", urlPatterns = {"/Proveedor"})
public class create_provider extends HttpServlet {

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
              //rut concatenado rut 
           String rut = request.getParameter("txtRut");
           String digitoVerificador = request.getParameter("txtDigiteRut");
           String name = request.getParameter("txtName");
           String lastName = request.getParameter("txtLastName");
           String lastNameM = request.getParameter ("txtMotherLastName");
           String adress = request.getParameter("txtAdress");  
           String reasonSocial = request.getParameter("txtReasonSocial");
           String nombreComercial = request.getParameter("txtNameCommerce");
            String id = request.getParameter("id");
           //valor oculto de una etiqueta input type hidden para utilizar en switch
           String htmlFormName = request.getParameter("InputValue");
           //valor que obtiene del boton eliminar 
           String valorbtnEliminar = request.getParameter("btnEliminar");
         
           //Ruta de proveedor
            String redirectURL = "Proveedor.jsp"; 
           Proveedor xd = new Proveedor();   
           
           
           switch (htmlFormName){
                 //case "3487 es insert"
               case "insertar" : 
                       
                   if(rut.equals("") || digitoVerificador.equals("") || name.equals("") || lastName.equals("") || lastNameM.equals("") || adress.equals("") || reasonSocial.equals("") || nombreComercial.equals("") ){
                       
                    request.setAttribute("msg1", "Por favor rellene todos los campos");

                    RequestDispatcher rd = request.getRequestDispatcher(redirectURL);
                    
                    rd.forward(request, response);

                   }else {
                       
                 xd.insertProveedor(rut, digitoVerificador, name, lastName, lastNameM, adress, reasonSocial, nombreComercial);
                response.sendRedirect(redirectURL);
                   
                   }
                   
                   
                   
               break;

                     case "Editar": 
                         
                  int idEditar = Integer.parseInt(id);
              LinkedList<Proveedor> listas = Proveedor.getProveedor2(idEditar);
             
              request.setAttribute("idProveedor", listas.get(0).getId_Proveedor());
              request.setAttribute("rutProveedor", listas.get(0).getRut());
              request.setAttribute("digitoVerfiicador", listas.get(0).getDigito_Verificador());
              request.setAttribute("nombreProveedor", listas.get(0).getNombres());
              request.setAttribute("apellidoPaterno", listas.get(0).getApellido_P());
              request.setAttribute("apellidoMaterno", listas.get(0).getApellido_M());
              request.setAttribute("direccionProveedor", listas.get(0).getDireccion());
              request.setAttribute("nombreComercial", listas.get(0).getNombre_Comercial());
              request.setAttribute("razonSocial", listas.get(0).getRazon_Social());
              
              
              request.getRequestDispatcher("/EditarProveedor.jsp").forward(request, response);
              
              
                   break;
                   
               case "modificar" :
                xd.updateProveedor(id, name, lastName, lastNameM, adress, reasonSocial, nombreComercial);
                response.sendRedirect(redirectURL);
                   break;
                   
                   
               case "btnEliminar":
                   String valueid = valorbtnEliminar;
                   xd.DeletProveedor(valueid);
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
