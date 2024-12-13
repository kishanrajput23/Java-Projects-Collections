
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author testuser
 */
public class AddBookMenu {

    public static void addBookMenu() {
        System.out.println("Reached the add book menu");
        Book b = new Book();
        Scanner sc = new Scanner(System.in);
        int addStatus = 0;

        while (addStatus == 0) {
            try {
                System.out.println("Enter the isbn code");
                b.setIsbnCode(sc.nextLine().toString());
                System.out.println("Enter the book name");
                b.setBookName(sc.nextLine().toString());
                System.out.println("Enter the book desc");
                b.setBookDesc(sc.nextLine().toString());
                System.out.println("Enter the author name");
                b.setAuthorName(sc.nextLine().toString());
                System.out.println("Enter the subject ");
                b.setSubjectName(sc.nextLine().toString());
                System.out.println("Enter the units available");
                b.setUnitsAvailable(Integer.parseInt(sc.nextLine().toString()));

                addBook(b);
                addStatus = 1;
                
            } catch (Exception e) {
                addStatus=0;
            }

        }

    }

    public static void addBook(Book b) { 
        System.out.println("Reached inside addBook for book "+b.getIsbnCode());
        Connection conn = LibUtil.getConnection();
        try {
            Statement stmt = conn.createStatement();
            int k = stmt.executeUpdate("insert into books values ('"+b.getIsbnCode()+"','"+b.getBookName()+"','"+b.getBookDesc()+"',"
                    + "'"+b.getAuthorName()+"','"+b.getSubjectName()+"',"+b.getUnitsAvailable()+")");
            if(k>0){
                System.out.println("Added Book successfully");
                conn.commit();
            }else{
                conn.rollback();
            }
            conn.close();
        } catch (Exception e) {
        }
        
        

    }

}
