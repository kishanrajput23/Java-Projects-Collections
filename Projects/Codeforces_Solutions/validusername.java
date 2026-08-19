import java.util.*;

public class validusername {
   

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        //sc.nextLine();
        while(t--!=0)
        {
            String a=sc.next();
            int count=0;
           if(a.length()>4&&a.length()<=30)
           {
            if('0'<=a.charAt(0)&&a.charAt(0)<='9')
            {
                System.out.println("Invalid");
            }
            else
            {
              for(int i=0;i<a.length();i++)
              { char ch=a.charAt(i);
               if('a'<=ch&&ch<='z'||'0'<=ch&&ch<='9'||'A'<=ch&&ch<='Z'||ch=='_')
               {
                   count++;
               }
               else
               {
                   System.out.println("Invalid");
               }   
              }
              if(count==a.length())
              {
                System.out.println("Valid");   
              }  
            }
        }
        else
        {
            System.out.println("Invalid");
        }
       
        }
        sc.close();
    }
}