package libraryApp;

public class Book {
	
	private int isbn;
	private String title;
	private String author;
	private String genre;
	private int quantity;
	private int checkedOut;
	private int checkedIn;
	
	//Constructor for book object
	public Book(int isbn, String title, String author, String genre, int quantity, int checkedOut) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.quantity = quantity;
		this.checkedOut = checkedOut;
		this.checkedIn = quantity-checkedOut;
	}

	public int getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(int checkedIn) {
		this.checkedIn = checkedIn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCheckedOut(int checkedOut) {
		this.checkedOut = checkedOut;
	}

	//Getter Methods
	public int getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getCheckedOut() {
		return checkedOut;
	}

	
	
	
}

 
