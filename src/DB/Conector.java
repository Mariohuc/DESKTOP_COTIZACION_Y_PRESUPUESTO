package DB;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Sony
 */

public class Conector {
    
    private static Connection conect = null;
    
    private Conector(){};
    
    public static Connection conexion()
    {
        if( conect != null ){
            return conect;
        }else{
            try {
                //Cargamos el Driver MySQL
                Class.forName("org.postgresql.Driver");
                conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quotetest","postgres","admin");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error "+e);
            }
            return conect;
        }
        
    }
    
    
}
