/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  

/**
 *
 * @author claud
 */
public class Usuario {
    /** ATRIBUTOS DE TRABAJADOR **/
    private int Id_Trabajador;
    private int Rut;
    private int Digito_Verificador;
    private String Nombre;
    private String Apellido_P;
    private String Apellido_M;
    private String Direccion;
    
    /** ATRIBUTOS DE USUARIO **/
    private int Id_Usuario;
    private String usernameRS;
    private String passwordRS;
    
    /** ATRIBUTOS TELEFONO**/
    private int Telefono;
     /** ATRIBUTOS EMAIL**/
     private String Correo;
    
     /** ATRIBUTOS DE TIPO DE USUARIO **/
    private int Id_Tipo_Usuario;
    private String Tipo_Usuario;
    
     /** ATRIBUTOS DE TIPO DE LOCAL **/
    private int Id_Local;
    private String Nombre_Comercial;

     
    

    
    public int getTelefono (){
        
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

   
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getId_Trabajador() {
        return Id_Trabajador;
    }

    public void setId_Trabajador(int Id_Trabajador) {
        this.Id_Trabajador = Id_Trabajador;
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getUsernameRS() {
        return usernameRS;
    }

    public void setUsernameRS(String usernameRS) {
        this.usernameRS = usernameRS;
    }

    public String getPasswordRS() {
        return passwordRS;
    }

    public void setPasswordRS(String passwordRS) {
        this.passwordRS = passwordRS;
    }

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

    public int getId_Local() {
        return Id_Local;
    }

    public void setId_Local(int Id_Local) {
        this.Id_Local = Id_Local;
    }

    public String getNombre_Comercial() {
        return Nombre_Comercial;
    }

   
    public void setNombre_Comercial(String Nombre_Comercial) {
        this.Nombre_Comercial = Nombre_Comercial;
    }

     public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String toHexString(byte[] hash) 
    { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    } 
  
  
      
       // Driver code  
    public static void main(String args[]) 
    {  
        try 
        { 
            System.out.println("HashCode Generated by SHA-256 for:");  
  
            String s1 = "GeeksForGeeks";  
            System.out.println("\n" + s1 + " : " + toHexString(getSHA(s1)));  
  
            String s2 = "123";  
            System.out.println("\n" + s2 + " : " + toHexString(getSHA(s2)));  
            
            String s3 = "1234";  
            System.out.println("\n" + s2 + " : " + toHexString(getSHA(s3)));  
        } 
        // For specifying wrong message digest algorithms  
        catch (NoSuchAlgorithmException e) {  
            System.out.println("Exception thrown for incorrect algorithm: " + e);  
        }  
    }  
    
    // autenticacion de usuario al sistema
    public int authenticacionDeUsuario(String username, String password) throws SQLException {
        //Declaracion de variables a utilizar en validaciones
        int aux = 0;
        
        //Establecer la conexión con la base de datos
        Connection conn = null;
        db_Connection DB = new db_Connection();
        
        try{
            //Se instancia la conexión
            /*conn =*/ DB.getConnection();
            //Lammado al procedimiento almacenado
            CallableStatement cStatement =  DB.getConnection().prepareCall("{CALL p_autenticacion_UsuarioSelect(?,?)}");
            
            //Se añaden al procedimiento almacenado las variables de entrada
            cStatement.setString(1, username);
            cStatement.setString(2, password);
            
            //Metodo para ejecutar el procedimiento almacenado
            cStatement.execute();
                     
            //Se instancia un resulset para obtener los datos del procedimiento almacenado
            final ResultSet rs = cStatement.getResultSet();
            
            while(rs.next()){
                
                usernameRS = rs.getString("usuario");
                passwordRS = rs.getString("password");
                Id_Tipo_Usuario = rs.getInt("Id_Tipo_Usuario");
                Id_Local = rs.getInt("Id_Local");
              
                
                
            }
           // System.out.println("ID TIPO USUARIO: "+Id_Tipo_Usuario);
            //System.out.println("ID LOCAL: "+ Id_Local);
            //System.out.println("Usuaro encontrado a traves del procedimiento almacenado: "+ rs.getString("usuario") + " " +rs.getString("password"));
            
        }catch(Exception e){
            System.out.println("Exception: " +  e);
            e.printStackTrace();
        }finally{
            DB.closeConnection();
            
        }
        
        return aux;
    }
    
    
    
    
    
    // obtencion de registros de Trabajador con su usuario, tipo de usuario, datos de contacto y local perteneciente
     public static LinkedList <Usuario> getTrabajador() throws SQLException{
        //Se instancia una objeto de tipo LinkedList <TipoDeUsuario>
            //List<String> ListTipoUsuarios = new ArrayList<>();
        LinkedList<Usuario> listaTrabajador = new LinkedList <Usuario>();
        
        //Se instancia una objeto de tipo Db_Connection con Nombre DB 
        db_Connection DB = new db_Connection();
        
      try{
        //Se instancia la conexión
        /*conn =*///DB.getConnection();
        
        //Se llama al procedimiento almacenado
        CallableStatement cStatement =  DB.getConnection().prepareCall("{CALL p_TrabajadorUsuarioLocalTipoUsuarioSelectALL()}");
        //Metodo para ejecutar el procedimiento almacenado
        cStatement.execute();
        //Se instancia un resulset para obtener los datos del procedimiento almacenado
        final ResultSet rs = cStatement.getResultSet(); 
        
         
         while(rs.next()){
         Usuario User = new Usuario();
          //ListTipoUsuarios.add(rs.getInt("ID_Tipo_Usuario"));
            // TP.setId_Tipo_Usuario(rs.getInt("ID_Tipo_Usuario"));
             //TP.setTipo_Usuario(rs.getString("Tipo_Usuario"));
             
          User.setId_Trabajador(rs.getInt("Id_Trabajador"));
          User.setRut(rs.getInt("Rut"));
          User.setDigito_Verificador(rs.getInt("Digito_Verificador"));
          User.setNombre(rs.getString("Nombre"));
          User.setApellido_P(rs.getString("Apellido_Paterno"));
          User.setApellido_M(rs.getString("Apellido_Materno"));
          User.setTelefono(rs.getInt("Telefono"));
          User.setCorreo(rs.getString("Email"));
          User.setDireccion(rs.getString("Direccion"));
          User.setUsernameRS(rs.getString("Usuario"));
          User.setTipo_Usuario(rs.getString("Tipo_Usuario"));
          User.setNombre_Comercial(rs.getString("Nombre_Comercial"));
          
          listaTrabajador.add(User);
           //this.setId_Tipo_Usuario(rs.getInt("ID_Tipo_Usuario")); 
           //this.setTipo_Usuario(rs.getString("Tipo_Usuario"));
         }
         // System.out.println("Se ejecuta el select");
         cStatement.close();
         rs.close();
         //System.out.println("Usuaro encontrado a traves del procedimiento almacenado: "+ rs.getString("usuario") + " " +rs.getString("password"));
        }catch(Exception e){
            System.out.println("Exception: " +  e);
            e.printStackTrace();
        }finally{
            DB.closeConnection();
            
        }
      return listaTrabajador;
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

    
    
    
    
    /* Registro de trabajador, usuario, telefono, correo */
    public String InsertDeUsuario
        (int RUT,
         String DF,
         String Nombre,
         String ApellidoP,
         String ApellidoM,
         String Direccion,
         String usuario,
         String Password,
         int TelefonoU,
         String CorreoU,
         int IdTipoUsuario,
         int IdLocal,
         int TipoTelefono,
         
         int TipoCorreo) throws SQLException, NoSuchAlgorithmException{
       
        String PasswordSha256="";
        db_Connection DB = new db_Connection();
     
        int NtoalregistrosSelect=0;
        
        int NtoalregistrosInsert=0;
        
        String MSG ="";
        
        CallableStatement cStatement0 = null;
       CallableStatement cStatement1 = null;
        ResultSet rs1 = null;
         ResultSet rs2 = null;
        
        try{    
            
           cStatement0 =  DB.getConnection().prepareCall("{CALL p_TrabajadorRutSelect(?)}");
           cStatement0.setInt(1, RUT);
           cStatement0.execute();
           rs1 = cStatement0.getResultSet(); 
           
           if(!rs1.isBeforeFirst()){
          
             try{    

                   cStatement1 =  DB.getConnection().prepareCall("{CALL p_NombreUsuarioSelect(?)}");
                   cStatement1.setString(1, usuario);
                   cStatement1.execute();
                   rs2 = cStatement1.getResultSet(); 
             
         
                    if (!rs2.isBeforeFirst() ) {  
                        Usuario u = new Usuario();
                     PasswordSha256 = u.toHexString(getSHA(Password));

                        CallableStatement cStatement2 =  DB.getConnection().prepareCall("{CALL p_NuevoTrabajadorUsuarioIns(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                    // Asignación de variables al Procedimiento almacenado
                      cStatement2.setInt(1, RUT);
                       cStatement2.setString(2, DF);
                        cStatement2.setString(3, Nombre);
                         cStatement2.setString(4, ApellidoP);
                          cStatement2.setString(5, ApellidoM);
                           cStatement2.setString(6, Direccion);
                            cStatement2.setString(7, usuario);
                             cStatement2.setString(8, PasswordSha256);
                              cStatement2.setInt(9, TelefonoU);
                               cStatement2.setString(10, CorreoU);
                                cStatement2.setInt(11, IdTipoUsuario);
                                 cStatement2.setInt(12, IdLocal);
                                  cStatement2.setInt(13, TipoTelefono);
                                   cStatement2.setInt(14, TipoCorreo);
                                   cStatement2.registerOutParameter(15, java.sql.Types.INTEGER);

                      NtoalregistrosInsert = cStatement2.executeUpdate();

                      rs2 = cStatement2.getResultSet(); 
                         int Id_TrabajadorOUT = cStatement2.getInt(15);
                      System.out.println(" JAVA CLASS Registros insertados: "+NtoalregistrosInsert);
                      
                      MSG="Se ha registrado correctamente el  usuario: "+Nombre+" "+ApellidoP+" "+ApellidoM+". Con el nombre de usuario: "+usuario;

        }else{
             System.out.println(" JAVA CLASS Registros Encontrados: "+NtoalregistrosSelect);
            MSG="Nombre de usuario ingresado ya se encuentra en el sistema, porfavor ingresar otro nombre de usuario";
         }
         
           
             
             
         }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
           
        }
        }else{
               MSG="RUT ingresado ya se encuentra registrado en el sistema, porfavor ingresar otro RUT";  
                 }
            
         
       }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
            
        }finally{
            
            DB.closeConnection();
            DB.closeResultSetStatement(rs1, cStatement0);
            DB.closeResultSetStatement(rs2, cStatement1);
            
        }
        
        
      return MSG;
    }
    
    
   /* Update */
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
    
    
    
     public String DeleteUsuario(int Id_TipoUsuarioForm) throws SQLException{
       
        db_Connection DB = new db_Connection();
     
        int NtoalregistrosSelect=0;
        
        int NtoalregistrosDelete=0;
        
        String MSG ="";
        
        CallableStatement cStatement = null;
        ResultSet rs = null;
        
        try{    
            
 
           cStatement =  DB.getConnection().prepareCall("{CALL p_UsuarioDelete_ID(?)}");
           cStatement.setInt(1, Id_TipoUsuarioForm);
           
           NtoalregistrosDelete = cStatement.executeUpdate();
           //System.out.println(" JAVA CLASS Registros insertados: "+NtoalregistrosInsert);
          
           //System.out.println(" JAVA CLASS Registros Encontrados: "+NtoalregistrosSelect);
            MSG="Se ha eliminado correctamente el usuario";
         
 
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
     /**public static void main(String[] args) throws SQLException{
       Usuario User = new Usuario ();
         //System.out.println(TP.InsertTipoDeUsuario("Trabajadorrr"));
         //LinkedList<Usuario> listaTrabajador = new LinkedList <Usuario>();
         //listaTrabajador.
         System.out.println("RESULTADO DEL METODO: "+Usuario.getTrabajador() );
    }**/
   

   
    
    
    
    
    
    
    
    
    /**public static void listaDeUsuarios (){
        
        db_Connection db = new db_Connection ();
        
        //db.getConnection() = Metodo que devuelve la conexión a al base de datos
        
        db.getConnection().prepareCall(sql);
        
        CallableStatement cst =  db.getConnection().prepareCall(sql);
        
       
    }**/
    
    
    
    
    
}
