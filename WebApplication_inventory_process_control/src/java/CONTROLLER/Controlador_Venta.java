/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Inventario;
import MODEL.Producto;
import MODEL.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author claud
 */
public class Controlador_Venta extends HttpServlet {
//Producto pr = new Producto ();
Inventario Inventario = new Inventario();
Venta V = new Venta();

List <Venta> lista = new ArrayList <>();
int Item;
String CodBarras;
String Nombre;
int Imagen;
String Marca;
String Categoria;
int PrecioCosto;
int PrecioVenta;
int Cantidad;
int Subtotal;
int Total;
int IdInventario;

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
            
            //Se obtiene la accion elegida por el usuario a traves de la variable InputValue
            String Eleccion = request.getParameter("InputValue");
            System.out.println("se ejecuto el servlet");
            
            switch (Eleccion) {
                
                case "BuscarProducto":
                    System.out.println("Se ha seleccionado Buscar Producto");
                   String CodigoDeBarras =request.getParameter("CodigoProducto");
                           // System.out.println(CodigoDeBarras);
                   Inventario = Inventario.BuscarProductoPorInventarioID(CodigoDeBarras);
                    
                    System.out.println("Nombre del producto: "+Inventario.getNombre());
                    
                   request.setAttribute("Invent", Inventario);
                   request.setAttribute("lista", lista);
                   
                   request.getRequestDispatcher("RealizarVenta.jsp").forward(request, response);
                    break;
                    
                case "AgregarProducto":
                    Total=0;
                    Item = Item +1;
                    CodBarras = Inventario.getCodigo_de_Barras();
                    Nombre= request.getParameter("NombreProducto");
                    Marca = Inventario.getMarca();
                    Categoria = Inventario.getCategoria();
                    PrecioVenta =Integer.parseInt(request.getParameter("PrecioVenta"));
                    PrecioCosto = Inventario.getPrecio_Costo();
                    Cantidad= Integer.parseInt(request.getParameter("CantidadProductos"));
                    Subtotal= PrecioVenta*Cantidad;
                    IdInventario= Inventario.getId_Inventario();
                    System.out.println(CodBarras);
                    System.out.println(Nombre);
                    
                    V=new Venta();
                    
                    V.setItem(Item);
                    V.setCodigo_de_Barras(CodBarras);
                    V.setNombre(Nombre);
                    V.setMarca(Marca);
                    V.setCategoria(Categoria);
                    V.setPrecioVenta(PrecioVenta);
                    V.setPrecioCosto(PrecioCosto);
                    V.setCantidad(Cantidad);
                    V.setSubTotal(Subtotal);
                    V.setIdinventario(IdInventario);
                    
                    lista.add(V);
                    for (int i = 0; i < lista.size(); i++) {
                        Total=Total+lista.get(i).getSubTotal();
                    }
                    request.setAttribute("Total",Total);
                    request.setAttribute("lista", lista);
                    
                    
                   request.getRequestDispatcher("RealizarVenta.jsp").forward(request, response);
                    break;
                case "Generar Venta":
                    /** GUARDAR VENTA**/
                    V.setId_Usuario(7);
                    V.setTotalVenta(Total);
                    V.guardarVenta(V);
                    
                    /** GUARDAR DETALLE DE VENTA **/
                    System.out.println("Id de inventario: "+ Inventario.getId_Inventario());
                    System.out.println("Id Venta: "+ V.IdVenta());
                    
                    int idv=Integer.parseInt(V.IdVenta());
                    for (int i = 0; i < lista.size(); i++) {
                        V=new Venta();
                        V.setID(idv);
                        V.setCantidad(lista.get(i).getCantidad());
                        V.setPrecioCosto(lista.get(i).getPrecioCosto());
                        V.setPrecioVenta(lista.get(i).getPrecioVenta());
                        V.setIdinventario(lista.get(i).getIdinventario());
                        V.guardarDetalleVenta(V);
                   
                    }
                    
                    System.out.println("La lista antes de borrar contiene "+lista.size()+" elementos");
                    System.out.println("La variable Item tiene como contenido: "+Item);
                    lista.clear();
                    Item=0;
                    
                    System.out.println("La lista despues de borrar elementos contiene "+lista.size()+" elementos");
                    System.out.println("La variable Item despues de borrar su contenido tiene como valor: "+Item);
                    
                    request.setAttribute("msg1", "Venta realizada");
                    request.getRequestDispatcher("RealizarVenta.jsp").forward(request, response);
                break;
                
                case "Eliminar":
                      String IdItem = request.getParameter("IdItem");
                    
                       lista.remove(IdItem);
                               
                        break;
                        
                case "Cancelar":
                     lista.clear();
                        Item=0;                    
                request.getRequestDispatcher("RealizarVenta.jsp").forward(request, response);
                        break;
                        
                case "ActualizarStock":
                    Inventario I = new Inventario();
                    
                try {
                     String CodigoBarras =request.getParameter("CodigoBarras");   
                     String CantidadStockADDs =request.getParameter("CantidadStock");  
                      
            if(CodigoBarras.equals("") || CantidadStockADDs.equals("")){
                         
                  
                
                request.setAttribute("msg1", "Debe ingresar el codigo de barras de un producto y/o la cantidad de stock ");// Set error.
               
                RequestDispatcher rd = request.getRequestDispatcher("/Inventario.jsp");
                rd.forward(request, response);
                
                //request.getRequestDispatcher("/VIEW/index.jsp").forward(request, response);
                //response.sendRedirect("VIEW/index.jsp");
                    System.out.println("SERVLET Campos vacios ha ingresado a el if de vacio");
             }else{
                int CantidadStockADD = Integer.parseInt(CantidadStockADDs);                         
               
                String procedureStatement = I.AddCantidadSock(CodigoBarras, CantidadStockADD);
                System.out.println("msg : "+ procedureStatement);
                request.setAttribute("msg1", procedureStatement);// Set error.
                RequestDispatcher rd = request.getRequestDispatcher("/Inventario.jsp");
                rd.forward(request, response);
                
                
           }                
            }catch(SQLException ex){
                
            System.out.println("Exception Validaciones: "+ ex);
            
            }
                        break;
                
                default:
                     // request.getRequestDispatcher("RealizarVenta.jsp").forward(request, response);
                    throw new AssertionError();
            }
              //request.getRequestDispatcher("RealizarVenta.jsp").forward(request, response);
            
     
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
