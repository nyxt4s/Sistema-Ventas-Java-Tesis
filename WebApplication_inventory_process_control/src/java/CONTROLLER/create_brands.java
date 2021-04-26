/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Marca;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claud
 */
public class create_brands extends HttpServlet {

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
            
            
            
            try{
            //valor utilizado para el insert
            String nombreMarca = request.getParameter("txtNombreMarca");
            //valor utilizado para editar el nombre de una marca
          
           //valor oculto de una etiqueta input type hidden para utilizar en switch
           String htmlFormName = request.getParameter("InputValue");
           //valor que obtiene del boton eliminar 
           String valorbtnEliminar = request.getParameter("btnEliminar");
            //id de la marca
            String idMarca = request.getParameter("id");
            
           //Ruta de Marca
            String redirectURL = "Marca.jsp"; 
          
            //Clase Marca
            Marca obj = new Marca();

            
           switch (htmlFormName){
            
               case "insertar" : 
                   
                   if(nombreMarca.equals("") ){
                       
                    request.setAttribute("msg1", "Por favor rellene todos los campos");

                    RequestDispatcher rd = request.getRequestDispatcher(redirectURL);
                    
                    rd.forward(request, response);

                   }else {

                    obj.insertMarca(nombreMarca);
                    
                    response.sendRedirect(redirectURL);
                    
                        }
                   
               break;
                 
               case "modificar" :
                   
                    if(nombreMarca.equals("")  || idMarca.equals("")){
                       
                    request.setAttribute("msg1", "Por favor rellene todos los campos");
                    RequestDispatcher rd = request.getRequestDispatcher(redirectURL);
                    rd.forward(request, response);

                   }else {
                          
                    obj.updateMarca(idMarca, nombreMarca);
                     response.sendRedirect(redirectURL);
                      
                      }
                   break;
                   
                   
                   
               case "Editar": 
               int id = Integer.parseInt(idMarca);
              LinkedList<Marca> listas = Marca.getMarca2(id);
             
              request.setAttribute("idMarca", listas.get(0).getIdMarca());
              request.setAttribute("nombreMarca", listas.get(0).getNombreMarca());
              
              
              request.getRequestDispatcher("/EditarMarca.jsp").forward(request, response);
              
              
                   break;
               case "btnEliminar":
                   obj.deleteMarca(idMarca);
                   response.sendRedirect(redirectURL);
                   break;
            }
     
            
         }catch(Exception ex){
             System.out.println("Exception ex"+ ex);
         
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
