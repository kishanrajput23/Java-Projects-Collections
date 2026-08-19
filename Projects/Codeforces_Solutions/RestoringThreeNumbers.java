import java.util.Scanner;

public class RestoringThreeNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[4];
         arr[0]=sc.nextInt();arr[1]=sc.nextInt();arr[2]=sc.nextInt();arr[3]=sc.nextInt();
        int max=0;
        for(int i=0;i<=3;i++)
        {
            max=Math.max(arr[i],max);
        }
        for(int i=0;i<=3;i++)
        {
            if(Math.abs(arr[i]-max)!=0)
            System.out.print(Math.abs(arr[i]-max)+" ");
        }
        sc.close();
    }
}
