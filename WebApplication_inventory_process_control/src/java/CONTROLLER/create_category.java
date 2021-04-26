/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Categoria;
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
public class create_category extends HttpServlet {

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
         
                      
            //valor utilizado para el insert
            String nombreCategoria = request.getParameter("txtNombreCategoria");
            //valor utilizado para editar el nombre de una marca
             String nombreCategoriaModificar = request.getParameter("txtEditarCategoria");
           //valor oculto de una etiqueta input type hidden para utilizar en switch
           String htmlFormName = request.getParameter("InputValue");
           //valor que obtiene del boton eliminar 
           String valorbtnEliminar = request.getParameter("btnEliminar");
            //id de la marca
            String idCategoria = request.getParameter("id");
            
           //Ruta de Marca
            String redirectURL = "Categoria.jsp"; 
          
            //Clase Marca
            Categoria obj = new Categoria();

            
           switch (htmlFormName){
               //case "3487 es insert"
               case "insertar" : 
                   
                    if(nombreCategoria.equals("")){
                       
                    request.setAttribute("msg1", "Por favor rellene todos los campos");
                    RequestDispatcher rd = request.getRequestDispatcher(redirectURL);
                    rd.forward(request, response);

                   }else {
                          
                    obj.insertCategoria(nombreCategoria);
                    response.sendRedirect(redirectURL);
                    
                      }
                    
               break;
                  //case "3488 es update"
               
               case "Editar": 
                   int id = Integer.parseInt(idCategoria);
              LinkedList<Categoria> listas = Categoria.getCategory2(id);
             
              request.setAttribute("idCategoria", listas.get(0).getIdcategoria());
              request.setAttribute("NombreCategoria", listas.get(0).getNombreCategoria());
              
              
              request.getRequestDispatcher("/EditarCategoria.jsp").forward(request, response);
              
              
                   break;
               
               case "modificar" :
              
               obj.updateCategoria(idCategoria, nombreCategoriaModificar);
                response.sendRedirect(redirectURL);
                
                break;
                   
               case "btnEliminar":
                   obj.deleteCategoria(valorbtnEliminar);
                   response.sendRedirect(redirectURL);
                   break;
            }
     
            
         }catch(Exception ex){
             System.out.println("Exception ex"+ ex);
         
         
          

        
    
        
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
