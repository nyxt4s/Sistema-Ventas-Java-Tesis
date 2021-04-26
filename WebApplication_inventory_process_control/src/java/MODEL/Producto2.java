
package MODEL;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author NYXTH
 */
public class Producto2 {

    //Agregar
    public void insertProducto(String value1, String value2, String value3, String value4)  {
       
        db_Connection xd = new db_Connection();
        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{call INSERT_PRODUCT(?,?,?,?)}");

            cStmt.setString(1, value1);
            cStmt.setString(2, value2);
            cStmt.setInt(3, Integer.parseInt(value3));
            cStmt.setInt(4, Integer.parseInt(value4));
             cStmt.execute();
              
              
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
    }

    
    
     //Obtener los proveedores
    public LinkedList <Producto2> getProduct() {
        db_Connection xd = new db_Connection();
        
         LinkedList<Producto2> Productos = new LinkedList <Producto2>();
         
        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{call select_product()}");
            cStmt.execute();
            ResultSet ns = cStmt.getResultSet();
            
            while (ns.next()) {
              
              Producto2 xds =  new Producto2(); 
              xds.setIdProducto(ns.getInt("Id_Producto"));  
              xds.setCodigoBarra(ns.getString("Codigo_de_Barras"));  
              xds.setNombre(ns.getString("Nombre"));
              xds.setMarca(ns.getString("Categoria"));  
              xds.setCategoria( ns.getString("marca"));
          
              
              Productos.add(xds);
            }
            xd.closeConnection();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return Productos;
    }
    
      public static LinkedList <Producto2> getProducto2(int value1) {
        db_Connection xd = new db_Connection();
        
         LinkedList<Producto2> Productos = new LinkedList <Producto2>();
        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL SELECT_PRODUCT2 (?)}");
            cStmt.setInt(1, value1);
            cStmt.execute();
            ResultSet ns = cStmt.getResultSet();
           
            while (ns.next()) {     
              Producto2 xds =  new Producto2(); 
              xds.setIdProducto(ns.getInt("Id_Producto"));  
              xds.setCodigoBarra(ns.getString("Codigo_de_Barras"));  
              xds.setNombre(ns.getString("Nombre"));  
              xds.setCategoria(ns.getString("Categoria"));  
              xds.setMarca(ns.getString("marca"));  
              Productos.add(xds);
            }
            
            xd.closeConnection();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return Productos;
    }
    
    
    
    
    
    public void insertProduct(){
        
         db_Connection xd = new db_Connection();

        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{ call insert_product (?,?,?,?,?)}");
            
            
            
            cStmt.execute();
            ResultSet ns = cStmt.getResultSet();

        }catch(Exception ex){
        }
        
        
        
    }
            public String deleteProducto (String value1){
        db_Connection xd = new db_Connection();
        
   
    try {
             CallableStatement cStmt = xd.getConnection().prepareCall("{call DELETE_PRODUCT(?)}");
           
             cStmt.setInt(1, Integer.parseInt(value1));
                 
             boolean hadResults = cStmt.execute();
            xd.closeConnection();
    
            
            if (hadResults) {
                System.out.println("informacion guardada");
                return "Data sended";
            } else {
                System.out.println("error 2");
                return "error";
            }
            
    }catch (SQLException ex){
           System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
    }
        return null;
        
        
        
        
    }
            
            public void updateProducto (String value1, String value4, String value5, String value6, String value7){
                db_Connection xd = new db_Connection(); 
                try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL UPDATEPRODUCTO (?,?,?,?,?)}");
            cStmt.setInt(1, Integer.parseInt(value1));
            cStmt.setString(2, value4);
            cStmt.setString(3, value5);
            cStmt.setInt(4, Integer.parseInt(value6));
            cStmt.setInt(5, Integer.parseInt(value7));
          
               boolean hadResults = cStmt.execute();
                if (hadResults) {
                System.out.println("informacion guardada");
            
            } else {
                System.out.println("error 2");
            
            }
                  xd.closeConnection();
                  
                  
                  
                }catch(SQLException ex){
                        System.out.println("SQLException: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("VendorError: " + ex.getErrorCode());

                }
                }
    
    
    
    
    
    
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
   
    private int idProducto;
    private String codigoBarra;
    private String nombre;

    private String categoria;
    private String marca;

}
