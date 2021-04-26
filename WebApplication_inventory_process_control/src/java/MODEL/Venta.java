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

/**
 *
 * @author claud
 */
public class Venta {
    
    Integer ID;
    Integer Item;
    Integer Id_Usuario;
    String Codigo_de_Barras;
    Integer NumSerie;
    String  Nombre;
    Integer PrecioCosto;
    Integer PrecioVenta;
    Integer cantidad;
    Integer SubTotal;
    Integer Id_Local;
    Integer Id_Categoria;
    String Categoria;
    Integer Id_Marca;
    String Marca;
    Integer TotalVenta;
    Integer Idinventario;
    Integer CantidadDeVentas;

    public Integer getCantidadDeVentas() {
        return CantidadDeVentas;
    }

    public void setCantidadDeVentas(Integer CantidadDeVentas) {
        this.CantidadDeVentas = CantidadDeVentas;
    }

    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getItem() {
        return Item;
    }

    public void setItem(Integer Item) {
        this.Item = Item;
    }

    public Integer getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(Integer Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getCodigo_de_Barras() {
        return Codigo_de_Barras;
    }

    public void setCodigo_de_Barras(String Codigo_de_Barras) {
        this.Codigo_de_Barras = Codigo_de_Barras;
    }

    public Integer getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(Integer NumSerie) {
        this.NumSerie = NumSerie;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getPrecioCosto() {
        return PrecioCosto;
    }

    public void setPrecioCosto(Integer PrecioCosto) {
        this.PrecioCosto = PrecioCosto;
    }

    public Integer getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(Integer PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(Integer SubTotal) {
        this.SubTotal = SubTotal;
    }

    public Integer getId_Local() {
        return Id_Local;
    }

    public void setId_Local(Integer Id_Local) {
        this.Id_Local = Id_Local;
    }

    public Integer getId_Categoria() {
        return Id_Categoria;
    }

    public void setId_Categoria(Integer Id_Categoria) {
        this.Id_Categoria = Id_Categoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public Integer getId_Marca() {
        return Id_Marca;
    }

    public void setId_Marca(Integer Id_Marca) {
        this.Id_Marca = Id_Marca;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public Integer getTotalVenta() {
        return TotalVenta;
    }

    public void setTotalVenta(Integer TotalVenta) {
        this.TotalVenta = TotalVenta;
    }

    public Integer getIdinventario() {
        return Idinventario;
    }

    public void setIdinventario(Integer Idinventario) {
        this.Idinventario = Idinventario;
    }

    

   
    int R;
    
    public int cantVentaTotal (int Id_Inventario){
  db_Connection DB = new db_Connection();
        CallableStatement cStatement = null;
        ResultSet rs = null;
        
        String IdVenta="";
        String MSG ="";
  
        try{
            //Se instancia la conexión
            DB.getConnection();
            //Lammado al procedimiento almacenado
            cStatement =  DB.getConnection().prepareCall("{CALL p_ContadorDeVentas(?)}");
            //Metodo para ejecutar el procedimiento almacenado
           cStatement.setInt(1, Id_Inventario);
            cStatement.execute();
            //Se instancia un resulset para obtener los datos del procedimiento almacenado
            rs = cStatement.getResultSet();
            
            while(rs.next()){ 
             this.CantidadDeVentas= rs.getRow();
            }
            
        }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
        }finally{
            DB.closeConnection();
            DB.closeResultSetStatement(rs, cStatement);
        }
        return CantidadDeVentas;
    }
    
    
    public String IdVenta(){
         //LinkedList<TipoDeUsuario> listaTipoDeUsuario = new LinkedList<TipoDeUsuario>();
        db_Connection DB = new db_Connection();
        CallableStatement cStatement = null;
        ResultSet rs = null;
        
        String IdVenta="";
        String MSG ="";
  
        try{
            //Se instancia la conexión
             DB.getConnection();
            //Lammado al procedimiento almacenado
             cStatement =  DB.getConnection().prepareCall("{CALL p_IdVentaMAXSelect()}");
            //Metodo para ejecutar el procedimiento almacenado
            cStatement.execute();
            //Se instancia un resulset para obtener los datos del procedimiento almacenado
            rs = cStatement.getResultSet();
            
            while(rs.next()){ 
             IdVenta = rs.getString(1);
            }
            
        }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
        }finally{
            DB.closeConnection();
            DB.closeResultSetStatement(rs, cStatement);
        }
        return IdVenta;
    }
    
    
    
    
    
    public int guardarVenta (Venta V){
      
      db_Connection DB = new db_Connection();
        //String MSG ="";
        CallableStatement cStatement = null;
        ResultSet rs = null;
        System.out.println("SE EJECUTO GUARDAR VENTA");
        System.out.println("TOTAL VENTA: "+V.getTotalVenta());
        System.out.println("ID USUARIO: "+V.getId_Usuario());
        try{    
            System.out.println("SE EJECUTO TRY GUARDAR VENTA");
           cStatement =  DB.getConnection().prepareCall("{CALL p_VentaIns(?,?,?,?)}");
           cStatement.setInt(1, 0);
           cStatement.setInt(2,V.getTotalVenta());
           cStatement.setInt(3,V.getId_Usuario());
           cStatement.registerOutParameter(4, java.sql.Types.INTEGER);
           cStatement.executeUpdate();
       
       }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
        }finally{
            DB.closeConnection();
            DB.closeResultSetStatement(rs, cStatement); 
        }

      return R;
    }
    
    public int guardarDetalleVenta(Venta Venta){
        db_Connection DB = new db_Connection();
       // String MSG ="";
        CallableStatement cStatement = null;
        ResultSet rs = null;
        try{   
           cStatement =  DB.getConnection().prepareCall("{CALL p_detalle_VentaIns(?,?,?,?,?,?,?)}");
           cStatement.setInt(1, Venta.getCantidad());
           cStatement.setInt(2, Venta.getPrecioCosto());
           cStatement.setInt(3, Venta.getPrecioVenta());
           cStatement.setInt(4, 0);
           cStatement.setInt(5, 1);
           cStatement.setInt(6, Venta.getIdinventario());
           cStatement.setInt(7, Venta.getID());
           cStatement.executeUpdate();
       
       }catch(SQLException ex){
            System.out.println("Exception: " +  ex);
            ex.printStackTrace();
        }finally{
            DB.closeConnection();
            DB.closeResultSetStatement(rs, cStatement); 
        }

      return R;
    }
    
    
      public static void main(String[] args) throws SQLException{
       Venta V = new Venta ();
         //System.out.println(TP.InsertTipoDeUsuario("Trabajadorrr"));
     
         System.out.println("Cantidad de ventas en el local N°2: "+V.cantVentaTotal(2));
    }
    }
    
    
     
    
  
    
    
    

