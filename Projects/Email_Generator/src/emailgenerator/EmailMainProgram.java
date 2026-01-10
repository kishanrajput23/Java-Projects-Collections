package Email_App;

import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;
import java.util.Scanner;

public class EmailApp {
	public static void main(String[] args) {
		System.out.println("Generate Organization's Email ==>");
		Scanner sc=new Scanner(System.in);

//        String x=sc.nextLine();
		System.out.println("Generating the email...");
		System.out.println("Enter firstname :");
		String first=sc.nextLine();
		System.out.println("Enter Lastname :");
		String second=sc.nextLine();

		Email em=new Email(first,second);

		while(true) {
			System.out.println("1 : Information ");
			System.out.println("2 : Change Email");
			System.out.println("3 : Change Password");
			System.out.println("4 : Disclose Password");
			System.out.println("5 : Exit");
			System.out.println("Enter operation code :");
			int a = sc.nextInt();
			switch (a) {
				case 1:
					System.out.println(em.showInfo());
					break;
				case 2:
					System.out.println("Enter alternate email prefix :");
					sc.nextLine();
					String alt = sc.nextLine();
					em.setEmail(alt+"@drngpit.ac.in");
					break;
				case 3:
					System.out.println("Enter the verification code :");
					sc.nextLine();
					String s = sc.nextLine();
					if (s.equals(em.getVcode())) {
						System.out.println("Enter alternate password :");
						String p = sc.nextLine();
						em.setPassword(p);
					} else {
						System.out.println("Please Enter valid verification code !!!");
					}
					System.out.println("Password updated successfully !!!");
					break;
				case 4:
					System.out.println("Password disclose warning !!!");
					System.out.println("Enter the verification code :");
					sc.nextLine();
					String s1 = sc.nextLine();
					if (s1.equals(em.getVcode())) {
						System.out.println("Your password : " + em.getPassword());
					} else {
						System.out.println("Please Enter valid verification code !!!");
					}
				case 5:
					System.out.println("Have a great day ahead ! BYE ");
					return ;
			}
		}
	}
}