
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
public class AddMemberMenu {

    public static void addMemberMenu() {
        System.out.println("Reached the add member menu");
        Member m = new Member();
        Scanner sc = new Scanner(System.in);
        int addStatus = 0;

        while (addStatus == 0) {
            try {
                System.out.println("Enter the member id ");
                m.setMemberId(Integer.parseInt(sc.nextLine().toString()));
                System.out.println("Enter the member name");
                m.setMemberName(sc.nextLine().toString());
                
                addMember(m);
                addStatus = 1;
                
            } catch (Exception e) {
                addStatus=0;
            }

        }

    }

    public static void addMember(Member m) { 
        System.out.println("Reached inside add member for member "+m.getMemberId());
        Connection conn = LibUtil.getConnection();
        try {
            Statement stmt = conn.createStatement();
            int k = stmt.executeUpdate("insert into members values ("+m.getMemberId()+",'"+m.getMemberName()+"',sysdate)");
            if(k>0){
                System.out.println("Added Member successfully");
                conn.commit();
            }else{
                conn.rollback();
            }
            conn.close();
        } catch (Exception e) {
        }
        
        

    }

}
