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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class CodeGenerate {
		
    private static String IDENTIFICADOR;
    private static String TABLA;

    private static String [] entitiesPK = {"CiaCod","CliCod","ArtNum","VenCod","SucCod","CotCabNum"};
    private static String [] dbtables = {"CIAS","CLIENTES","ARTICULOS","VENDEDORES","SUCURSALES","COTIZACION_CAB"};
    private static int [] initvalues = {110010,150010,16010010,170010,10,181010};
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static int getCode(Entities entity){	
        IDENTIFICADOR = entitiesPK[entity.ordinal()];
        TABLA = dbtables[entity.ordinal()];
        int resultado = 0;
        Connection conexion = null; 
        try{
            conexion = Conector.conexion();
            // prepare the query to count the registers from a some table 
            PreparedStatement contarRegistrosPorCodigo = conexion.prepareStatement( "SELECT count("+IDENTIFICADOR+") FROM "+TABLA );
            //execute the query and count the number of register in the selected table 
            ResultSet res  = contarRegistrosPorCodigo.executeQuery();
            res.next();
            resultado = res.getInt(1);
            System.out.println("RESULT: "+resultado);
        } catch ( SQLException excepcionSql ){
            excepcionSql.printStackTrace();
        //} catch (ClassNotFoundException ex) { 
        //    Logger.getLogger(CodeGenerate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conexion);
        }
        return (resultado == 0 )? initvalues[entity.ordinal()] : initvalues[entity.ordinal()] + resultado ;	
    }
        
    private static void close(Connection con){
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
