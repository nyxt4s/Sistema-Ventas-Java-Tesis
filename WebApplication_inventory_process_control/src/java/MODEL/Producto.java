/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author claud
 */
public class Producto {
    
    private int Id_Producto;
    private String Codigo_de_Barras;
    private String  Nombre;
    private String ImagenProducto;
    /** ATRIBUTOS DE CATEGORIA **/
    private int Id_Categoria;
    private String Categoria;
    /** ATRIBUTOS DE MARCA **/
    private int Id_Marca;
    private String Marca;
    

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
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

    public String getImagenProducto() {
        return ImagenProducto;
    }

    public void setImagenProducto(String ImagenProducto) {
        this.ImagenProducto = ImagenProducto;
    }

    public int getId_Categoria() {
        return Id_Categoria;
    }

    public void setId_Categoria(int Id_Categoria) {
        this.Id_Categoria = Id_Categoria;
    }

    public int getId_Marca() {
        return Id_Marca;
    }

    public void setId_Marca(int Id_Marca) {
        this.Id_Marca = Id_Marca;
    }
    
    
    
    public Producto BuscarProductoID(String CodigoBarras){
          Producto pr = new Producto();
       db_Connection DB = new db_Connection();
       
        CallableStatement cStatement = null;
        ResultSet rs = null;
        String MSG ="";
        
        try{    
           cStatement =  DB.getConnection().prepareCall("{CALL p_ProductoSelectIn(?)}");
           cStatement.setString(1, CodigoBarras);
           cStatement.execute();
           
           rs = cStatement.getResultSet(); 
           
         while(rs.next()){
          //ListTipoUsuarios.add(rs.getInt("ID_Tipo_Usuario"));
          pr.setId_Producto(rs.getInt("Id_Producto"));
          pr.setCodigo_de_Barras(rs.getString("Codigo_de_Barras"));
          pr.setNombre(rs.getString("Nombre"));
          pr.setImagenProducto(rs.getString("Imagen"));
          //Hacer inner con categoria para mostrar el nombre y el id
          pr.setId_Categoria(rs.getInt("Id_Categoria"));
          pr.setCategoria(Categoria);
          //Hacer inner con marca para mostrar el nombre y el id
          pr.setId_Marca(rs.getInt("Id_Marca"));
          pr.setMarca(Marca);
          
           //this.setId_Tipo_Usuario(rs.getInt("ID_Tipo_Usuario")); 
           //this.setTipo_Usuario(rs.getString("Tipo_Usuario"));        
          // System.out.println("REGISTRO ENCONTRADO: "+ TP.getTipo_Usuario());
        }
        }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
            
        }finally{
            
            DB.closeConnection();
            DB.closeResultSetStatement(rs, cStatement);
            
        }
       return pr;
    }
    
       public static void main(String[] args) throws SQLException{
       Producto p = new Producto ();
         //System.out.println(TP.InsertTipoDeUsuario("Trabajadorrr"));
         System.out.println("RESULTADO DEL METODO: "+p.BuscarProductoID("7791290790513"));
    }

    
    
}
