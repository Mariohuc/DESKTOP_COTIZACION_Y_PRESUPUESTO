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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MARIO HUAYPUNA
 */
public class PG_L13003_Mantenim_de_Ven {
    
    private Connection conexion = null; // maneja la conexión
    private PreparedStatement seleccionarTodosLosVendedoresQueEsten = null;
    private PreparedStatement seleccionarVendedoresPorCodigo = null;
    private PreparedStatement insertarNuevoVendedor = null;
    private PreparedStatement modificarVendedor = null;
    private PreparedStatement eliminarVendedor = null;
    
    public PG_L13003_Mantenim_de_Ven(){
        try{
            
            conexion = Conector.conexion();
            // crea una consulta que selecciona todas las entradas en la LibretaDirecciones
            seleccionarTodosLosVendedoresQueEsten =
            conexion.prepareStatement( "SELECT * FROM VENDEDORES WHERE VenEstReg = ?" );
           
            // crea una consulta que selecciona las entradas con un apellido específico
            seleccionarVendedoresPorCodigo = conexion.prepareStatement(
            "SELECT * FROM VENDEDORES WHERE VenCod = ?" );

            // crea instrucción insert para agregar una nueva entrada en la base de datos
            insertarNuevoVendedor = conexion.prepareStatement("INSERT INTO VENDEDORES " +
            "( VenCod, VenNom, VenTel, VenEmail, VenEstReg ) " +
            "VALUES ( ?, ?, ?, ?, ? )" );
            
            modificarVendedor = conexion.prepareStatement("UPDATE VENDEDORES " +
                "SET VenNom = ? ," +
                "VenTel = ? ," +                    
                "VenEmail = ? ," +
                "VenEstReg = ? "+
                "WHERE VenCod = ? ");
            
            eliminarVendedor = conexion.prepareStatement("UPDATE VENDEDORES " +
                "SET VenEstReg = ? "+
                "WHERE VenCod = ? ");
            
        } catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
            System.exit( 1 );
        } 
		}
    
    public int agregarVendedor( int venCod, String venNom, int tel, String email ,String estReg ){
        int resultado = 0;
        // establece los parámetros, después ejecuta insertarNuevaCia
        try{
            insertarNuevoVendedor.setInt( 1, venCod );
            insertarNuevoVendedor.setString( 2, venNom );
            insertarNuevoVendedor.setInt(3, tel );
            insertarNuevoVendedor.setString( 4, email );
            insertarNuevoVendedor.setString(5, estReg);
            
            resultado = insertarNuevoVendedor.executeUpdate();
        } // fin de try // fin de try // fin de try // fin de try
        catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
            close();
        } // fin de catch
        
        return resultado;
    } // fin del método 
    
    public int ActualizarVendedores(int venCod, String venNom, int tel, String email ,String estReg){
        int resultado = 0;
        try {                                               
            modificarVendedor.setString( 1, venNom );
            modificarVendedor.setInt(2, tel );
            modificarVendedor.setString( 3, email );
            modificarVendedor.setString(4, estReg);
            modificarVendedor.setInt( 5, venCod );
            
            resultado = modificarVendedor.executeUpdate();
                       
         }catch(SQLException e){
            System.out.println(e);
            close();
        }
        return resultado;
    }
    
    public int EliminarVendedor(int venCod){
        int resultado = 0;
        try {            
            eliminarVendedor.setString( 1, "*" );
            eliminarVendedor.setInt( 2, venCod );
           
            resultado = eliminarVendedor.executeUpdate();
                       
        }catch(SQLException e){
            System.out.println(e);
            close();
        }
        return resultado;
    }
    
    public Object [][] obtenerTodasLosVendedoresQueEsten(String criterio_seleccion){
        if( !criterio_seleccion.equals("A") && !criterio_seleccion.equals("I") && !criterio_seleccion.equals("*")  )
            return null;
        
        int registros = 0;      
        String consultaContadora = "Select count(*) as total FROM VENDEDORES WHERE VenEstReg = '"+criterio_seleccion+"' ";
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
      Object[][] data = new String[registros][4];
      //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try{
           seleccionarTodosLosVendedoresQueEsten.setString(1, criterio_seleccion);
           ResultSet res = seleccionarTodosLosVendedoresQueEsten.executeQuery();
           int i = 0;
           while(res.next()){
               data[i][0] = String.valueOf( res.getInt( "VenCod" ) );
               data[i][1] = res.getString( "VenNom" );         
               data[i][2] = String.valueOf( res.getInt( "VenTel" ) );
               data[i][3] = res.getString( "VenEmail" );
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
