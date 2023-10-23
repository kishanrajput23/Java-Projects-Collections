package Master.JavaExample;  
  
import org.passay.CharacterRule;  
import org.passay.EnglishCharacterData;  
import org.passay.PasswordGenerator;  
  
// create class GeneratePasswordExample1 to generate a random and secure password  
public class GeneratePasswordExample1 {  
      
    // main() method start  
    public static void main(String args[]) {  
          
        // call the generatePassword() method to generate a random password using the Passay library  
        String pass = generateSecurePassword();  
          
        // print Passay generated password  
        System.out.println("The Passay generated password is:"+pass);  
          
    }  
      
    // create generateSecurePassword() method that find the secure password and returns it to the main() method  
    public static String generateSecurePassword() {  
          
        // create character rule for lower case  
        CharacterRule LCR = new CharacterRule(EnglishCharacterData.LowerCase);  
        // set number of lower case characters  
        LCR.setNumberOfCharacters(2);  
  
        // create character rule for upper case  
        CharacterRule UCR = new CharacterRule(EnglishCharacterData.UpperCase);  
        // set number of upper case characters  
        UCR.setNumberOfCharacters(2);  
  
        // create character rule for digit  
        CharacterRule DR = new CharacterRule(EnglishCharacterData.Digit);  
        // set number of digits  
        DR.setNumberOfCharacters(2);  
  
        // create character rule for lower case  
        CharacterRule SR = new CharacterRule(EnglishCharacterData.Special);  
        // set number of special characters  
        SR.setNumberOfCharacters(2);  
          
        // create instance of the PasswordGenerator class   
        PasswordGenerator passGen = new PasswordGenerator();  
          
        // call generatePassword() method of PasswordGenerator class to get Passay generated password  
        String password = passGen.generatePassword(8, SR, LCR, UCR, DR);  
          
        // return Passay generated password to the main() method   
        return password;  
    }  
}  