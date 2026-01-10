import java.util.Scanner;
import java.text.DecimalFormat;
public class Temp3524 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("2021503524 - Mugundh J B - 09/09/23 - 2.40 pm");
        System.out.print("Enter temperature in Fahrenheit: ");
        float fah = in.nextFloat();
        float c = (fah - 32) * 5 / 9;
        DecimalFormat df = new DecimalFormat("0.00"); // Used to format the decimal value in form of pattern
        System.out.printf("Fahrenheit temperature " + df.format(fah) +
                " is the same \nas " + df.format(c) + " degrees Celsius.");
    }
}
