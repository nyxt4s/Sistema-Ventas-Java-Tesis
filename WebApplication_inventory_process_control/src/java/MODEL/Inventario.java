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
public class Inventario {
    
    /** Atributos de la tabla Inventario  **/
    private int Id_Inventario;
    private int cantidad;
    private int Precio_Costo;
    private int Precio_Venta;
    private String Ubicacion;
    
    /** Atributos de la tabla productos **/
    private int Id_Producto;
    private String Codigo_de_Barras;
    private String  Nombre;
    private String Imagen;

    /** Atributos de la tabla local **/
    private int Id_Local;
    private String Nombrelocal;
    
    /** Atributos de la tabla Categoria **/
    private int Id_Categoria;
    private String Categoria;
    
    /** Atributos de la tabla Marca **/
    private int Id_Marca;
    private String Marca;

    public int getId_Inventario() {
        return Id_Inventario;
    }

    public void setId_Inventario(int Id_Inventario) {
        this.Id_Inventario = Id_Inventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio_Costo() {
        return Precio_Costo;
    }

    public void setPrecio_Costo(int Precio_Costo) {
        this.Precio_Costo = Precio_Costo;
    }

    public int getPrecio_Venta() {
        return Precio_Venta;
    }

    public void setPrecio_Venta(int Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public int getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(int Id_Producto) {
        this.Id_Producto = Id_Producto;
    }

    public String getCodigo_de_Barras() {
        return Codigo_de_Barras;
    }

    public void setCodigo_de_Barras(String Codigo_de_Barras) {
        this.Codigo_de_Barras = Codigo_de_Barras;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public int getId_Local() {
        return Id_Local;
    }

    public void setId_Local(int Id_Local) {
        this.Id_Local = Id_Local;
    }

    public String getNombrelocal() {
        return Nombrelocal;
    }

    public void setNombrelocal(String Nombrelocal) {
        this.Nombrelocal = Nombrelocal;
    }

    public int getId_Categoria() {
        return Id_Categoria;
    }

    public void setId_Categoria(int Id_Categoria) {
        this.Id_Categoria = Id_Categoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getId_Marca() {
        return Id_Marca;
    }

    public void setId_Marca(int Id_Marca) {
        this.Id_Marca = Id_Marca;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    
    
   
    public int ActualizarStockInventario (){
        
        
       return 1; 
    }
    
    public static LinkedList<Inventario> getInventario(int IdLocal) throws SQLException{
        //Se instancia una objeto de tipo LinkedList <TipoDeUsuario>
            //List<String> ListTipoUsuarios = new ArrayList<>();
        LinkedList<Inventario> ListaInventario = new LinkedList<Inventario>();
        
        //Se instancia una objeto de tipo Db_Connection con Nombre DB 
        db_Connection DB = new db_Connection();
        
      try{
        //Se instancia la conexión
        /*conn =*///DB.getConnection();
        
        //Se llama al procedimiento almacenado
        CallableStatement cStatement =  DB.getConnection().prepareCall("{CALL p_InventarioLocalSelectALL(?)}");
        cStatement.setInt(1,2);
        //Metodo para ejecutar el procedimiento almacenado
        cStatement.execute();
        //Se instancia un resulset para obtener los datos del procedimiento almacenado
        final ResultSet rs = cStatement.getResultSet(); 
        
         
         while(rs.next()){
         Inventario I = new Inventario();
          //ListTipoUsuarios.add(rs.getInt("ID_Tipo_Usuario"));
          I.setId_Inventario(rs.getInt("id_inventario"));
          I.setCodigo_de_Barras(rs.getString("Codigo_de_Barras"));
          I.setNombre(rs.getString("Nombre"));
          I.setCategoria(rs.getString("Categoria"));
          I.setMarca(rs.getString("Marca"));
          I.setCantidad(rs.getInt("Cantidad"));
          ListaInventario.add(I);
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
      return ListaInventario;
    }
    
    
    
    
  
            
       public String AddCantidadSock(String CodigoDeBarras, int Cantidad ) throws SQLException{
       
        db_Connection DB = new db_Connection();
     
        int NtoalregistrosSelect=0;
        
        int NtoalregistrosInsert=0;
        
        String MSG ="";
        
        CallableStatement cStatement = null;
        ResultSet rs = null;
        
        try{    
            
           CallableStatement cStatement2 =  DB.getConnection().prepareCall("{CALL p_InventarioLocalSelect(?,?)}");
           cStatement2.setInt(1, 2);
           cStatement2.setString(2, CodigoDeBarras);
           
           cStatement2.execute();
           
           rs = cStatement2.getResultSet(); 
           
           int IdInventario =0;
           String NombreProducto ="";
           
           while(rs.next()){
             IdInventario = rs.getInt("ID_Inventario");
             NombreProducto = rs.getString("Nombre");
             
           }
         
           
        if (!rs.isBeforeFirst()) {  
             
           cStatement =  DB.getConnection().prepareCall("{CALL p_AddCantidadIns(?,?)}");
           cStatement.setInt(1, IdInventario);
           cStatement.setInt(2, Cantidad);
           NtoalregistrosInsert = cStatement.executeUpdate();
           
           System.out.println(" JAVA CLASS Registros insertados: "+NtoalregistrosInsert);
           
           MSG="Se ha agregado correctamente la cantidad de "+ Cantidad+" al sotck del producto: "+NombreProducto;
        
           
        }else{
            System.out.println(" JAVA CLASS Registros Encontrados: "+NtoalregistrosSelect);
            MSG="El codigo de barras del producto ingresado no existe en su inventario";
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
    
             
             
    
    
    
    
    public Inventario BuscarProductoPorInventarioID(String CodigoBarras){
       Inventario Inventario = new Inventario();
       db_Connection DB = new db_Connection();
       int idlocal =0;
        CallableStatement cStatement = null;
        CallableStatement cStatement2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        String MSG ="";
        int NtoalregistrosSelect = 0 ;
        
        try{    
           cStatement =  DB.getConnection().prepareCall("{CALL p_ProdCatMarcaSelect(?)}");
           cStatement.setString(1, CodigoBarras);
           cStatement.execute();
           
           rs = cStatement.getResultSet(); 
           
           if (!rs.isBeforeFirst() ) {  
             
           System.out.println(" JAVA CLASS Registros Encontrados: "+NtoalregistrosSelect);
               
       
                MSG="El producto buscado no existe en el sistema!";
        System.out.println(MSG);
           }else{
            System.out.println("Se ha ejecutado el ELSE");
           idlocal = 2;
           System.out.println("Codigo de barras: "+CodigoBarras );
           System.out.println("Id de Local: "+idlocal );
           cStatement2 =  DB.getConnection().prepareCall("{CALL p_InventarioProdCatMarcaSelect(?,?)}");
           
           cStatement2.setString(1, CodigoBarras);
           cStatement2.setInt(2, idlocal);
           cStatement2.execute();
           
           rs2 = cStatement2.getResultSet();
          
          while(rs2.next()){
           
           
          //ListTipoUsuarios.add(rs.getInt("ID_Tipo_Usuario"));
          Inventario.setId_Producto(rs2.getInt("Id_Producto"));
          Inventario.setCodigo_de_Barras(rs2.getString("Codigo_de_Barras"));
          Inventario.setNombre(rs2.getString("Nombre"));
          //Inventario.setImagenProducto(rs.getString("Imagen"));
          //Hacer inner con categoria para mostrar el nombre y el id
          Inventario.setId_Categoria(rs2.getInt("Id_Categoria"));
          Inventario.setCategoria(rs2.getString("Categoria"));
          //Hacer inner con marca para mostrar el nombre y el id
          Inventario.setId_Marca(rs2.getInt("Id_Marca"));
          Inventario.setMarca(rs2.getString("Marca"));
          
          Inventario.setId_Inventario(rs2.getInt("Id_Inventario"));
          
           Inventario.setPrecio_Venta(rs2.getInt("Precio_Venta"));
           Inventario.setPrecio_Costo(rs2.getInt("Precio_Costo"));
           Inventario.setCantidad(rs2.getInt("Cantidad"));
          
          
           //this.setId_Tipo_Usuario(rs.getInt("ID_Tipo_Usuario")); 
           //this.setTipo_Usuario(rs.getString("Tipo_Usuario"));        
          // System.out.println("REGISTRO ENCONTRADO: "+ TP.getTipo_Usuario());
          
        }
          
            
         }
        
        }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
            
        }finally{
            
            DB.closeConnection();
            DB.closeResultSetStatement(rs, cStatement);
            DB.closeResultSetStatement(rs2,cStatement2);
            
        }
       return Inventario;
    }
    
}
