/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import MODEL.db_Connection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author NYXTH
 */
public class Proveedor {

    
    //Agregar
    public String insertProveedor(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8) {
        db_Connection xd = new db_Connection();
        try {

                CallableStatement cStmt = xd.getConnection().prepareCall("{call INSERT_PROVIDE(?,?,?,?,?,?,?,?)}");
            cStmt.setInt(1, Integer.parseInt(value1));
            cStmt.setInt(2, Integer.parseInt(value2));
            cStmt.setString(3, value3);
            cStmt.setString(4, value4);
            cStmt.setString(5, value5);
            cStmt.setString(6, value6);
            cStmt.setString(7, value7);
            cStmt.setString(8, value8);
            boolean hadResults = cStmt.execute();
            xd.closeConnection();
            if (hadResults) {
                System.out.println("informacion guardada");
                return "Data sended";
            } else {
                System.out.println("error 2");
                return "error";
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }
    
    
    //Modificar Proveedor
    public LinkedList <Proveedor> updateProveedor (String value1, String value4, String value5, String value6, String value7, String value8, String value9){
    db_Connection xd = new db_Connection(); 
    try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL UPDATE_PROVIDE (?,?,?,?,?,?,?)}");
            cStmt.setInt(1, Integer.parseInt(value1));
            cStmt.setString(2, value4);
            cStmt.setString(3, value5);
            cStmt.setString(4, value6);
            cStmt.setString(5, value7);
            cStmt.setString(6, value8);
            cStmt.setString(7, value9);
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
   
    return null;
    }
    
    
    
    //Obtener los proveedores
    public static LinkedList <Proveedor> getProveedor() {
        db_Connection xd = new db_Connection();
        
         LinkedList<Proveedor> proveedores = new LinkedList <Proveedor>();
         
        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{call SELECT_PROVIDE ()}");
            cStmt.execute();
            ResultSet ns = cStmt.getResultSet();
            
            while (ns.next()) {
              Proveedor xds =  new Proveedor(); 
              xds.setId_Proveedor(ns.getInt("ID_Proveedor"));  
              xds.setRut(ns.getInt("Rut"));  
              xds.setDigito_Verificador(ns.getInt("Digito_Verificador")); 
              xds.setNombres(ns.getString("Nombres"));  
              xds.setApellido_P(ns.getString("Apellido_P"));  
              xds.setApellido_M(ns.getString("Apellido_M"));  
              xds.setDireccion( ns.getString("Direccion"));
              xds.setRazon_Social(ns.getString("Razon_Social"));  
              xds.setNombre_Comercial(ns.getString("Nombre_Comercial"));  
              
              proveedores.add(xds);
            }
            xd.closeConnection();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return proveedores;
    }
    
         public static LinkedList <Proveedor> getProveedor2(int value1) {
            db_Connection xd = new db_Connection();

            LinkedList<Proveedor> proveedores = new LinkedList <Proveedor>();
            
            try {
                CallableStatement cStmt = xd.getConnection().prepareCall("{CALL SELECT_PROVIDE2 (?)}");
                cStmt.setInt(1, value1);
                cStmt.execute();
                ResultSet ns = cStmt.getResultSet();
                Proveedor xds =  new Proveedor(); 
                
                
                while (ns.next()) {
                    
                        xds.setId_Proveedor(ns.getInt("ID_Proveedor"));  
                        xds.setRut(ns.getInt("Rut"));  
                        xds.setDigito_Verificador(ns.getInt("Digito_Verificador")); 
                        xds.setNombres(ns.getString("Nombres"));  
                        xds.setApellido_P(ns.getString("Apellido_P"));  
                        xds.setApellido_M(ns.getString("Apellido_M"));  
                        xds.setDireccion( ns.getString("Direccion"));
                        xds.setRazon_Social(ns.getString("Razon_Social"));  
                        xds.setNombre_Comercial(ns.getString("Nombre_Comercial"));  
                    proveedores.add(xds);
                }

                xd.closeConnection();
            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            return proveedores;
         }


    
    
    
    public String DeletProveedor(String value1){
        db_Connection xd = new db_Connection();
        
   
    try {
             CallableStatement cStmt = xd.getConnection().prepareCall("{call Delete_Provide(?)}");
           
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int getRut() {
        return Rut;
    }

    public void setRut(int Rut) {
        this.Rut = Rut;
    }

    public int getDigito_Verificador() {
        return Digito_Verificador;
    }

    public void setDigito_Verificador(int Digito_Verificador) {
        this.Digito_Verificador = Digito_Verificador;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellido_P() {
        return Apellido_P;
    }

    public void setApellido_P(String Apellido_P) {
        this.Apellido_P = Apellido_P;
    }

    public String getApellido_M() {
        return Apellido_M;
    }

    public void setApellido_M(String Apellido_M) {
        this.Apellido_M = Apellido_M;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getRazon_Social() {
        return Razon_Social;
    }

    public void setRazon_Social(String Razon_Social) {
        this.Razon_Social = Razon_Social;
    }

    public String getNombre_Comercial() {
        return Nombre_Comercial;
    }

    public void setNombre_Comercial(String Nombre_Comercial) {
        this.Nombre_Comercial = Nombre_Comercial;
    }

    public int getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(int id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }
    
    private int id_Proveedor;
      private int Rut;
    private int Digito_Verificador;
    private String Nombres;
    private String Apellido_P;
    private String Apellido_M;
    private String Direccion;
    private String Razon_Social;
    private String Nombre_Comercial;

}
