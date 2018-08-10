package systemManager;

public class Book {

	private int id;
	private String bookTitle;
	private int numOfPages;
	private int year;
	private String description;
	private String genre;
	
	public Book(int id, String bookTitle, int numOfPages, int year, String description, String genre) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.numOfPages = numOfPages;
		this.year = year;
		this.description = description;
		this.genre = genre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
