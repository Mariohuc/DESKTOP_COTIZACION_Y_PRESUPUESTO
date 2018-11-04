package DB;

import java.sql.*;
import javax.swing.*;

public class Conector {
	
    private static boolean TEST_ACTIVE = false;

    private Conector(){}

    public static void ChangeToTestMode(){
      TEST_ACTIVE = true;
    }

    public static void ChangeToNormalMode(){
      TEST_ACTIVE = false;
    }


    public static Connection conexion() throws SQLException
    {
        if(TEST_ACTIVE ){
            //Cargamos el Driver MySQL
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/quotetest","postgres","admin");                                
        }   
        return DriverManager.getConnection("jdbc:postgresql://baasu.db.elephantsql.com:5432/yqjahnco","yqjahnco","u8XP-AllX2IKNWairumrtnHs6kVkmm8N");            
    }
      
     
}
