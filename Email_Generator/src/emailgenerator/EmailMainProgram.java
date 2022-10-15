package emailgenerator;

public class EmailMainProgram {

	public static void main(String[] args) {
		EmailBackProgram email = new EmailBackProgram("Abhinandan", "Raj");
		System.out.println(email.showInfo());

	}

}
