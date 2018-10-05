package sqlManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import systemManager.Book;
import systemManager.Librarian;
import systemManager.MasterLibrarian;
import systemManager.Reader;


// TODO Check the existence of all the tables and, if necessary, produce them


public class SQLOperationsMySQL implements SQLOperations {
	//jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false
	
	String urlForCheck ="jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	String url ="jdbc:mysql://localhost:3306/librarydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	String name;
	String password;
	
	

	public SQLOperationsMySQL(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@Override
	public void checkDB() {
        try(Connection con = DriverManager.getConnection(urlForCheck, name, password);
        		Statement st = con.createStatement();){
    	    if(!con.isClosed()) { 
    	    	System.out.println("Start database check.");
    	    	st.executeUpdate("CREATE DATABASE IF NOT EXISTS librarydb;");
    	    	st.executeUpdate("USE librarydb;");
    	    	
    	    	st.executeUpdate("CREATE TABLE IF NOT EXISTS librarians"+ 
    					" (" + 
    					"  `id` INT NOT NULL,\r\n" + 
    					"  `first_name` VARCHAR(45) NOT NULL,\r\n" + 
    					"  `last_name` VARCHAR(45) NOT NULL,\r\n" + 
    					"  `phone` INT NOT NULL,\r\n" + 
    					"  `address` VARCHAR(45) NOT NULL,\r\n" + 
    					"  `isMaster` TINYINT NOT NULL DEFAULT 0,\r\n" + 
    					"  PRIMARY KEY (`id`),\r\n" + 
    					"  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)\r\n" + 
		    			"ENGINE = InnoDB\r\n" + 
		    			"DEFAULT CHARACTER SET = utf8mb4\r\n" + 
		    			"COLLATE = utf8mb4_0900_ai_ci;\r\n");
    	    	
    	    	st.executeUpdate("CREATE TABLE IF NOT EXISTS readers" + 
    	    			" (" + 
    	    			"  `id` INT NOT NULL,\r\n" + 
    	    			"  `first_name` VARCHAR(45) NOT NULL,\r\n" + 
    	    			"  `last_name` VARCHAR(45) NOT NULL,\r\n" + 
    	    			"  `phone` INT NOT NULL,\r\n" + 
    	    			"  `address` VARCHAR(45) NOT NULL,\r\n" + 
    	    			"  PRIMARY KEY (`id`),\r\n" + 
    	    			"  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)\r\n" + 
    	    			"ENGINE = InnoDB\r\n" + 
    	    			"DEFAULT CHARACTER SET = utf8mb4\r\n" + 
    	    			"COLLATE = utf8mb4_0900_ai_ci;\r\n");
    	    	
    	    	
    	    	
    	    	
    	    }
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
        	System.out.println("Database check completed successfully.");
        }
	}
	
	
	
	
	@Override
	public void addMasterLibrarian(int id, String firstName, String lastName, int phone, String address) {
		addLibrarian(id, firstName, lastName, phone, address, true);
	}

	@Override
	public void deleteMasterLibrarian(int id) {
		deleteLibrarian(id);
	}

	@Override
	public void addMinorLibrarian(int id, String firstName, String lastName, int phone, String address) {
		addLibrarian(id, firstName, lastName, phone, address, false);
	}

	@Override
	public void deleteMinorLibrarian(int id) {
		deleteLibrarian(id);
	}

	@Override
	public Librarian viewInfoAboutLibrarian(int id) {
		Librarian librarian = null;
		try(Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();){
			if(!con.isClosed()) { 	
				System.out.println("Connected.");	
				ResultSet rs = st.executeQuery("SELECT * FROM librarians WHERE id="+id+";");
				if(!rs.next()) {
					System.out.println("Record not found.");	
				}
				else if(rs.getBoolean("isMaster")) {
					librarian = new MasterLibrarian(
							rs.getInt("id"), 
							rs.getString("first_name"), 
							rs.getString("last_name"), 
							rs.getString("phone"), 
							rs.getString("address"));
				}
				else {
					librarian = new Librarian(
							rs.getInt("id"), 
							rs.getString("first_name"), 
							rs.getString("last_name"), 
							rs.getString("phone"), 
							rs.getString("address"));
				}
			}
		} catch (SQLException e) {
	        	e.printStackTrace();  
		} finally {
	        	System.out.println("Disconnected.");
		}	
		return librarian;
	}

	@Override
	public void editLibrarianInfo(int oldId, int newId, String firstName, String lastName, int phone, String address) {
		try(Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement ps = createPreparedEditLibrarianInfo(con, oldId, newId, firstName, lastName, phone, address);){
			if(!con.isClosed()) { 	
				System.out.println("Connected.");	
				int rs = ps.executeUpdate();
				if(rs!=1) System.out.println("Failed to change record.");
			}
		} catch (SQLException e) {
	        	e.printStackTrace();  
		} finally {
	        	System.out.println("Disconnected.");
		}
	}
	
	@Override
	public void editIsMasterLibrarian(int id, Boolean isMaster) {
		try(Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();){
			if(!con.isClosed()) { 	
				System.out.println("Connected.");	
				int rs = st.executeUpdate("UPDATE librarians SET isMaster = "+id+" WHERE id = "+isMaster+";");
				if(rs!=1) System.out.println("Failed to change record.");
			}
		} catch (SQLException e) {
	        	e.printStackTrace();  
		} finally {
	        	System.out.println("Disconnected.");
		}	
	}

	@Override
	public void addNewReader(int id, String firstName, String lastName, int phone, String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReader(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reader getReaderInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addNewBook(String bookTitle, int numOfPages, int year, String description, String genre) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeBook(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book viewBookInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book viewBookInfo(String bookTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBookInfo(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrowBooks(int bookID, int readerID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReturnBooks(int bookID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book[] getFullBooksList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] getFreeBooksList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] getBorrowedBooksList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] getNotReturnedInTimeBooksList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	private void addLibrarian(int id, String firstName, String lastName, int phone, String address, boolean isMaster) {
		try(Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement ps = createPreparedAddLibrarian(con, id, firstName, lastName, phone, address, isMaster);){
			if(!con.isClosed()) { 	
				System.out.println("Connected.");	
				int rs = ps.executeUpdate();
				if(rs!=1) System.out.println("Failed to add record.");
			}
		} catch (SQLException e) {
	        	e.printStackTrace();  
		} finally {
	        	System.out.println("Disconnected.");
		}
	}
	
	private PreparedStatement createPreparedAddLibrarian(Connection con, int id, String firstName, String lastName, int phone, String address, Boolean isMaster) throws SQLException {
		String sql = "INSERT INTO librarians (id, first_name, last_name, phone, address) VALUES (?, ?, ?, ?, ?, ?);";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, id);
	    ps.setString(2, firstName);
	    ps.setString(3, lastName);
	    ps.setInt(4, phone);
	    ps.setString(5, address);
	    ps.setBoolean(6, isMaster);
	    return ps;
	}
	
	
	private void deleteLibrarian(int id) {
		try(Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement ps = createPreparedDeleteLibrarian(con, id);){
			if(!con.isClosed()) { 	
				System.out.println("Connected.");	
				int rs = ps.executeUpdate();
				if(rs!=1) System.out.println("Failed to delete record.");
			}
		} catch (SQLException e) {
	        	e.printStackTrace();  
		} finally {
	        	System.out.println("Disconnected.");
		}		
	}
	
	private PreparedStatement createPreparedDeleteLibrarian(Connection con, int id) throws SQLException {
		String sql = "DELETE FROM librarians WHERE id = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps;
		
	}
	
	
	private PreparedStatement createPreparedEditLibrarianInfo(Connection con, int oldId, int newId, String firstName, String lastName, int phone, String address) throws SQLException {
		String sql = "UPDATE librarians "
				+ "SET id = ?, first_name = ?, last_name = ?, phone = ?, address = ?"
				+ "WHERE id=?;";
		
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, newId);
	    ps.setString(2, firstName);
	    ps.setString(3, lastName);
	    ps.setInt(4, phone);
	    ps.setString(5, address);
	    ps.setInt(6, oldId);
	    return ps;
	}
	
	
}
