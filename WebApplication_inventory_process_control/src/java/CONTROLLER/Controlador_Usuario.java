/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;


import MODEL.Usuario;
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
public class Controlador_Usuario extends HttpServlet {

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
        
            Usuario user = new Usuario();
            
            
      /* 1*/String Rutform = request.getParameter("Rutform");
            String Digitoverificadorform = request.getParameter("Digitoverificadorform");
            String Nombreform = request.getParameter("Nombreform");
            String Apellidopform = request.getParameter("Apellidopform");
            String Apellidomform = request.getParameter("Apellidomform");
            String Direccionform = request.getParameter("Direccionform");
            String Nombreuform = request.getParameter("Nombreuform");
            String Contrasenaform = request.getParameter("Contrasenaform");
            String Numerotform = request.getParameter("Numerotform");
            String Correoeform = request.getParameter("Correoeform"); 
            String Tipouform = request.getParameter("Tipouform");
     /* 12*/String Localtform = request.getParameter("Localtform");
            String TipoNumeroTelefonicoform = request.getParameter("TipoNumeroTelefonicoform");
            String TipoCorreoElectronicoform = request.getParameter("TipoCorreoElectronicoform");
            
          
            
            System.out.println("INICIO");
            System.out.println(Rutform);
            System.out.println(Digitoverificadorform);
            System.out.println(Nombreform);
            System.out.println(Apellidopform);
            System.out.println(Apellidomform);
            System.out.println(Direccionform);
            System.out.println(Numerotform);
            System.out.println(Correoeform);
            System.out.println(Nombreuform);
            System.out.println(Contrasenaform);
            System.out.println(Tipouform);
            System.out.println(Localtform);  
            System.out.println(TipoNumeroTelefonicoform);
            System.out.println(TipoCorreoElectronicoform);
            System.out.println("FIN");
            
           int RutformS = 0;
           int NumerotformS = 0;
           int TipouformS = 0;
           int LocaltformS = 0;
           int TipoNumeroTelefonicoformS = 0;
           int TipoCorreoElectronicoformS = 0;
           
             
           
          if(Rutform==null ){
              System.out.println("La cadena esta vacia");
         
            }else{
              System.out.println("La cadena no esta vacia");
              
              // Se parsean las variables traidas del formulario de tipo string a INT
               RutformS=Integer.parseInt(Rutform);
               NumerotformS=Integer.parseInt(Numerotform);
               TipouformS=Integer.parseInt(Tipouform);
               LocaltformS=Integer.parseInt(Localtform);
               TipoNumeroTelefonicoformS=Integer.parseInt(TipoNumeroTelefonicoform);
               TipoCorreoElectronicoformS=Integer.parseInt(TipoCorreoElectronicoform);
               

              
          }
          
          
            // Obtencion de valor de boton de cada formulario
            String Eleccion = request.getParameter("InputValue");
            
            // Se imprime por pantalla el valor del boton seleccionado (INSERT,EDIT,UPDATE,DELETE)
            System.out.println("Elección: "+ Eleccion);

            if(Eleccion==null){
                Eleccion ="SinEleccion";
                System.out.println("Eleccion: "+ Eleccion);
            }
            switch (Eleccion) {
                case "Insert":
                    try {
                        /* if(InsertTipoUsuarioForm.equals("")){
                        
                        request.setAttribute("msg1", "Debe ingresar un nombre para el tipo de usuario a crear.");// Set error.
                        
                        RequestDispatcher rd = request.getRequestDispatcher("/AdminstracionTipoUsuario.jsp");
                        rd.forward(request, response);
                        
                        //request.getRequestDispatcher("/VIEW/index.jsp").forward(request, response);
                        //response.sendRedirect("VIEW/index.jsp");
                        System.out.println("SERVLET Campos vacios ha ingresado a el if de vacio");
                        }else{*/
                        
                        
                        // System.out.println("Resultado de la ejecución del metodo:" + "");
                        
                        //System.out.println("IF1");
                        
                  
                        // System.out.println("SERVLET procedureStatement: " + procedureStatement);
                        
                        String procedureStatement = user.InsertDeUsuario
                        (RutformS,
                        Digitoverificadorform,
                        Nombreform,
                        Apellidopform,
                        Apellidomform,
                        Direccionform,
                        Nombreuform,
                        Contrasenaform,
                        NumerotformS,
                        Correoeform,
                        TipouformS,
                        LocaltformS,
                        TipoNumeroTelefonicoformS,
                        TipoCorreoElectronicoformS);
                        
                        request.setAttribute("msg1", procedureStatement);// Set error.
                        RequestDispatcher rd = request.getRequestDispatcher("/AdministracionDeUsuarios.jsp");
                        rd.forward(request, response);
                        
                        
                        
                        
                        //request.getRequestDispatcher("/VIEW/index.jsp").forward(request, response);
                        //response.sendRedirect("VIEW/index.jsp");
                        
                        /* }*/
                    }catch(IOException ex){
                        
                        System.out.println("Exception Validaciones: "+ ex);
                        
                    } break;
            /**
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
             **/
                case "Editar":
                    break;
            /**
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
             **/
                case "EditarUpdate":
                    break;
            /**
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
             **/
                case "Eliminar":
             String IdUsuario = request.getParameter("IdUsuario");
             int IdUsuarioINT = Integer.parseInt(IdUsuario);
             
            System.out.println("Id de usuario: "+ IdUsuarioINT);
           //System.out.println("Tipo de usuario: "+TipoUsuarioFormUpdate);
           
            String procedureStatementUpdate = user.DeleteUsuario(IdUsuarioINT);
            System.out.println("Se ejecuto el DELETE");
            // AGREGAR REDIRECION CON MENSAJE EN MODAL A ADMINISTRACION TIPO DE USUARIOS 
            
            request.setAttribute("msg1",procedureStatementUpdate);
            request.getRequestDispatcher("/AdministracionDeUsuarios.jsp").forward(request, response);
                    
                    
                    break;
                    
                case "SinEleccion":
                     response.sendRedirect("/WebApplication_inventory_process_control/AdministracionDeUsuarios.jsp");
                    break;
                default:
                  
                    break;
            
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
