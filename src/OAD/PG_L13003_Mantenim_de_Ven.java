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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MARIO HUAYPUNA
 */
public class PG_L13003_Mantenim_de_Ven {
    
     
    static {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int agregarVendedor( int venCod, String venNom, int tel, String email ,String estReg ){
        int resultado = 0;
        // establece los parámetros, después ejecuta insertarNuevaCia
        Connection conexion = null;
        try{
            conexion = Conector.conexion();
            // crea instrucción insert para agregar una nueva entrada en la base de datos
            PreparedStatement insertarNuevoVendedor = conexion.prepareStatement("INSERT INTO VENDEDORES " +
            "( VenCod, VenNom, VenTel, VenEmail, VenEstReg ) " +
            "VALUES ( ?, ?, ?, ?, ? )" );
            insertarNuevoVendedor.setInt( 1, venCod );
            insertarNuevoVendedor.setString( 2, venNom );
            insertarNuevoVendedor.setInt(3, tel );
            insertarNuevoVendedor.setString( 4, email );
            insertarNuevoVendedor.setString(5, estReg);
            
            resultado = insertarNuevoVendedor.executeUpdate();
        } // fin de try // fin de try // fin de try // fin de try
        catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
        //} catch (ClassNotFoundException ex) {
        //    Logger.getLogger(PG_L13003_Mantenim_de_Ven.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conexion);
        }// fin de catch 
        
        return resultado;
    } // fin del método 
    
    public int ActualizarVendedores(int venCod, String venNom, int tel, String email ,String estReg){
        int resultado = 0;
        Connection conexion = null;
        try{
            conexion = Conector.conexion();
            PreparedStatement modificarVendedor = conexion.prepareStatement("UPDATE VENDEDORES " +
                "SET VenNom = ? ," +
                "VenTel = ? ," +                    
                "VenEmail = ? ," +
                "VenEstReg = ? "+
                "WHERE VenCod = ? ");
            modificarVendedor.setString( 1, venNom );
            modificarVendedor.setInt(2, tel );
            modificarVendedor.setString( 3, email );
            modificarVendedor.setString(4, estReg);
            modificarVendedor.setInt( 5, venCod );
            
            resultado = modificarVendedor.executeUpdate();
                       
         }catch(SQLException e){
            System.out.println(e);
        //} catch (ClassNotFoundException ex) {
        //    Logger.getLogger(PG_L13003_Mantenim_de_Ven.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conexion);
        }// fin de catch 
        return resultado;
    }
    
    public int EliminarVendedor(int venCod){
        int resultado = 0;
        Connection conexion = null;
        try {
            conexion = Conector.conexion();
            PreparedStatement eliminarVendedor = conexion.prepareStatement("UPDATE VENDEDORES " +
                "SET VenEstReg = ? "+
                "WHERE VenCod = ? ");            
            eliminarVendedor.setString( 1, "*" );
            eliminarVendedor.setInt( 2, venCod );
           
            resultado = eliminarVendedor.executeUpdate();
                       
        }catch(SQLException e){
            System.out.println(e);
        //} catch (ClassNotFoundException ex) {
        //    Logger.getLogger(PG_L13003_Mantenim_de_Ven.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conexion);
        }// fin de catch 
        return resultado;
    }
    
    public Object [][] obtenerTodasLosVendedoresQueEsten(String criterio_seleccion){
        if( !criterio_seleccion.equals("A") && !criterio_seleccion.equals("I") && !criterio_seleccion.equals("*")  )
            return null;
        
        int registros = 0;      
        String consultaContadora = "Select count(*) as total FROM VENDEDORES WHERE VenEstReg = '"+criterio_seleccion+"' ";
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
            data = new String[registros][4];
            //realizamos la consulta sql y llenamos los datos en la matriz "Object"
            // crea una consulta que selecciona todas las entradas en la LibretaDirecciones
            PreparedStatement seleccionarTodosLosVendedoresQueEsten =
            conexion.prepareStatement( "SELECT * FROM VENDEDORES WHERE VenEstReg = ?" );
            seleccionarTodosLosVendedoresQueEsten.setString(1, criterio_seleccion);
            res = seleccionarTodosLosVendedoresQueEsten.executeQuery();
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
        //} catch (ClassNotFoundException ex) {
        //    Logger.getLogger(PG_L13003_Mantenim_de_Ven.class.getName()).log(Level.SEVERE, null, ex);
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
