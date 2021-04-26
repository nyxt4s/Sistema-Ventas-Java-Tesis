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
public class TipoDeUsuario {
    
    private int Id_Tipo_Usuario;
    private String Tipo_Usuario;

 

    public int getId_Tipo_Usuario() {
        return Id_Tipo_Usuario;
    }

    public void setId_Tipo_Usuario(int Id_Tipo_Usuario) {
        this.Id_Tipo_Usuario = Id_Tipo_Usuario;
    }

    public String getTipo_Usuario() {
        return Tipo_Usuario;
    }

    public void setTipo_Usuario(String Tipo_Usuario) {
        this.Tipo_Usuario = Tipo_Usuario;
    }
    
    
    
    public static LinkedList<TipoDeUsuario> getTipoDeUsuario() throws SQLException{
        //Se instancia una objeto de tipo LinkedList <TipoDeUsuario>
            //List<String> ListTipoUsuarios = new ArrayList<>();
        LinkedList<TipoDeUsuario> listaTipoDeUsuario = new LinkedList<TipoDeUsuario>();
        
        //Se instancia una objeto de tipo Db_Connection con Nombre DB 
        db_Connection DB = new db_Connection();
        
      try{
        //Se instancia la conexión
        /*conn =*///DB.getConnection();
        
        //Se llama al procedimiento almacenado
        CallableStatement cStatement =  DB.getConnection().prepareCall("{CALL p_Tipo_UsuarioSelect()}");
        //Metodo para ejecutar el procedimiento almacenado
        cStatement.execute();
        //Se instancia un resulset para obtener los datos del procedimiento almacenado
        final ResultSet rs = cStatement.getResultSet(); 
        
         
         while(rs.next()){
         TipoDeUsuario TP = new TipoDeUsuario();
          //ListTipoUsuarios.add(rs.getInt("ID_Tipo_Usuario"));
          TP.setId_Tipo_Usuario(rs.getInt("ID_Tipo_Usuario"));
          TP.setTipo_Usuario(rs.getString("Tipo_Usuario"));
          listaTipoDeUsuario.add(TP);
           //this.setId_Tipo_Usuario(rs.getInt("ID_Tipo_Usuario")); 
           //this.setTipo_Usuario(rs.getString("Tipo_Usuario"));
         }
         cStatement.close();
         rs.close();
         //System.out.println("Usuaro encontrado a traves del procedimiento almacenado: "+ rs.getString("usuario") + " " +rs.getString("password"));
        }catch(Exception e){
            System.out.println("Exception: " +  e);
            e.printStackTrace();
        }finally{
            DB.closeConnection();
            
        }
      return listaTipoDeUsuario;
    }
    
    
    
    
    
    
    public static LinkedList<TipoDeUsuario> SelectTipoDeUsuario(int Id){
        
       LinkedList<TipoDeUsuario> listaTipoDeUsuario = new LinkedList<TipoDeUsuario>();
        db_Connection DB = new db_Connection();
     
        CallableStatement cStatement = null;
        ResultSet rs = null;
        String MSG ="";
        
        try{    
            
           CallableStatement cStatement2 =  DB.getConnection().prepareCall("{CALL p_Tipo_UsuarioSelect_ID(?)}");
           cStatement2.setInt(1, Id);
          
           cStatement2.execute();
           
           rs = cStatement2.getResultSet(); 
           
       if (!rs.isBeforeFirst() ) {  
           
           MSG="Registro inexistente";
           System.out.println("REGISTRO NO EXISTE");
       }else{
           
         while(rs.next()){
          TipoDeUsuario TP = new TipoDeUsuario();
          //ListTipoUsuarios.add(rs.getInt("ID_Tipo_Usuario"));
          TP.setId_Tipo_Usuario(rs.getInt("ID_Tipo_Usuario"));
          TP.setTipo_Usuario(rs.getString("Tipo_Usuario"));
          
          listaTipoDeUsuario.add(TP);
           //this.setId_Tipo_Usuario(rs.getInt("ID_Tipo_Usuario")); 
           //this.setTipo_Usuario(rs.getString("Tipo_Usuario"));
           
         }
          // System.out.println("REGISTRO ENCONTRADO: "+ TP.getTipo_Usuario());
        
        }
        }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
            
        }finally{
            
            DB.closeConnection();
            DB.closeResultSetStatement(rs, cStatement);
            
        }
        
