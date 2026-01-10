package libraryApp;

public class LibraryApp {
	
	BookRepository repo = new BookRepository();
	
	public void findByTitle(String title) {
		repo.searchByTitle(title);
		return;
	}
	public void findByISBN(int isbn) {
		repo.searchByISBN(isbn);
		return;
	}
	public boolean findByGenre(String genre) {
		if(repo.searchByGenre(genre))
			return true;
		else 
			return false;
	}
	
	
	public int findISBN(int isbn) {
		return repo.searchISBN(isbn);
	}
	
	public boolean withdrawBook(int isbn) {
		return repo.getBook(isbn);
	}
	
	public boolean depositBook(int isbn) {
		return repo.submitBook(isbn);
	}

	public void getStatus(int isbn) {
		repo.bookStatus(isbn);
	}
}
