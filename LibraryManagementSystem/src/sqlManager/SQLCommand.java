package sqlManager;

import systemManager.Book;
import systemManager.Librarian;
import systemManager.Reader;

public class SQLCommand implements SQLOperation {

	@Override
	public void addMasterLibrarian(int id, String password, String firstName, String lastName, String phone,
			String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMasterLibrarian(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLibrarian(int id, String password, String firstName, String lastName, String phone, String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLibrarian(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Librarian viewInfoAboutLibrarian(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editLibrarianInfo(int id, String password, String firstName, String lastName, String phone,
			String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewReader(int id, String firstName, String lastName, String phone, String address) {
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
	
	
	
	
}
