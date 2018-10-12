/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;
import claseConectar.Conector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MARIO HUAYPUNA
 */
public class PG_L13004_Mantenim_de_Suc {
    
    private Connection conexion = null; // maneja la conexión
    private PreparedStatement seleccionarTodasLasSucursalesQueEsten = null;
    private PreparedStatement seleccionarLasSucursalesDeCiaQueEsten = null;
    private PreparedStatement seleccionarSucursalesPorCodigo = null;
    private PreparedStatement insertarNuevaSucursal = null;
    private PreparedStatement modificarSucursal = null;
    private PreparedStatement eliminarSucursal = null;
    
    public PG_L13004_Mantenim_de_Suc(){
        try{            
            conexion = Conector.conexion();
            // crea una consulta que selecciona todas las entradas en la LibretaDirecciones
            seleccionarTodasLasSucursalesQueEsten =
            conexion.prepareStatement( "SELECT * FROM SUCURSALES WHERE SucEstReg = ?" );
            
            // crea una consulta que selecciona las entradas con un apellido específico
            seleccionarSucursalesPorCodigo = conexion.prepareStatement(
            "SELECT * FROM SUCURSALES WHERE SucCod = ?" );

            // crea instrucción insert para agregar una nueva entrada en la base de datos
            insertarNuevaSucursal = conexion.prepareStatement("INSERT INTO SUCURSALES " +
            "( SucCod, SucDes, SucEstReg, CiaCod ) " +
            "VALUES ( ?, ?, ?, ?)" );
            
            modificarSucursal = conexion.prepareStatement("UPDATE SUCURSALES " +
                "SET SucDes = ? ," +
                "SucEstReg = ? ," +                    
                "CiaCod = ? " +
                "WHERE SucCod = ? ");
            
            eliminarSucursal = conexion.prepareStatement("UPDATE SUCURSALES " +
                "SET SucEstReg = ? "+
                "WHERE SucCod = ? ");
            
        } catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
            System.exit( 1 );
        }  
		}
    
    public int agregarSucursal( int sucCod, String sucDes, String estReg, int ciaCod ){
        int resultado = 0;
        // establece los parámetros, después ejecuta insertarNuevaCia
        try{
            insertarNuevaSucursal.setInt( 1, sucCod );
            insertarNuevaSucursal.setString( 2, sucDes );
            insertarNuevaSucursal.setString(3, estReg );
            insertarNuevaSucursal.setInt( 4, ciaCod );
            
            resultado = insertarNuevaSucursal.executeUpdate();
        } // fin de try // fin de try // fin de try // fin de try
            catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
        } // fin de catch
        
        return resultado;
    } // fin del método 
    
    public int ActualizarSucursal(int sucCod, String sucDes, String estReg, int ciaCod){
        int resultado = 0;
        try {            
                                                
            modificarSucursal.setString( 1, sucDes );
            modificarSucursal.setString(2, estReg );
            modificarSucursal.setInt( 3, ciaCod );
            modificarSucursal.setInt( 4, sucCod );
            
            resultado = modificarSucursal.executeUpdate();
                       
         }catch(SQLException e){
            System.out.println(e);
           
      }
      return resultado;
    }
    
    public int EliminarSucursal(int sucCod){
        int resultado = 0;
        try {            
            eliminarSucursal.setString( 1, "*" );
            eliminarSucursal.setInt( 2, sucCod );
           
            resultado = eliminarSucursal.executeUpdate();
                       
        }catch(SQLException e){
            System.out.println(e);
        }
        return resultado;
    }
    
    public Object [][] obtenerTodasLasSucursalesActivas( String criterio_seleccion ){
        if( !criterio_seleccion.equals("A") && !criterio_seleccion.equals("I") && !criterio_seleccion.equals("*")  )
            return null;
        
        int registros = 0;      
        String consultaContadora = "Select count(*) as total FROM SUCURSALES WHERE SucEstReg = '"+criterio_seleccion+"' ";
        //obtenemos la cantidad de registros existentes en la tabla
        try{
           PreparedStatement pstm = conexion.prepareStatement( consultaContadora );
           ResultSet res = pstm.executeQuery();
           res.next();
           registros = res.getInt("total");
        }catch(SQLException e){
           System.out.println(e);
        }
      //se crea una matriz con tantas filas y columnas que necesite
      Object[][] data = new String[registros][3];
      //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           seleccionarTodasLasSucursalesQueEsten.setString(1, criterio_seleccion);
           ResultSet res = seleccionarTodasLasSucursalesQueEsten.executeQuery();
           int i = 0;
           while(res.next()){
               data[i][0] = String.valueOf( res.getInt( "SucCod" ) );
               data[i][1] = res.getString( "SucDes" );         
               data[i][2] = String.valueOf( res.getInt( "CiaCod" ) );
              i++;
           }
        }catch(SQLException e){
                 System.out.println(e);
        }
        return data;   
    } // fin del método obtenerTodasLasPersonaas
    
    public Object [][] obtenerSucursalesDeCiaActivas( String criterio_seleccion, String codigoCia ){
        if( !criterio_seleccion.equals("A") && !criterio_seleccion.equals("I") && !criterio_seleccion.equals("*")  )
            return null;
        
        int registros = 0;      
        String consultaContadora = "Select count(*) as total FROM SUCURSALES WHERE SucEstReg = '"+criterio_seleccion+"' "
                + "AND CiaCod = "+codigoCia;
        //obtenemos la cantidad de registros existentes en la tabla
        try{
           PreparedStatement pstm = conexion.prepareStatement( consultaContadora );
           ResultSet res = pstm.executeQuery();
           res.next();
           registros = res.getInt("total");
        }catch(SQLException e){
           System.out.println(e);
        }
      //se crea una matriz con tantas filas y columnas que necesite
      Object[][] data = new String[registros][3];
      //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           seleccionarLasSucursalesDeCiaQueEsten =
            conexion.prepareStatement( "SELECT * FROM SUCURSALES WHERE SucEstReg = '"+criterio_seleccion+"' AND CiaCod ="+codigoCia );
           
           ResultSet res = seleccionarLasSucursalesDeCiaQueEsten.executeQuery();
           int i = 0;
           while(res.next()){
               data[i][0] = String.valueOf( res.getInt( "SucCod" ) );
               data[i][1] = res.getString( "SucDes" );         
               data[i][2] = String.valueOf( res.getInt( "CiaCod" ) );
              i++;
           }
           
        }catch(SQLException e){
                 System.out.println(e);
        }
        return data;   
    } // fin del método obtenerTodasLasPersonaas
    
    
}
