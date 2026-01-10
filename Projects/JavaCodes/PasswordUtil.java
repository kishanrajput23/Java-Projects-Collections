import java.util.Random;

public class PasswordUtil {
				
		public static boolean validate(String password) {
//			return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})");
			return validate2(password);
		}
		
		public static boolean hasSymbol(String password) {
			return password.matches(".*[@#$%].*");
		}
		
		public static boolean hasUppercase(String password) {
			return password.matches(".*[A-Z].*");
		}
		
		public static boolean hasLowerCase(String password) {
			return password.matches(".*[a-z].*");
		}
		
		public static boolean hasDigit(String password) {
			return password.matches(".*\\d.*");
		}
		
		public static boolean validate2(String pass) {
				boolean flag = true;
				
				if (pass.length() < 8) {
						//Password must have more than 8 chars
						flag = false;
				} else if (!hasDigit(pass)) {
						//Password must contains digit
						flag = false;
				} else if (!hasSymbol(pass)) {
						//Password must contains symbol
						flag = false;
				} else if (!hasUppercase(pass)) {
						//Password must contains Upper case
						flag = false;
				} else if (!hasLowerCase(pass)) {
						//Password must contains Lower case
						flag = false;
				}
				
				return flag;
		}
		
		public static String generatePassword(int len) {
				Random rnd = new Random();
				String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#$%&";
				StringBuilder sb = new StringBuilder(len);
				for (int i = 0; i < len; i++) {
					sb.append(AB.charAt(rnd.nextInt(AB.length())));
				}
				if(validate2(sb.toString())){
				    return sb.toString();
				}else{
				   return generatePassword(12);
				}
		}
		
}
