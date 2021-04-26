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
 * @author claud
 */
public class CategoriaOLD {
   public static LinkedList <CategoriaOLD> getCategoria() {
            db_Connection xd = new db_Connection();

            LinkedList<CategoriaOLD> categorys = new LinkedList<CategoriaOLD>();
            
            try {
                CallableStatement cStmt = xd.getConnection().prepareCall("{CALL p_CategoriaSelect ()}");

                cStmt.execute();
                ResultSet ns = cStmt.getResultSet();

                while (ns.next()) {
                    CategoriaOLD xds = new CategoriaOLD();
                    xds.setIdcategoria(ns.getInt("ID_Categoria"));
                    xds.setNombreCategoria(ns.getString("Categoria"));
                    categorys.add(xds);
                }

                xd.closeConnection();
            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            return categorys;
    }

        
    public String insertCategoria(String value1) {
        
        db_Connection xd = new db_Connection();
        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL p_categoriaIns(?)}");
            
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

    public LinkedList<CategoriaOLD> updateCategoria(String value1, String value2) {
        
        db_Connection xd = new db_Connection();
        
        try {
            
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL UPDATE_CATEGORY (?,?)}");
            int value3 = Integer.parseInt(value1);
            
            cStmt.setInt(1, value3);
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
     public String deleteCategoria(int IdCategoria){
        db_Connection xd = new db_Connection();
        
    try {
             CallableStatement cStmt = xd.getConnection().prepareCall("{CALL p_CategoriaDelete(?)}");
           
             cStmt.setInt(1, IdCategoria);
                 
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
        
        
        
    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }


    private int idcategoria;
    private String nombreCategoria;
}
