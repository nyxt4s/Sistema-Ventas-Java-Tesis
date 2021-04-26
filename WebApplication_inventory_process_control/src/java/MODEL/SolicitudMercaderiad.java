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
public class SolicitudMercaderiad {

    public LinkedList<SolicitudMercaderiad> getSolicitudMercaderia() {
        db_Connection xd = new db_Connection();

        LinkedList<SolicitudMercaderiad> solicitud = new LinkedList<SolicitudMercaderiad>();

        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{call SELECT_SOLICITUD_MERCADERIA()}");
            cStmt.execute();
            ResultSet ns = cStmt.getResultSet();

            while (ns.next()) {

                SolicitudMercaderiad xds = new SolicitudMercaderiad();

                xds.setIdSolicitud(ns.getInt("idSolicitud"));
                xds.setNombreProducto(ns.getString("NOMBRE"));
                xds.setNombreUsuario(ns.getString("Usuario"));
                xds.setCantidad(ns.getInt("cantidad"));
                xds.setFecha(ns.getString("fecha"));

                solicitud.add(xds);
            }
            xd.closeConnection();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return solicitud;
    }

    public void insertSolicitud(String value1, String value2, String value3) {

        db_Connection xd = new db_Connection();
        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{call INSERT_SOLICITUD_MERCADERIA(?,?,?)}");

            cStmt.setInt(1, Integer.parseInt(value1));
    
            cStmt.setInt(2, Integer.parseInt(value3));
             cStmt.setInt(3,Integer.parseInt(value2));
            cStmt.execute();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
    
    
    

    public String deleteProducto(String value1, String value2) {
        db_Connection xd = new db_Connection();

        try {
            CallableStatement cStmt = xd.getConnection().prepareCall("{call DELETE_SOLICIUTD(?,?)}");

            cStmt.setInt(1, Integer.parseInt(value1));
            cStmt.setInt(2, Integer.parseInt(value2));
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
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;

    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    private int idSolicitud;
    private int idProducto;
    private int idUsuario;
    private int cantidad;
    private String fecha;
    private String nombreProducto;
    private String nombreUsuario;

}
