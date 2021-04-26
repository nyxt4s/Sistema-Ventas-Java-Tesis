/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author claud
 */
public class db_Connection {
    
    
    private static Connection conn;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    //Dentro de la variable user se debre ingresar el nombre de usuario utilziado en MySql WorkBench
    private static final String user = "DBA"; 
     //Dentro de la variable password se debre ingresar el nombre de usuario utilziado en MySql WorkBench
    private static final String password = "159159159-.-";
    private static final String dbName = "DB_APPWEB_INVENTORYPROCESSCONTROL";
    private static final String url = "jdbc:mysql://localhost:3306/"+dbName+"?serverTimezone=UTC";
   

    public db_Connection() {
        // Se inicializa la variable en null
        conn = null;
        
        // Se crea un try - catch para atrapar posibles excepciones / errores y asi poder manejarlos de distintas formas
        try{
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("La conexión se ha establecido correctamente");
            }
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("No se ha podido establecer la conexión");
            System.out.println("Motivo: "+ e);
        
        }    
    }
    
    // Metodo el cual retorna la conexión a la base de datos
    public Connection getConnection(){
        return conn;
    }
    
    
    // Metodo para cerrar la conexión a la base de datos
    public void closeConnection(){
        conn = null;
        if(conn == null){
            System.out.println("La conexión se ha cerrado");
        }
    }
    
    public void closeResultSetStatement(ResultSet rs, Statement ps) 
{ 
    if (rs!=null) 
    { 
     try 
     { 
      rs.close(); 

     } 
     catch(SQLException e) 
     { 
     
         System.out.println("The result set cannot be closed: "+e);
     } 
    } 
    if (ps != null) 
    { 
     try 
     { 
      ps.close(); 
     } catch (SQLException e) 
     { 
    
        System.out.println("The statement cannot be closed: "+e);
     } 
    } 
} 
    
    
    
    //Clase main para probar conexión a base de datos
    public static void main(String[] args){
        db_Connection db = new db_Connection ();
        db.getConnection();
        db.closeConnection();
        
    }
      
    
}

