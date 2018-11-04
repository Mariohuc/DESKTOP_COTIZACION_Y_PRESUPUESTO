/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OAD;

import DB.Conector;
import java.sql.Connection;
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
public class PG_L13005_Mantenim_de_Cli {

   
    static {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int agregarClientes( int cliCod, String cliNom, String cliDir, String estReg ){
        int resultado = 0;
        // establece los parámetros, después ejecuta insertarNuevaCia
        Connection conexion = null;
        try{       
            conexion = Conector.conexion();
            // crea instrucción insert para agregar una nueva entrada en la base de datos
            PreparedStatement insertarNuevoCliente = conexion.prepareStatement("INSERT INTO CLIENTES " +
            "( CliCod, CliNom, CliDir, CliEstReg ) " +
            "VALUES ( ?, ?, ?, ? )" );
            insertarNuevoCliente.setInt( 1, cliCod );
            insertarNuevoCliente.setString( 2, cliNom );
            insertarNuevoCliente.setString(3, cliDir );
            insertarNuevoCliente.setString( 4, estReg );
            
            resultado = insertarNuevoCliente.executeUpdate();
        } // fin de try // fin de try // fin de try // fin de try // fin de try // fin de try // fin de try // fin de try
            catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
        } finally {
            close(conexion);
        }// fin de catch 
        
        return resultado;
    } // fin del método 
    
    public int ActualizarClientes(int cliCod, String cliNom, String cliDir, String estReg){
        int resultado = 0;
        Connection conexion = null;
        try{       
            conexion = Conector.conexion();            
            PreparedStatement modificarCliente = conexion.prepareStatement("UPDATE CLIENTES " +
                "SET CliNom = ? ," +
                "CliDir = ? ," +                    
                "CliEstReg = ? " +
                "WHERE CliCod = ? ");                          
            modificarCliente.setString( 1, cliNom );
            modificarCliente.setString(2, cliDir );
            modificarCliente.setString( 3, estReg );
            modificarCliente.setInt( 4, cliCod );
            
            resultado = modificarCliente.executeUpdate();
                       
         }catch(SQLException e){
            System.out.println(e);
        } finally {
            close(conexion);
        }// fin de catch 
        return resultado;
    }
    
    public int EliminarClientes(int cliCod){
        int resultado = 0;
        Connection conexion = null;
        try{       
            conexion = Conector.conexion();
            PreparedStatement eliminarCliente = conexion.prepareStatement("UPDATE CLIENTES " +
                "SET CliEstReg = ? "+
                "WHERE CliCod = ? ");
            eliminarCliente.setString( 1, "*" );
            eliminarCliente.setInt( 2, cliCod );
           
            resultado = eliminarCliente.executeUpdate();
                       
        } catch(SQLException e){
            System.out.println(e);
        }finally {
            close(conexion);
        }// fin de catch 
        return resultado;
    }
    public Object [][] obtenerTodasLosClientesQueEsten( String criterio_seleccion ){
        if( !criterio_seleccion.equals("A") && !criterio_seleccion.equals("I") && !criterio_seleccion.equals("*")  )
            return null;
        
        int registros = 0;      
        String consultaContadora = "Select count(*) as total FROM CLIENTES WHERE CliEstReg = '"+criterio_seleccion+"' ";
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
            //realizamos la consulta sql y llenamos los datos en la matriz "Object"
            // crea una consulta que selecciona todas las entradas en la LibretaDirecciones
            PreparedStatement seleccionarTodosLosClientesQueEsten =
            conexion.prepareStatement( "SELECT * FROM CLIENTES WHERE CliEstReg = ? " );
            seleccionarTodosLosClientesQueEsten.setString(1, criterio_seleccion);
            res = seleccionarTodosLosClientesQueEsten.executeQuery();
            int i = 0;
            while(res.next()){
                data[i][0] = String.valueOf( res.getInt( "CliCod" ) );
                data[i][1] = res.getString( "CliNom" );         
                data[i][2] = res.getString( "CliDir" );
                i++;
            }
            res.close();
        }catch(SQLException e){
           System.out.println(e);
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
