/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Producto2;
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
public class create_product extends HttpServlet {

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
        
          try {
            String idProducto = request.getParameter("id");
            String codigoBarra = request.getParameter("txtCodigoBarra");
            String nombre = request.getParameter("txtNombre");
            String Categoria = request.getParameter("txtCategoria");
            String marca = request.getParameter("txtMarca");
            String redirectURL = "Producto.jsp"; 
            String htmlFormName = request.getParameter("InputValue");
            String buttonEliminar = request.getParameter("btnEliminar");
                Producto2 prodcs = new Producto2();
            
             switch (htmlFormName){
                 
               case "insertar" : 
                   
                   if(codigoBarra.equals("")|| nombre.equals("")|| Categoria.equals("") || marca.equals("")){
                       
                    request.setAttribute("msg1", "Por favor rellene todos los campos");
                    RequestDispatcher rd = request.getRequestDispatcher(redirectURL);
                    rd.forward(request, response);

                   }else {
                          
                    prodcs.insertProducto(codigoBarra, nombre, Categoria, marca);
                    response.sendRedirect(redirectURL);
                    
                      }   
                         break;
                 
               case "modificar" :
                   
                  /*  if(codigoBarra.equals("")|| nombre.equals("")|| Categoria.equals("") || marca.equals("")){
                       
                    request.setAttribute("msg1", "Por favor rellene todos los campos");
                    RequestDispatcher rd = request.getRequestDispatcher(redirectURL);
                    rd.forward(request, response);

                   }else {*/
                        prodcs.updateProducto(idProducto, codigoBarra, nombre, Categoria, marca);
                         response.sendRedirect(redirectURL);
                   
                     break;
                   
                   
                   
               case "Editar": 
                   
              int id = Integer.parseInt(idProducto);
              LinkedList<Producto2> listas = Producto2.getProducto2(id);
              
              request.setAttribute("idProducto", listas.get(0).getIdProducto());
              request.setAttribute("CodigoBarraProducto", listas.get(0).getCodigoBarra());
               request.setAttribute("nombreProducto", listas.get(0).getNombre());
                request.setAttribute("categoriaProducto", listas.get(0).getCategoria());
                  request.setAttribute("marcaProducto", listas.get(0).getMarca());
              
              
              request.getRequestDispatcher("/EditarProducto.jsp").forward(request, response);
              
              
                   break;
               case "btnEliminar":
                    prodcs.deleteProducto(idProducto);
                             response.sendRedirect(redirectURL);
             }
             
            }catch (Exception e){
                System.out.println("error: " + e);
            
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
