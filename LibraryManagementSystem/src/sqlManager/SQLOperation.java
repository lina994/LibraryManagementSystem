package sqlManager;

import systemManager.Book;
import systemManager.Librarian;
import systemManager.Reader;

public interface SQLOperation {
	
	public void addMasterLibrarian(int id, String password, String firstName, String lastName, String phone, String address);
	public void deleteMasterLibrarian(int id);
	public void addLibrarian(int id, String password, String firstName, String lastName, String phone, String address);
	public void deleteLibrarian(int id);
	public Librarian viewInfoAboutLibrarian(int id);
	public void editLibrarianInfo(int id, String password, String firstName, String lastName, String phone, String address);
	
	public void addNewReader(int id, String firstName, String lastName, String phone, String address);
	public void deleteReader(int id);
	public Reader getReaderInfo(int id);
	
	public int addNewBook(String bookTitle, int numOfPages, int year, String description, String genre);
	public void removeBook(int id);
	public Book viewBookInfo(int id);
	public Book viewBookInfo(String bookTitle);
	public void updateBookInfo(int id);
	
	public void borrowBooks(int bookID, int readerID);
	public void ReturnBooks(int bookID);
	
	public Book[] getFullBooksList();               // TODO change return type(pair, struct,...)
	public Book[] getFreeBooksList();               // TODO change return type
	public Book[] getBorrowedBooksList();           // TODO change return type
	public Book[] getNotReturnedInTimeBooksList();  // TODO change return type

}
