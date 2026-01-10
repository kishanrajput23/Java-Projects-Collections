
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LibFunctions {

    public static void callIssueMenu() {
        System.out.println("Reached inside issue book menu");
        Member m = new Member();
        Book b = new Book();
        Scanner sc = new Scanner(System.in);
        int addStatus = 0;

        while (addStatus == 0) {
            try {
                System.out.println("Enter the member id ");
                m.setMemberId(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("Enter the isbn code ");
                b.setIsbnCode(sc.nextLine().toString());
                issueBook(m, b);
                addStatus = 1;

            } catch (Exception e) {
                addStatus = 0;
            }

        }

    }
    

    public static void issueBook(Member m, Book b) {
        Connection conn = LibUtil.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = null;
            String qry = "select m.member_id, b.isbn_code, mbr.rec_id from members m,books b,member_book_record mbr\n"
                    + "where m.member_id= " + m.getMemberId() + " \n"
                    + "and b.isbn_code = '" + b.getIsbnCode() + "' \n"
                    + "and m.member_id=mbr.member_id\n"
                    + "and b.isbn_code=mbr.isbn_code and mbr.dor is null ";
            rs=stmt.executeQuery(qry);
            if (rs.next()) {
                System.out.println("The book is already issued and cannot be issued again");
            } else {
                int k = stmt.executeUpdate("insert into member_book_record values(lib_seq.nextval," + m.getMemberId() + ",'" + b.getIsbnCode() + "',sysdate,null)");
                if(k > 0){
                    k = stmt.executeUpdate("update books set units_available= (units_available-1) where isbn_code = '"+ b.getIsbnCode() +"' "); 
                    conn.commit();
                    System.out.println("The book is issued successfully");
                }else{
                    conn.rollback();
                }

            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void callReturnMenu() {
        System.out.println("Reached inside return book menu");
        Member m = new Member();
        Book b = new Book();
        Scanner sc = new Scanner(System.in);
        int addStatus = 0;

        while (addStatus == 0) {
            try {
                System.out.println("Enter the member id ");
                m.setMemberId(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("Enter the isbn code ");
                b.setIsbnCode(sc.nextLine().toString());
                returnBook(m, b);
                addStatus = 1;

            } catch (Exception e) {
                addStatus = 0;
            }

        }

    }
    
    public static void returnBook(Member m, Book b) {
        Connection conn = LibUtil.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = null;
            String qry = "select m.member_id, b.isbn_code, mbr.rec_id from members m,books b,member_book_record mbr\n"
                    + "where m.member_id= " + m.getMemberId() + " \n"
                    + "and b.isbn_code = '" + b.getIsbnCode() + "' \n"
                    + "and m.member_id=mbr.member_id\n"
                    + "and b.isbn_code=mbr.isbn_code and mbr.dor is null ";
            rs=stmt.executeQuery(qry);
            if (rs.next()) {
                Integer recId= rs.getInt(3);
                System.out.println("The book is already issued and starting the process to return ");
                int k = stmt.executeUpdate("update books set units_available= (units_available+1) where isbn_code = '"+ b.getIsbnCode() +"' "); 
                if(k > 0){
                    k = stmt.executeUpdate("update member_book_record set dor= sysdate where rec_id = "+ recId +" "); 
                    conn.commit();
                    System.out.println("The book is returned successfully");
                }else{
                    conn.rollback();
                }

            } else{
                System.out.println("This book is not issued for the user");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        
        
}
