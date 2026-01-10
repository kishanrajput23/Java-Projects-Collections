package Email_App;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int defaultPasswordLength=8;
	private int codelen=5;
	private String Vcode;
	private String company="drngpit.ac.in";
	private String name;

	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Kindly ! Enter department for email creation dear "+this.firstName+" "+this.lastName);
		//dept
		this.department=setDepartment();
		System.out.println("Department:"+department);
		//pass
		this.password=randomPass(defaultPasswordLength);
		System.out.println("New Password :"+password);
		//clipping name as one
		this.name=firstName+lastName;
		//verification code
		this.Vcode=vcode(codelen);
		System.out.println("Your verification code : "+Vcode);

		//Binding
		email=name.toLowerCase()+"."+department+"@"+company;
		System.out.println("Official mail :"+email);
	}

	private String setDepartment(){
		System.out.println("Enter the department Id\nSales : 1\nDevelopment : 2\nAccounting : 3");
		Scanner in=new Scanner(System.in);
		int dep=in.nextInt();
		if(dep==1){
			return "sales";
		}
		else if(dep==2){
			return"dev";
		}
		else if(dep==3){
			return "acc";
		}
		return"";
	}

	private String randomPass(int length){
		String password="ABCEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
		char[]pass=new char[length];
		for(int i=0;i<length;i++){
			int rand=(int)(Math.random()*password.length());
			pass[i]=password.charAt(rand);
		}
		return new String(pass);
	}
	private String vcode(int codelen){
		String samcode="1234567890";
		char[]code=new char[codelen];
		for(int i=0;i<codelen;i++){
			int c=(int)(Math.random()*samcode.length());
			code[i]=samcode.charAt(c);
		}
		return new String(code);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword(){
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getVcode() {
		return Vcode;
	}
	public String getDept(String dep){
		if(dep.equals("dev")){
			return "Developers";
		}
		else if(dep.equals("acc")){
			return "Accounts";
		}
		else if(dep.equals("sales")){
			return "Sales";
		}
		return "";

	}
	public String showInfo(){
		return "Name : "+name+"\nOfficial email : "+email+"\nDepartment : "+getDept(department);
	}
}
