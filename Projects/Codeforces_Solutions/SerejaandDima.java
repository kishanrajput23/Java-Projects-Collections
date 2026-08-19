import java.util.Scanner;
public class SerejaandDima {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int sr=0,dm=0;
        int s=0,e=n-1;
        boolean alt=true;
        int max=0;
        while(s<=e)
        {
            if(arr[s]<arr[e])
            {
                max=arr[e];
                e--;
            }
            else
            {
                max=arr[s];
                s++;
            }
            if(alt)
            {
                alt=false;
                sr+=max;
            }
            else
            {
                alt=true;
                dm+=max;
            }
        }
            System.out.println(sr+" "+dm);
        sc.close();
        }
}

