import java.util.Calendar;
import java.util.TimeZone;
 
public class GetCurrentTimeZone {
 
  public static void main(String[] args) {
   
    //get Calendar instance
    Calendar now = Calendar.getInstance();
   
    //get current TimeZone using getTimeZone method of Calendar class
    TimeZone timeZone = now.getTimeZone();
   
    //display current TimeZone using getDisplayName() method of TimeZone class
    System.out.println("Current TimeZone is : " + timeZone.getDisplayName());
  }
}