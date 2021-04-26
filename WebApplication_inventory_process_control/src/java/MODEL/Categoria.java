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
public class Categoria {

        public static LinkedList <Categoria> getCategory() {
            db_Connection xd = new db_Connection();

            LinkedList<Categoria> categorys = new LinkedList<Categoria>();
            try {
                CallableStatement cStmt = xd.getConnection().prepareCall("{CALL SELECT_CATEGORY ()}");

                cStmt.execute();
                ResultSet ns = cStmt.getResultSet();

                while (ns.next()) {
                    Categoria xds = new Categoria();
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

              public static LinkedList <Categoria> getCategory2(int value1) {
            db_Connection xd = new db_Connection();

            LinkedList<Categoria> categorys = new LinkedList <Categoria>();
            
            try {
                CallableStatement cStmt = xd.getConnection().prepareCall("{CALL SELECT_CATEGORY2 (?)}");
                cStmt.setInt(1, value1);
                cStmt.execute();
                ResultSet ns = cStmt.getResultSet();
                Categoria xds = new Categoria();
                while (ns.next()) {
                    
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
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL INSERT_CATEGORY(?)}");
            
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

    public  static LinkedList<Categoria> updateCategoria(String value1, String value2) {
        
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
     public String deleteCategoria(String value1){
        db_Connection xd = new db_Connection();
        
    try {
             CallableStatement cStmt = xd.getConnection().prepareCall("{CALL DELETE_CATEGORY(?)}");
           
             cStmt.setString(1, value1);
                 
             boolean hadResults = cStmt.execute();
            xd.closeConnection();
    
            
            if (hadResults) {
                System.out.println("informacion Eliminada");
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
