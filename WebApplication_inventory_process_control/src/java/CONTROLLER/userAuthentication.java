/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Usuario;
import static MODEL.Usuario.getSHA;
import static MODEL.Usuario.toHexString;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author claud
 */
public class userAuthentication extends HttpServlet {

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
            throws ServletException, IOException, SQLException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         
            Usuario user = new Usuario();
            String usernameForm = request.getParameter("username");    
            String passwordForm = request.getParameter("password");
            int ID_USUARIO = 0;
            int TipoDeUsuario=0;
            
            
            
            try{
                if(usernameForm == null||passwordForm == null){
                
                request.setAttribute("msg", "Debe ingersar un nombre de usuario y una contrañesa");// Set error.
               // request.setAttribute("username", usernameForm);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
                //request.getRequestDispatcher("/VIEW/index.jsp").forward(request, response);
                //response.sendRedirect("VIEW/index.jsp");
                    System.out.println("Campos vacios");
               
            }
            }catch(Exception e){
                
            }
            

            try {
                System.out.println("Password: "+ passwordForm);
            passwordForm = toHexString(getSHA(passwordForm));
            
                System.out.println("Password SHA-256: "+ passwordForm);
            user.authenticacionDeUsuario(usernameForm, passwordForm);
            
            String usernameSQL = user.getUsernameRS();
            String passwordSQL  = user.getPasswordRS();
            
            if(!usernameForm.equals(usernameSQL)||!passwordForm.equals(passwordSQL)){
                //System.out.println("IF1");
                  System.out.println("Usuario o contraseña invalidos");
                  
                  
                request.setAttribute("msg", "Nombre de usuario y/o contraseña inválido");// Set error.
                request.setAttribute("usuario",usernameForm);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
                //request.getRequestDispatcher("/VIEW/index.jsp").forward(request, response);
                //response.sendRedirect("VIEW/index.jsp");
              
               
            }
            else if (usernameForm.equals(usernameSQL) && passwordForm.equals(passwordSQL)){
               // System.out.println("IF2");
                System.out.println("Usuario y contraseñas correctas");
           
             /**HttpSession misesion = request.getSession(true);
             
             misesion.setAttribute("ID_USUARIO",ID_USUARIO);
             misesion.setAttribute("USERNAME",usuario);
             misesion.setAttribute("TIPO_DE_USUARIO",TipoDeUsuario);**/
             
             /** Asignación de atributos de session**/
             HttpSession misesion = request.getSession(true);
             misesion.setAttribute("Id_Usuario",user.getId_Usuario());
             misesion.setAttribute("username",user.getUsernameRS());
             misesion.setAttribute("Tipo_Usuario",user.getTipo_Usuario());
             misesion.setAttribute("IdLocal",user.getId_Local());
             
                //System.out.println("Id_Local: "+ user.getId_Local());
                //System.out.println("Id_Tipo_Usuario: "+ user.getId_Tipo_Usuario());
                
             request.setAttribute("username", usernameForm);
             RequestDispatcher rd = request.getRequestDispatcher("Principal.jsp");
             rd.forward(request, response);
             
           
           }else{ 
               response.sendRedirect("index.jsp");
            
            
           } 
            }catch(IOException ex){
                
            System.out.println("Exception Validaciones: "+ ex);
            
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(userAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(userAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(userAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(userAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        }
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
