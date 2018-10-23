/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Generator;

import DB.Conector;
import static DB.Conector.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class CodeGenerate {
	
	private static Connection conexion = null; 
	private static PreparedStatement contarRegistrosPorCodigo = null;
		
	private static String IDENTIFICADOR;
	private static String TABLA;
		
	private static String [] entitiesPK = {"CiaCod","CliCod","ArtNum","VenCod","SucCod","CotCabNum"};
	private static String [] dbtables = {"CIAS","CLIENTES","ARTICULOS","VENDEDORES","SUCURSALES","COTIZACION_CAB"};
	private static int [] initvalues = {110010,150010,16010010,170010,10,181010};
	
	private static void initQuery(){
		try{
		conexion = Conector.conexion();
			// crea una consulta que selecciona todas las entradas en la LibretaDirecciones
			contarRegistrosPorCodigo =
			conexion.prepareStatement( "SELECT count("+IDENTIFICADOR+") FROM "+TABLA );
		} catch ( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
			System.exit( 1 );
		} 
	}
	
	private static int contar(){
		int resultado = 0;
		// establece los parámetros, después ejecuta insertarNuevaCia
		try{           
				ResultSet res  = contarRegistrosPorCodigo.executeQuery();
				res.next();
        resultado = res.getInt(1);
				
		} // fin de try // fin de try // fin de try // fin de try
		catch ( SQLException excepcionSql ){
				excepcionSql.printStackTrace();			
				close();
		} // fin de catch

		return resultado;
  } // fin del método 
	
	public static int getCode(Entities entity){	
		IDENTIFICADOR = entitiesPK[entity.ordinal()];
		TABLA = dbtables[entity.ordinal()];
		initQuery();
		int resultado = contar();
		return (resultado == 0 )? initvalues[entity.ordinal()] : initvalues[entity.ordinal()] + resultado ;
		
		
	}
	public static void close(){
        try{
            conexion.close();
        } // fin de try
        catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
        } // fin de catch
    } // fin del método close
	
}
