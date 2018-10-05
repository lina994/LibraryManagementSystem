package systemManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import sqlManager.SQLOperations;
import sqlManager.SQLOperationsMySQL;

/**
 * @author Alina
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//build gui
		//connect to database
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Hello,");
		System.out.println("Enter db username:");
		String name= reader.readLine();
		System.out.println("Enter db password:");
		String password= reader.readLine();
		
		SQLOperations operations = new SQLOperationsMySQL(name, password);
		operations.checkDB();
		
		operations.editLibrarianInfo(1,3, "lina", "g", 8222, "gf");
		
		//operations.viewInfoAboutLibrarian(1);
		
		//operations.deleteMasterLibrarian(123456788);

	}
	
	
	
	
	

}