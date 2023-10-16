import java.util.Scanner;
public class Challenge {
    static boolean isLeapYear(int n) {
        if (n % 100 == 0) {
            return (n % 400) == 0;
        } else {
            return n % 4 == 0;
        }
    }
    static int numLYunsorted(int[] a){
        int count=0;
        for (int j : a) {
            if (isLeapYear(j)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Lower and Upper range.");
        System.out.print("\nlower range:");
        int l=sc.nextInt();
        System.out.print("upper range:");
        int u=sc.nextInt();
//        int res1=numLYrange(l,u);

        System.out.println("Enter no. of years in the sorted list:");
        int n=sc.nextInt();
        int[] arry = new int[n];
        System.out.println("Enter the list of years:");
        for(int i=0;i<n;i++){
            arry[i]=sc.nextInt();
        }
        int res1=numLYunsorted(arry);
//        int res2=numLYunsorted(arry);
        System.out.println("Enter no. of years in the unsorted list:");
        int n1=sc.nextInt();
        int[] arry1 = new int[n1];
        System.out.println("Enter the list of years:");
        for(int i=0;i<n1;i++){
            arry1[i]=sc.nextInt();
        }
        int res2=numLYunsorted(arry1);

        System.out.println("The difference in both number of years is:"+(res1-res2));

        sc.close();
    }
}
