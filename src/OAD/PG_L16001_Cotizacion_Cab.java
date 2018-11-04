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
import java.util.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MARIO HUAYPUNA
 */
public class PG_L16001_Cotizacion_Cab {

    
    static {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int agregarCotizacionCab( int CotCabNum, String CotCabFecEmi, String CotCabGar, String CotCabPlazEnt, String CotCabForPag, String CotCabEstReg ,
            int CliCod, int VenCod, int SucCod, int CiaCod ){
        int resultado = 0;
        // establece los parámetros, después ejecuta insertarNuevoArticulo
        Connection conexion = null;
        try{       
            conexion = Conector.conexion();
            // crea instrucción insert para agregar una nueva entrada en la base de datos
            PreparedStatement insertarNuevaCotizacionCab = conexion.prepareStatement("INSERT INTO COTIZACION_CAB " +
            "( CotCabNum, CotCabFecEmi, CotCabGar, CotCabPlazEnt, CotCabForPag, CotCabEstReg ,CliCod, VenCod, SucCod, CiaCod) " +
            "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )" );
            insertarNuevaCotizacionCab.setInt( 1, CotCabNum );
            insertarNuevaCotizacionCab.setString(2,CotCabFecEmi);
            insertarNuevaCotizacionCab.setString( 3, CotCabGar );
            insertarNuevaCotizacionCab.setString( 4, CotCabPlazEnt );
            insertarNuevaCotizacionCab.setString( 5, CotCabForPag );
            insertarNuevaCotizacionCab.setString( 6, CotCabEstReg  );
            insertarNuevaCotizacionCab.setInt(7, CliCod);
            insertarNuevaCotizacionCab.setInt(8, VenCod);
            insertarNuevaCotizacionCab.setInt(9, SucCod);
            insertarNuevaCotizacionCab.setInt(10, CiaCod);
            
            resultado = insertarNuevaCotizacionCab.executeUpdate();
        } // fin de try // fin de try // fin de try // fin de try
            catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
        } finally {
            close(conexion);
        }// fin de catch 
        
        return resultado;
    } // fin del método agregarPersona
    
    public int ActualizarCotizacionCab( int CotCabNum, String CotCabFecEmi, String CotCabGar, String CotCabPlazEnt, String CotCabForPag, String CotCabEstReg ,
            int CliCod, int VenCod, int SucCod, int CiaCod  ){
        int resultado = 0;
        Connection conexion = null;
        try{       
            conexion = Conector.conexion();           
            PreparedStatement modificarCotizacionCab = conexion.prepareStatement("UPDATE COTIZACION_CAB " +
                "SET CotCabFecEmi = ? ," +
                "CotCabGar = ? ," +                    
                "CotCabPlazEnt = ? ," +
                "CotCabForPag = ? ,"+
                "CotCabEstReg = ?, "+
                "CliCod = ?, "+
                "VenCod = ?, "+
                "SucCod = ?, "+
                "CiaCod = ? "+    
                "WHERE CotCabNum = ? ");
            modificarCotizacionCab.setString(1, CotCabFecEmi);
            modificarCotizacionCab.setString( 2, CotCabGar );
            modificarCotizacionCab.setString( 3, CotCabPlazEnt );
            modificarCotizacionCab.setString( 4, CotCabForPag );
            modificarCotizacionCab.setString( 5, CotCabEstReg  );
            modificarCotizacionCab.setInt(6, CliCod);
            modificarCotizacionCab.setInt(7, VenCod);
            modificarCotizacionCab.setInt(8, SucCod);
            modificarCotizacionCab.setInt(9, CiaCod);
            modificarCotizacionCab.setInt(10, CotCabNum );
            
            resultado = modificarCotizacionCab.executeUpdate();
                       
        }catch(SQLException e){
            System.out.println(e);
        } finally {
            close(conexion);
        }// fin de catch
      return resultado;
    }
    
    public Object [][] obtenerTodasLosCotizacionCabQueEsten( String criterio_seleccion ){
        if( !criterio_seleccion.equals("A") && !criterio_seleccion.equals("I") && !criterio_seleccion.equals("*")  )
            return null;
        
        int registros = 0;      
        String consultaContadora = "Select count(*) as total FROM COTIZACION_CAB WHERE CotCabEstReg = '"+criterio_seleccion+"' ";
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
            data = new String[registros][9];
            //realizamos la consulta sql y llenamos los datos en la matriz "Object"
             // crea una consulta que selecciona todas las entradas en la LibretaDirecciones
            PreparedStatement seleccionarTodasLasCotizacionesCabActivas =
            conexion.prepareStatement( "SELECT * FROM COTIZACION_CAB WHERE CotCabEstReg = ? " );
            seleccionarTodasLasCotizacionesCabActivas.setString(1, criterio_seleccion);
            res = seleccionarTodasLasCotizacionesCabActivas.executeQuery();
            int i = 0;
            while(res.next()){
                data[i][0] = String.valueOf( res.getInt( "CotCabNum" ) );
                data[i][1] = res.getString("CotCabFecEmi");         
                data[i][2] = res.getString("CotCabGar" );
                data[i][3] = res.getString("CotCabPlazEnt");
                data[i][4] = res.getString("CotCabForPag");
                data[i][5] = String.valueOf(res.getInt("CliCod"));
                data[i][6] = String.valueOf(res.getInt("VenCod"));
                data[i][7] = String.valueOf(res.getInt("SucCod"));
                data[i][8] = String.valueOf(res.getInt("CiaCod"));
                i++;
            }
            res.close();
        } catch(SQLException e){
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
