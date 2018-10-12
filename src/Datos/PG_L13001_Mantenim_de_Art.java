/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import DB.Conector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author MARIO REUS
 */
public class PG_L13001_Mantenim_de_Art {
    
    private Connection conexion = null; // maneja la conexión
    private PreparedStatement seleccionarTodosLosArticulosQueEsten = null;
    private PreparedStatement seleccionarArticulosPorCodigo = null;
    private PreparedStatement insertarNuevoArticulo = null;
    private PreparedStatement modificarArticulo = null;
    private PreparedStatement eliminarArticulo = null;
    
    // constructor
    public PG_L13001_Mantenim_de_Art(){
        try{
           
            conexion = Conector.conexion();
            // crea una consulta que selecciona todas las entradas en la LibretaDirecciones
            seleccionarTodosLosArticulosQueEsten =
            conexion.prepareStatement( "SELECT * FROM ARTICULOS WHERE ArtEstReg = ?"  );
           
            // crea una consulta que selecciona las entradas con un apellido específico
            seleccionarArticulosPorCodigo = conexion.prepareStatement(
            "SELECT * FROM ARTICULOS WHERE ArtNum = ?" );

            // crea instrucción insert para agregar una nueva entrada en la base de datos
            insertarNuevoArticulo = conexion.prepareStatement("INSERT INTO ARTICULOS " +
            "( ArtNum, ArtDes, ArtPrecUnit, ArtEstReg, SucCod, CiaCod ) " +
            "VALUES ( ?, ?, ?, ?, ?, ? )" );
            
            modificarArticulo = conexion.prepareStatement("UPDATE ARTICULOS " +
                "SET ArtDes = ? ," +
                "ArtPrecUnit = ? ," +                    
                "ArtEstReg = ? ," +
                "SucCod = ? ,"+
                "CiaCod = ? "+
                "WHERE ArtNum = ? ");
            
            eliminarArticulo = conexion.prepareStatement("UPDATE ARTICULOS " +
                "SET ArtEstReg = ? "+
                "WHERE ArtNum = ? ");
         
        } catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
            System.exit( 1 );
        } 
		} // fin del constructor de PG_L13001_Mantenim_de_Art
    
    public int agregarArticulo( int artNum, String artDesc, double precUnit, String estReg ,int sucCod, int ciaCod ){
        int resultado = 0;
        // establece los parámetros, después ejecuta insertarNuevoArticulo
        try{
            insertarNuevoArticulo.setInt( 1, artNum );
            insertarNuevoArticulo.setString( 2, artDesc );
            insertarNuevoArticulo.setDouble( 3, precUnit );
            insertarNuevoArticulo.setString( 4, estReg );
            insertarNuevoArticulo.setInt( 5, sucCod );
            insertarNuevoArticulo.setInt( 6, ciaCod  );
            
            resultado = insertarNuevoArticulo.executeUpdate();
        } // fin de try // fin de try
            catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
            close();
        } // fin de catch
        
        return resultado;
    } // fin del método agregarPersona
    
    public int ActualizarArticulo(int artNum, String artDesc, double precUnit, String estReg ,int sucCod, int ciaCod){
        int resultado = 0;
        try {            
                               
            modificarArticulo.setString( 1, artDesc );
            modificarArticulo.setDouble( 2, precUnit );
            modificarArticulo.setString( 3, estReg );
            modificarArticulo.setInt( 4, sucCod );
            modificarArticulo.setInt( 5, ciaCod  );
            modificarArticulo.setInt( 6, artNum );
            
            resultado = modificarArticulo.executeUpdate();
                       
         }catch(SQLException e){
            System.out.println(e);
            close();
      }
      return resultado;
    }
    
    public int EliminarArticulo(int artNum){
        int resultado = 0;
        try {            
            eliminarArticulo.setString( 1, "*" );           
            eliminarArticulo.setInt( 2, artNum );
           
            resultado = eliminarArticulo.executeUpdate();
                       
        }catch(SQLException e){
            System.out.println(e);
            close();
        }
        return resultado;
    }
   
    public Object [][] obtenerTodasLosArticulosQueEsten( String criterio_seleccion ){
        if( !criterio_seleccion.equals("A") && !criterio_seleccion.equals("I") && !criterio_seleccion.equals("*")  )
            return null;
        
        int registros = 0;      
        String consultaContadora = "Select count(*) as total FROM ARTICULOS WHERE ArtEstReg = '"+criterio_seleccion+"' ";
        //obtenemos la cantidad de registros existentes en la tabla
        try{
           PreparedStatement pstm = conexion.prepareStatement( consultaContadora );
           ResultSet res = pstm.executeQuery();
           res.next();
           registros = res.getInt("total");
           res.close();
        }catch(SQLException e){
           System.out.println(e);
        }
      //se crea una matriz con tantas filas y columnas que necesite
      Object[][] data = new String[registros][5];
      //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           seleccionarTodosLosArticulosQueEsten.setString(1, criterio_seleccion);
           ResultSet res = seleccionarTodosLosArticulosQueEsten.executeQuery();
           int i = 0;
           while(res.next()){
               data[i][0] = String.valueOf( res.getInt( "ArtNum" ) );
               data[i][1] = res.getString( "ArtDes" );         
               data[i][2] = String.valueOf( res.getDouble("ArtPrecUnit" ) );
               data[i][3] = String.valueOf( res.getInt("SucCod") );
               data[i][4] = String.valueOf( res.getInt("CiaCod") ); 
               i++;
           }
           res.close();
        }catch(SQLException e){
                 System.out.println(e);
        }
        return data;   
    } // fin del método 
    
    
    public void close(){
        try{
            conexion.close();
        } // fin de try
        catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
        } // fin de catch
    } // fin del método close
    
    public int GeneradorCodigos(){
        
        int codGenerado=0;
        String tabla= "ARTICULOS";
        String campoCodNom = "ArtNum";
        
        String consultaContadora = "Select count(*) as total FROM "+tabla;
        ResultSet res;
        //obtenemos la cantidad de registros existentes en la tabla
        try{
           PreparedStatement pstm = conexion.prepareStatement( consultaContadora );
           res = pstm.executeQuery();
           res.next();
           int registros = res.getInt("total");
           if( registros==0 )
               codGenerado = 16010001;
           else{
               PreparedStatement maxCOD = conexion.prepareStatement( "SELECT MAX(" +campoCodNom+ ") AS id FROM "+tabla );
               res = maxCOD.executeQuery();
               res.next();
               codGenerado = res.getInt("id") + 1;
           }
               
        }catch(SQLException e){
           System.out.println(e);
        }
        
        return codGenerado;
    }
  
       
}