        return listaTipoDeUsuario;
    }


    public String InsertTipoDeUsuario(String TipoUsuarioForm) throws SQLException{
       
        db_Connection DB = new db_Connection();
     
        int NtoalregistrosSelect=0;
        
        int NtoalregistrosInsert=0;
        
        String MSG ="";
        
        CallableStatement cStatement = null;
        ResultSet rs = null;
        
        try{    
            
           CallableStatement cStatement2 =  DB.getConnection().prepareCall("{CALL p_Tipo_UsuarioSelect_VariableIN(?)}");
           cStatement2.setString(1, TipoUsuarioForm);
           
           cStatement2.execute();
           
           rs = cStatement2.getResultSet(); 
         if (!rs.isBeforeFirst() ) {  
             
           cStatement =  DB.getConnection().prepareCall("{CALL p_Tipo_UsuarioIns(?)}");
           cStatement.setString(1, TipoUsuarioForm);
           NtoalregistrosInsert = cStatement.executeUpdate();
           System.out.println(" JAVA CLASS Registros insertados: "+NtoalregistrosInsert);
           MSG="Se ha registrado correctamente el tipo de usuario: "+TipoUsuarioForm+" ";
        
           
         }else{
             System.out.println(" JAVA CLASS Registros Encontrados: "+NtoalregistrosSelect);
            MSG="El tipo de usuario ingresado ya existe";
         }
 
       }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
            
        }finally{
            
            DB.closeConnection();
            DB.closeResultSetStatement(rs, cStatement);
            
        }
        
        
      return MSG;
    }
    
    
    
    public String UpdateTipoDeUsuario(int Id_TipoUsuarioForm, String TipoUsuarioForm) throws SQLException{
       
        db_Connection DB = new db_Connection();
     
        int NtoalregistrosSelect=0;
        
        int NtoalregistrosInsert=0;
        
        String MSG ="";
        
        CallableStatement cStatement = null;
        ResultSet rs = null;
        
        try{    
            
           CallableStatement cStatement2 =  DB.getConnection().prepareCall("{CALL p_Tipo_UsuarioSelect_VariableIN(?)}");
           cStatement2.setString(1, TipoUsuarioForm);
           
           cStatement2.execute();
           
           rs = cStatement2.getResultSet(); 
         if (!rs.isBeforeFirst() ) {  
             
           cStatement =  DB.getConnection().prepareCall("{CALL p_Tipo_UsuarioUpdate(?,?)}");
           cStatement.setInt(1, Id_TipoUsuarioForm);
           cStatement.setString(2, TipoUsuarioForm);
           
           NtoalregistrosInsert = cStatement.executeUpdate();
           System.out.println(" JAVA CLASS Registros insertados: "+NtoalregistrosInsert);
           MSG="Se ha actualizado correctamente el tipo de usuario: "+TipoUsuarioForm+" ";
        
           
         }else{
             System.out.println(" JAVA CLASS Registros Encontrados: "+NtoalregistrosSelect);
            MSG="El tipo de usuario ingresado ya existe";
         }
 
       }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
            
        }finally{
            
            DB.closeConnection();
            DB.closeResultSetStatement(rs, cStatement);
            
        }
               
      return MSG;
    }
    
    
     public String DeleteTipoDeUsuario(int Id_TipoUsuarioForm) throws SQLException{
       
        db_Connection DB = new db_Connection();
     
        int NtoalregistrosSelect=0;
        
        int NtoalregistrosDelete=0;
        
        String MSG ="";
        
        CallableStatement cStatement = null;
        ResultSet rs = null;
        
        try{    
            
 
           cStatement =  DB.getConnection().prepareCall("{CALL p_Tipo_UsuarioDelete_ID(?)}");
           cStatement.setInt(1, Id_TipoUsuarioForm);
           
           
           NtoalregistrosDelete = cStatement.executeUpdate();
           //System.out.println(" JAVA CLASS Registros insertados: "+NtoalregistrosInsert);
          
           //System.out.println(" JAVA CLASS Registros Encontrados: "+NtoalregistrosSelect);
            MSG="Tipo de usuario eliminado";
         
 
       }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
            
        }finally{
            
            DB.closeConnection();
            DB.closeResultSetStatement(rs, cStatement);
            
        }
               
      return MSG;
    }
    
    
   //Clase main para probar METODOS
     public static void main(String[] args) throws SQLException{
       TipoDeUsuario TP = new TipoDeUsuario ();
         //System.out.println(TP.InsertTipoDeUsuario("Trabajadorrr"));
         System.out.println("RESULTADO DEL METODO: "+TP.SelectTipoDeUsuario(1) );
    }

   
    
    
}

