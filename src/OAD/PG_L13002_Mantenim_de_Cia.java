/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OAD;

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
	  
    /*
    Data Manipulation Language (DML) as INSERT, UPDATE, DELETE, ...
    Data Definition Language (DDL) as CREATE TABLE, DROP etc.

    ExecuteUpdate()
    Return:	Ya sea (1) el recuento de filas para las declaraciones del lenguaje de manipulación de datos SQL (DML) 
    o (2) 0 para las declaraciones de SQL que no devuelven nada.
    */
		
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int agregarCia( int ciaCod, String ciaNom, String Ruc, String estReg ){
        int resultado = 0;
        // establece los parámetros, después ejecuta insertarNuevaCia
        Connection conexion = null;
        try{
            conexion = Conector.conexion();
            // crea instrucción insert para agregar una nueva entrada en la base de datos
            PreparedStatement insertarNuevaCia = conexion.prepareStatement("INSERT INTO CIAS " +
            "( CiaCod, CiaNom, CiaRUC, CiaEstReg ) " +
            "VALUES ( ?, ?, ?, ? )" );
            insertarNuevaCia.setInt( 1, ciaCod );
            insertarNuevaCia.setString( 2, ciaNom );
            insertarNuevaCia.setString(3, Ruc );
            insertarNuevaCia.setString( 4, estReg );
            
            resultado = insertarNuevaCia.executeUpdate();
         
        } // fin de try // fin de try // fin de try // fin de try
            catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
        //} catch (ClassNotFoundException ex) {
        //    Logger.getLogger(PG_L13002_Mantenim_de_Cia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conexion);
        }// fin de catch 
        
        return resultado;
    } // fin del método 
    /*
    public ResultSet mostrarTabla( String [] campos){
        
       
    }*/
    
    
    public int ActualizarCia(int ciaCod, String ciaNom, String Ruc, String estReg){
        int resultado = 0;
        Connection conexion = null;
        try {            
            conexion = Conector.conexion();
            PreparedStatement modificarCia = conexion.prepareStatement("UPDATE CIAS " +
                "SET CiaNom = ? ," +
                "CiaRUC = ? ," +                    
                "CiaEstReg = ? " +
                "WHERE CiaCod = ? ");
            modificarCia.setString( 1, ciaNom );
            modificarCia.setString(2, Ruc );
            modificarCia.setString( 3, estReg );
            modificarCia.setInt( 4, ciaCod );
            
            resultado = modificarCia.executeUpdate();
                       
         }catch(SQLException e){
            System.out.println(e);
        //} catch (ClassNotFoundException ex) {
        //    Logger.getLogger(PG_L13002_Mantenim_de_Cia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conexion);
        }// fin de catch 
        return resultado;
    }
    
    public int EliminarCia(int ciaCod){
        int resultado = 0;
        Connection conexion = null;
        try {            
            conexion = Conector.conexion();
            PreparedStatement eliminarCia = conexion.prepareStatement("UPDATE CIAS " +
                "SET CiaEstReg = ? "+
                "WHERE CiaCod = ? ");            
            eliminarCia.setString( 1, "*" );
            eliminarCia.setInt( 2, ciaCod );
           
            resultado = eliminarCia.executeUpdate();
                       
        }catch(SQLException e){
            System.out.println(e);
        //} catch (ClassNotFoundException ex) {
        //    Logger.getLogger(PG_L13002_Mantenim_de_Cia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conexion);
        }// fin de catch 
        return resultado;
    }
   
    public Object [][] obtenerTodasLasCiasQueEsten(String criterio_seleccion ){
        if( !criterio_seleccion.equals("A") && !criterio_seleccion.equals("I") && !criterio_seleccion.equals("*")  )
            return null; 
        int registros = 0;      
        String consultaContadora = "Select count(*) as total FROM CIAS WHERE CiaEstReg = '"+criterio_seleccion +"' ";
        //obtenemos la cantidad de registros existentes en la tabla
        Connection conexion = null;
        Object[][] data = null;
        try{
            conexion = Conector.conexion();
            PreparedStatement pstm = conexion.prepareStatement( consultaContadora );
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            //se crea una matriz con tantas filas y columnas que necesite
            data = new String[registros][3];
            
            // crea una consulta que selecciona todas las entradas en la LibretaDirecciones
            PreparedStatement seleccionarTodasLasCiasQueEsten = conexion.prepareStatement( "SELECT * FROM CIAS WHERE CiaEstReg = ? " );
            //realizamos la consulta sql y llenamos los datos en la matriz "Object"
            seleccionarTodasLasCiasQueEsten.setString(1, criterio_seleccion);
            res = seleccionarTodasLasCiasQueEsten.executeQuery();
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
        //} catch (ClassNotFoundException ex) {
        //    Logger.getLogger(PG_L13002_Mantenim_de_Cia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conexion);
        }// fin de catch 
      
        return data;   
    } // fin del método
    
    
    private void close(Connection con){
        if(con == null)
            return;
        
        try{
            con.close();
        } // fin de try
        catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
        } // fin de catch
    } // fin del método close
}
