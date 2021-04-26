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
public class Local {

    public String insertLocal(String value1, String value2, String value3, String value4) {

        db_Connection xd = new db_Connection();

        try {

            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL INSERT_LOCAL (?,?,?,?)}");

            cStmt.setInt(1, Integer.parseInt(value1));
            cStmt.setString(2, value2);
            cStmt.setString(3, value3);
            cStmt.setString(4, value4);

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

    public LinkedList<Local> updatelocal(String value1, String value2, String value3, String value4) {

        db_Connection xd = new db_Connection();

        try {

            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL UPDATE_LOCAL (?,?,?,?)}");
            cStmt.setInt(1, Integer.parseInt(value1));
            cStmt.setInt(2, Integer.parseInt(value2));
            cStmt.setString(3, value3);
            cStmt.setString(4, value4);

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

    public static LinkedList<Local> getLocal() {
        db_Connection xd = new db_Connection();

        LinkedList<Local> Locales = new LinkedList<Local>();
        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL SELECT_LOCAL ()}");

            cStmt.execute();
            ResultSet ns = cStmt.getResultSet();

            while (ns.next()) {
                Local xds = new Local();
                xds.setId_local(ns.getInt("Id_Local"));
                xds.setRut(ns.getInt("Rut"));
                xds.setDigito_verificardor(ns.getString("Digito_Verificador"));
                xds.setRazon_Social(ns.getString("Razon_Social"));
                xds.setNombre_comercial(ns.getString("Nombre_Comercial"));
                Locales.add(xds);
            }

            xd.closeConnection();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return Locales;
    }

    public static LinkedList<Local> getLocal2(int value1) {
        db_Connection xd = new db_Connection();

        LinkedList<Local> Locales = new LinkedList<Local>();
        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{CALL SELECT_LOCAL_ID (?)}");
            
            cStmt.setInt(1, value1);
            
            cStmt.execute();
            ResultSet ns = cStmt.getResultSet();

            while (ns.next()) {
                
                Local xds = new Local();
                xds.setId_local(ns.getInt("Id_Local"));
                xds.setRut(ns.getInt("Rut"));
                xds.setDigito_verificardor(ns.getString("Digito_Verificador"));
                xds.setRazon_Social(ns.getString("Razon_Social"));
                xds.setNombre_comercial(ns.getString("Nombre_Comercial"));
                Locales.add(xds);
            }

            xd.closeConnection();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return Locales;
    }

    public String deleteLocal(String value1) {
        db_Connection xd = new db_Connection();

        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{call DELETE_LOCAL(?)}");
            int valor2 = Integer.parseInt(value1);
            cStmt.setInt(1, valor2);

            boolean hadResults = cStmt.execute();
            xd.closeConnection();

            if (hadResults) {
                System.out.println("informacion eliminada");
                return "Data sended";
            } else {
                System.out.println("error 2");
                return "error";
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;

    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDigito_verificardor() {
        return digito_verificardor;
    }

    public void setDigito_verificardor(String digito_verificardor) {
        this.digito_verificardor = digito_verificardor;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getRazon_Social() {
        return Razon_Social;
    }

    public void setRazon_Social(String Razon_Social) {
        this.Razon_Social = Razon_Social;
    }

    private String Razon_Social;
    private int id_local;
    private int rut;
    private String digito_verificardor;
    private String nombre_comercial;

}
