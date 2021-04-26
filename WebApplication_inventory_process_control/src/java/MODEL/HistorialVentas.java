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
public class HistorialVentas {
    
                        public static LinkedList <HistorialVentas> getHistorial() {
                          db_Connection xd = new db_Connection();

                           LinkedList<HistorialVentas> Marcas = new LinkedList <HistorialVentas>();
                          try {
                              
                              CallableStatement cStmt = xd.getConnection().prepareCall("{CALL SELECT_HISTORIAL_VENTA ()}");

                              cStmt.execute();
                              ResultSet ns = cStmt.getResultSet();

                              while (ns.next()) {     
                                HistorialVentas xds =  new HistorialVentas(); 
                                xds.setIdVenta(ns.getInt("id_venta"));  
                                xds.setUsuario(ns.getString("usuario"));  
                                xds.setNombreComercial(ns.getString("nombre_comercial"));
                                xds.setTotalventa(ns.getInt("Total_venta")); 
                                xds.setFecha(ns.getString("Fecha")); 
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
   
                
                        
                        
                        
                        

                            public int getIdVenta() {
                                return idVenta;
                            }

                            public void setIdVenta(int idVenta) {
                                this.idVenta = idVenta;
                            }

                            public String getFecha() {
                                return fecha;
                            }

                            public void setFecha(String fecha) {
                                this.fecha = fecha;
                            }

                            public int getTotalventa() {
                                return totalventa;
                            }

                            public void setTotalventa(int totalventa) {
                                this.totalventa = totalventa;
                            }

                            public String getUsuario() {
                                return usuario;
                            }

                            public void setUsuario(String usuario) {
                                this.usuario = usuario;
                            }

                            public String getNombreComercial() {
                                return nombreComercial;
                            }

                            public void setNombreComercial(String nombreComercial) {
                                this.nombreComercial = nombreComercial;
                            }
                        
                        
                        private int idVenta;
                        private String fecha;
                        private int totalventa;
                        private String usuario;
                        private String nombreComercial;
                        
}
