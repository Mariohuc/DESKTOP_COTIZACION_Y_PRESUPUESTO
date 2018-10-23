package DB;

import java.sql.*;
import javax.swing.*;

public class Conector {

	private static Connection normalconect = null;
	private static Connection testconect = null;
	
	private static boolean TEST_ACTIVE = false;
	
	private Conector(){}
	
	private static void InitializeNormalConector(){
		try {       
			//Cargamos el Driver MySQL
			Class.forName("org.postgresql.Driver");
      normalconect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quote","postgres","admin");
    } catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error "+e);
    }		
	}
	
	private static void InitializeTestConector(){
		try {       
			//Cargamos el Driver MySQL
			Class.forName("org.postgresql.Driver");
      testconect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quotetest","postgres","admin");
    } catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error "+e);
    }		
	}
	
	public static void ChangeToTestMode(){
	  TEST_ACTIVE = true;
	}
	
	public static void ChangeToNormalMode(){
	  TEST_ACTIVE = false;
	}
	
	
	public static Connection conexion() throws SQLException
	{
		if(TEST_ACTIVE ){
			if( testconect == null || testconect.isClosed() ){
				InitializeTestConector();    
			}
			return testconect;
		}
		
		if( normalconect == null || normalconect.isClosed() ){
			InitializeNormalConector();    
		}
		return normalconect;
	}
      
     
}
