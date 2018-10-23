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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARIO REUS
 */
public class PG_L13002_Mantenim_de_Cia {
	
    public Connection conexion = null; // maneja la conexión
    private PreparedStatement seleccionarTodasLasCiasQueEsten = null;
    private PreparedStatement seleccionarCiasPorCodigo = null;
    private PreparedStatement insertarNuevaCia = null;
    private PreparedStatement modificarCia = null;
    private PreparedStatement eliminarCia = null;
    
    // constructor
    public PG_L13002_Mantenim_de_Cia(){
        try{
            
            conexion = Conector.conexion();
            // crea una consulta que selecciona todas las entradas en la LibretaDirecciones
            seleccionarTodasLasCiasQueEsten =
            conexion.prepareStatement( "SELECT * FROM CIAS WHERE CiaEstReg = ? " );
           
            // crea una consulta que selecciona las entradas con un apellido específico
            seleccionarCiasPorCodigo = conexion.prepareStatement(
            "SELECT * FROM CIAS WHERE CiaCod = ?" );

            // crea instrucción insert para agregar una nueva entrada en la base de datos
            insertarNuevaCia = conexion.prepareStatement("INSERT INTO CIAS " +
            "( CiaCod, CiaNom, CiaRUC, CiaEstReg ) " +
            "VALUES ( ?, ?, ?, ? )" );
            
            modificarCia = conexion.prepareStatement("UPDATE CIAS " +
                "SET CiaNom = ? ," +
                "CiaRUC = ? ," +                    
                "CiaEstReg = ? " +
                "WHERE CiaCod = ? ");
            
            eliminarCia = conexion.prepareStatement("UPDATE CIAS " +
                "SET CiaEstReg = ? "+
                "WHERE CiaCod = ? ");
                    
        } catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
            System.exit( 1 );
        } 
		} // fin del constructor de PG_L13001_Mantenim_de_Art
    
    public int agregarCia( int ciaCod, String ciaNom, String Ruc, String estReg ){
        int resultado = 0;
        // establece los parámetros, después ejecuta insertarNuevaCia
        try{
            insertarNuevaCia.setInt( 1, ciaCod );
            insertarNuevaCia.setString( 2, ciaNom );
            insertarNuevaCia.setString(3, Ruc );
            insertarNuevaCia.setString( 4, estReg );
            
            resultado = insertarNuevaCia.executeUpdate();
         
        } // fin de try // fin de try // fin de try // fin de try
            catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
            close();
        } // fin de catch
        
        return resultado;
    } // fin del método 
    /*
    public ResultSet mostrarTabla( String [] campos){
        
       
    }*/
    
    
    public int ActualizarCia(int ciaCod, String ciaNom, String Ruc, String estReg){
        int resultado = 0;
        try {            
                                      
            modificarCia.setString( 1, ciaNom );
            modificarCia.setString(2, Ruc );
            modificarCia.setString( 3, estReg );
            modificarCia.setInt( 4, ciaCod );
            
            resultado = modificarCia.executeUpdate();
                       
         }catch(SQLException e){
            System.out.println(e);
            close();
      }
      return resultado;
    }
    
    public int EliminarCia(int ciaCod){
        int resultado = 0;
        try {            
            eliminarCia.setString( 1, "*" );
            eliminarCia.setInt( 2, ciaCod );
           
            resultado = eliminarCia.executeUpdate();
                       
        }catch(SQLException e){
            System.out.println(e);
            close();
        }
        return resultado;
    }
   
    public Object [][] obtenerTodasLasCiasQueEsten(String criterio_seleccion ){
        if( !criterio_seleccion.equals("A") && !criterio_seleccion.equals("I") && !criterio_seleccion.equals("*")  )
            return null; 
        int registros = 0;      
        String consultaContadora = "Select count(*) as total FROM CIAS WHERE CiaEstReg = '"+criterio_seleccion +"' ";
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
      Object[][] data = new String[registros][3];
      //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           seleccionarTodasLasCiasQueEsten.setString(1, criterio_seleccion);
           ResultSet res = seleccionarTodasLasCiasQueEsten.executeQuery();
           int i = 0;
           while(res.next()){
               data[i][0] = String.valueOf( res.getInt( "CiaCod" ) );
               data[i][1] = res.getString( "CiaNom" );         
               data[i][2] = res.getString( "CiaRUC" );
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
}
