/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author NYXTH
 */

public class Marca {

    public String insertMarca(String value1) {
        
        db_Connection xd = new db_Connection();
        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL INSERT_BRAND(?)}");
            
            cStmt.setString(1, value1);

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

    public LinkedList<Marca> updateMarca(String value1, String value2) {
        
        db_Connection xd = new db_Connection();
        
        try {
            
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL UPDATE_BRAND (?,?)}");
            
            cStmt.setInt(1, Integer.parseInt(value1));
            cStmt.setString(2, value2);

            boolean hadResults = cStmt.execute();
            if (hadResults) {
                System.out.println("informacion guardada");

            } else {
                
                System.out.println("error 2");

            }
            xd.closeConnection();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }

        return null;
    }
    
    
     public static LinkedList <Marca> getMarca() {
        db_Connection xd = new db_Connection();
        
         LinkedList<Marca> Marcas = new LinkedList <Marca>();
        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL SELECT_BRAND ()}");
            
            cStmt.execute();
            ResultSet ns = cStmt.getResultSet();
           
            while (ns.next()) {     
              Marca xds =  new Marca(); 
               xds.setIdMarca(ns.getInt("ID_Marca"));  
              xds.setNombreMarca(ns.getString("Marca"));  
              Marcas.add(xds);
            }
            
            xd.closeConnection();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return Marcas;
    }
   
         public static LinkedList <Marca> getMarca2(int value1) {
        db_Connection xd = new db_Connection();
        
         LinkedList<Marca> Marcas = new LinkedList <Marca>();
        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL SELECT_MARCA2 (?)}");
            cStmt.setInt(1, value1);
            cStmt.execute();
            ResultSet ns = cStmt.getResultSet();
           
            while (ns.next()) {     
              Marca xds =  new Marca(); 
               xds.setIdMarca(ns.getInt("ID_Marca"));  
              xds.setNombreMarca(ns.getString("Marca"));  
              Marcas.add(xds);
            }
            
            xd.closeConnection();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return Marcas;
    }
     
   
     
     public String deleteMarca(String value1){
        db_Connection xd = new db_Connection();
        
    try {
             CallableStatement cStmt = xd.getConnection().prepareCall("{CALL DELETE_BRAND(?)}");
           
             cStmt.setInt(1, Integer.parseInt (value1));
                 
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
     
     
     
     

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombrePruducto) {
        this.nombreMarca = nombrePruducto;
    }


    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    private int idMarca ;
    
    private String nombreMarca;
}
