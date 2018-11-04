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
/**
 *
 * @author MARIO HUAYPUNA
 */
public class PG_L13004_Mantenim_de_Suc {
    
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int agregarSucursal( int sucCod, String sucDes, String estReg, int ciaCod ){
        int resultado = 0;
        // establece los parámetros, después ejecuta insertarNuevaCia
        Connection conexion = null;
        try{
            conexion = Conector.conexion();
            // crea instrucción insert para agregar una nueva entrada en la base de datos
            PreparedStatement insertarNuevaSucursal = conexion.prepareStatement("INSERT INTO SUCURSALES " +
            "( SucCod, SucDes, SucEstReg, CiaCod ) " +
            "VALUES ( ?, ?, ?, ?)" );
            insertarNuevaSucursal.setInt( 1, sucCod );
            insertarNuevaSucursal.setString( 2, sucDes );
            insertarNuevaSucursal.setString(3, estReg );
            insertarNuevaSucursal.setInt( 4, ciaCod );
            
            resultado = insertarNuevaSucursal.executeUpdate();
        } // fin de try // fin de try // fin de try // fin de try
            catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
        //} catch (ClassNotFoundException ex) {
        //    Logger.getLogger(PG_L13004_Mantenim_de_Suc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conexion);
        }// fin de catch
        
        return resultado;
    } // fin del método 
    
    public int ActualizarSucursal(int sucCod, String sucDes, String estReg, int ciaCod){
        int resultado = 0;
        Connection conexion = null;
        try{
            conexion = Conector.conexion();            
            PreparedStatement modificarSucursal = conexion.prepareStatement("UPDATE SUCURSALES " +
                "SET SucDes = ? ," +
                "SucEstReg = ? ," +                    
                "CiaCod = ? " +
                "WHERE SucCod = ? ");                                    
            modificarSucursal.setString( 1, sucDes );
            modificarSucursal.setString(2, estReg );
            modificarSucursal.setInt( 3, ciaCod );
            modificarSucursal.setInt( 4, sucCod );
            
            resultado = modificarSucursal.executeUpdate();
                       
        }catch(SQLException e){
            System.out.println(e);
        //} catch (ClassNotFoundException ex) {
        //    Logger.getLogger(PG_L13004_Mantenim_de_Suc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conexion);
        }// fin de catch
        return resultado;
    }
    
    public int EliminarSucursal(int sucCod){
        int resultado = 0;
        Connection conexion = null;
        try{
            conexion = Conector.conexion();   
            PreparedStatement eliminarSucursal = conexion.prepareStatement("UPDATE SUCURSALES " +
                "SET SucEstReg = ? "+
                "WHERE SucCod = ? ");
            eliminarSucursal.setString( 1, "*" );
            eliminarSucursal.setInt( 2, sucCod );
           
            resultado = eliminarSucursal.executeUpdate();
                       
        }catch(SQLException e){
            System.out.println(e);
        } finally {
            close(conexion);
        }// fin de catch
        return resultado;
    }
    
    public Object [][] obtenerTodasLasSucursalesActivas( String criterio_seleccion ){
        if( !criterio_seleccion.equals("A") && !criterio_seleccion.equals("I") && !criterio_seleccion.equals("*")  )
            return null;
        
        int registros = 0;      
        String consultaContadora = "Select count(*) as total FROM SUCURSALES WHERE SucEstReg = '"+criterio_seleccion+"' ";
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
            PreparedStatement seleccionarTodasLasSucursalesQueEsten =
            conexion.prepareStatement( "SELECT * FROM SUCURSALES WHERE SucEstReg = ?" );
            seleccionarTodasLasSucursalesQueEsten.setString(1, criterio_seleccion);
            res = seleccionarTodasLasSucursalesQueEsten.executeQuery();
            int i = 0;
            while(res.next()){
                data[i][0] = String.valueOf( res.getInt( "SucCod" ) );
                data[i][1] = res.getString( "SucDes" );         
                data[i][2] = String.valueOf( res.getInt( "CiaCod" ) );
               i++;
            }
            res.close();
        }catch(SQLException e){
           System.out.println(e);
        } finally {
            close(conexion);
        }// fin de catch 
      
        return data;   
    } // fin del método obtenerTodasLasPersonaas
    
    public Object [][] obtenerSucursalesDeCiaActivas( String criterio_seleccion, String codigoCia ){
        if( !criterio_seleccion.equals("A") && !criterio_seleccion.equals("I") && !criterio_seleccion.equals("*")  )
            return null;
        
        int registros = 0;      
        String consultaContadora = "Select count(*) as total FROM SUCURSALES WHERE SucEstReg = '"+criterio_seleccion+"' "
                + "AND CiaCod = "+codigoCia;
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
            PreparedStatement seleccionarLasSucursalesDeCiaQueEsten =
            conexion.prepareStatement( "SELECT * FROM SUCURSALES WHERE SucEstReg = '"+criterio_seleccion+"' AND CiaCod ="+codigoCia );
           
            res = seleccionarLasSucursalesDeCiaQueEsten.executeQuery();
            int i = 0;
            while(res.next()){
                data[i][0] = String.valueOf( res.getInt( "SucCod" ) );
                data[i][1] = res.getString( "SucDes" );         
                data[i][2] = String.valueOf( res.getInt( "CiaCod" ) );
               i++;
            }
            res.close();
        }catch(SQLException e){
           System.out.println(e);
        } finally {
            close(conexion);
        }// fin de catch 

        return data;   
    } // fin del método obtenerTodasLasPersonaas
    
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
