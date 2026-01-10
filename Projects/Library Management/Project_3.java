
class Library{
    String[] books;
    int No_Of_Book;
    Library(){
        this.books=new String[100];
        this.No_Of_Book=0;
    }
    void AddBook(String book){
        this.books[No_Of_Book++]=book;
        System.out.println(book + " Book has been Added Successfully! ");
    }
    void  ShowAvailableBook(){
        System.out.println("Available Book In Library");
        for(String book:this.books){
            if(book==null){
                continue;
            }
            System.out.println( " * " + book );
        }
    }
    void IssueBook(String book){
        for(int i=0;i<this.books.length;i++){
            if(this.books[i].equals(book)){
                System.out.println("The book has been Issued ");
                this.books[i]=null;
                return;
            }
        }
        System.out.println("This book does not exist");
    }
    void returnBook(String book){
        AddBook(book);
    }

}
public class Project_3 {
    public static void main(String[] args) {
       Library library_management=new Library();
       library_management.AddBook("Operating System");
        library_management.AddBook("C++");
        library_management.AddBook("Data Structure");
        //library_management.ShowAvailableBook();
        library_management.IssueBook("C++");
        library_management.ShowAvailableBook();
        library_management.returnBook("C++");
        library_management.ShowAvailableBook();
    }
}
