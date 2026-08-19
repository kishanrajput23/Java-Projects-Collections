import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamOlympiad {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int o=0;
        int t=0;
        int th=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(arr[i]==1)
                o++;
           else if(arr[i]==2)
                t++;
           else if(arr[i]==3)
                th++;
        }
        int ans=Math.min(o,Math.min(th,t));
        System.out.println(ans);
        int mat[][]=new int[ans][3];
        List<Integer>ar=new ArrayList<>();
        int a=0,b=0,c=0;
        for(int i=0;i<n;i++)
        {
           if(!ar.contains(i)&&arr[i]==1&&a<ans)
           {
            mat[a++][0]=i+1;
            ar.add(i);
           }
           if(!ar.contains(i)&&arr[i]==2&&b<ans)
           {
             mat[b++][1]=i+1;
             ar.add(i);
           }
           if(!ar.contains(i)&&arr[i]==3&&c<ans)
           {
             mat[c++][2]=i+1;
             ar.add(i);
           }
        }
       for(int i=0;i<ans;i++)
       {
        for(int j=0;j<3;j++)
        {
            System.out.print(mat[i][j]+" ");
        }
        System.out.println();
       }
        sc.close();
    }
}
