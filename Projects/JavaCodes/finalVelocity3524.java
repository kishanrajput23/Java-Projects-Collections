import java.util.Scanner;
public class finalVelocity3524 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("2021503524 - Mugundh J B - 09/09/23 - 3 pm");

        System.out.print("Enter the starting speed: ");
        float u = in.nextFloat();
        System.out.print("Enter the acceleration: ");
        float a = in.nextFloat();
        System.out.print("Enter the time: ");
        float t = in.nextFloat();

        float d = (float) (u * t + (0.5 * a * t * t)); // Formula to calc displacement
        System.out.printf("The displacement is %.2f", d);

        float v = u + a * t; // Formula to calc final velocity
        System.out.printf("\nThe final velocity is %.2f", v);

    }
}
