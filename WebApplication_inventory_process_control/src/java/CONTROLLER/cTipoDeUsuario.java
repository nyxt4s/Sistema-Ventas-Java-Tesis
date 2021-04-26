/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.TipoDeUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class cTipoDeUsuario extends HttpServlet {

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
            
            
           TipoDeUsuario TP = new TipoDeUsuario();
           
           String InsertTipoUsuarioForm = request.getParameter("NombreTipoDeUsuario");  
           
           String UpdateIdTipoUsuarioFormString = request.getParameter("IdTipoUsuario");
           
            System.out.println("VARIABLE DE EDITAR: "+UpdateIdTipoUsuarioFormString);
           int UpdateIdTipoUsuarioForm =0;
           
          if(UpdateIdTipoUsuarioFormString==null){
              System.out.println("La cadena esta vacia");
         
            }else{
              System.out.println("La cadena no esta vacia");
               UpdateIdTipoUsuarioForm=Integer.parseInt(UpdateIdTipoUsuarioFormString);
              System.out.println(UpdateIdTipoUsuarioForm);
          }
         
            String Eleccion = request.getParameter("InputValue");
            
            System.out.println("Elección: "+ Eleccion);
           //System.out.println("EditarUsuario: "+ Eleccion);
          
       if(Eleccion.equals("Insert")){
          try {
           if(InsertTipoUsuarioForm.equals("")){
                
                request.setAttribute("msg1", "Debe ingresar un nombre para el tipo de usuario a crear.");// Set error.
               
                RequestDispatcher rd = request.getRequestDispatcher("/AdminstracionTipoUsuario.jsp");
                rd.forward(request, response);
                
                //request.getRequestDispatcher("/VIEW/index.jsp").forward(request, response);
                //response.sendRedirect("VIEW/index.jsp");
                    System.out.println("SERVLET Campos vacios ha ingresado a el if de vacio");
           }else{
               
     
          // System.out.println("Resultado de la ejecución del metodo:" + "");
                
                //System.out.println("IF1");
                
                String procedureStatement = TP.InsertTipoDeUsuario(InsertTipoUsuarioForm);
               // System.out.println("SERVLET procedureStatement: " + procedureStatement);
                
                
                request.setAttribute("msg1", procedureStatement);// Set error.
                RequestDispatcher rd = request.getRequestDispatcher("/AdminstracionTipoUsuario.jsp");
                rd.forward(request, response);
                
                
                
                
                //request.getRequestDispatcher("/VIEW/index.jsp").forward(request, response);
                //response.sendRedirect("VIEW/index.jsp");
                
           }
            }catch(IOException ex){
                
            System.out.println("Exception Validaciones: "+ ex);
            
            }
        }else if(Eleccion.equals("Editar")){
         
            System.out.println("HA CAIDO EN LA ELECCION EDITAR");
            //hacer select con el ID
                
           
                //String procedureStatement = TP.SelectTipoDeUsuario(UpdateIdTipoUsuarioForm);
                
                LinkedList<TipoDeUsuario> lista = TipoDeUsuario.SelectTipoDeUsuario(UpdateIdTipoUsuarioForm);
              
                //int IdLista = lista.get(0).getId_Tipo_Usuario();
                //String nombre = lista.get(0).getTipo_Usuario();
                
               //System.out.println("id lista: "+IdLista);
               //System.out.println("NOMBRE: "+ nombre);
                
               // System.out.println("ID: "+lista.get(0).getId_Tipo_Usuario());
                //System.out.println("NOMBRE DE TIPO DE USUARIO: "+lista.get(0).getTipo_Usuario());
                
                
                //System.out.println("METODO GET: "+ TP.getTipo_Usuario());
                
              request.setAttribute("IdTipoUsuario", lista.get(0).getId_Tipo_Usuario());
              request.setAttribute("TipoDeUsuario", lista.get(0).getTipo_Usuario());
               
              //  RequestDispatcher rd = request.getRequestDispatcher("/EditarUsuario.jsp");
              //  rd.forward(request, response);
                
               request.getRequestDispatcher("/EditarUsuario.jsp").forward(request, response);
                
                
          // System.out.println("SERVLET procedureStatement: " + procedureStatement);
            
        }else if(Eleccion.equals("EditarUpdate")){

            
           String IdTipoUsuarioFormUpdateString = request.getParameter("IdTipoUsuarioFormUpdate");
           String TipoUsuarioFormUpdate = request.getParameter("TipoUsuarioFormUpdate"); 
           
           int IdTipoUsuarioFormUpdate = Integer.parseInt(IdTipoUsuarioFormUpdateString);
           System.out.println("Id de usuario: "+ IdTipoUsuarioFormUpdateString);
           System.out.println("Tipo de usuario: "+TipoUsuarioFormUpdate);
           
            String procedureStatementUpdate = TP.UpdateTipoDeUsuario(IdTipoUsuarioFormUpdate, TipoUsuarioFormUpdate);
            
            System.out.println("Se ejecuto el update!");
            // AGREGAR REDIRECION CON MENSAJE EN MODAL A ADMINISTRACION TIPO DE USUARIOS 
              request.setAttribute("msg1",procedureStatementUpdate );
              request.getRequestDispatcher("/AdminstracionTipoUsuario.jsp").forward(request, response);
            
        }else if(Eleccion.equals("Eliminar")){
            System.out.println("SE EJECUTRO LA CONDICIONAL ELIMINAR");
            
            
           String IdTipoUsuarioFormUpdateString = request.getParameter("IdTipoUsuario");
           //String TipoUsuarioFormUpdate = request.getParameter("TipoUsuarioFormUpdate"); 
           
           int IdTipoUsuarioFormUpdate = Integer.parseInt(IdTipoUsuarioFormUpdateString);
           
           System.out.println("Id de usuario: "+ IdTipoUsuarioFormUpdateString);
           //System.out.println("Tipo de usuario: "+TipoUsuarioFormUpdate);
           
            String procedureStatementUpdate = TP.DeleteTipoDeUsuario(IdTipoUsuarioFormUpdate);
            
            System.out.println("Se ejecuto el DELETE");
            // AGREGAR REDIRECION CON MENSAJE EN MODAL A ADMINISTRACION TIPO DE USUARIOS 
            request.setAttribute("msg1",procedureStatementUpdate);
            request.getRequestDispatcher("/AdminstracionTipoUsuario.jsp").forward(request, response);
            
            
        }
            
        }catch(SQLException ex){
            System.out.println("Exception Conexión de SQL: "+ ex);
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
