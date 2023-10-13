import java.util.Scanner;  
//This class will calculate the max and min values of the array  
class TestArray  
{  
      
    int MAX(int[]Arry)  
    {  
        int maxValue= Arry[0];  
  
        for(int i=1;i<Arry.length;i++)  
        {  
            if(Arry[i]>maxValue)  
            {  
                maxValue=Arry[i];  
            }  
        }  
        return maxValue;//This method will return the max value present in the array.  
    }  
  
    int MIN(int[]Arry)  
    {  
        int minValue=Arry[0];  
  
        for(int i=1;i<Arry.length;i++)  
        {  
            if(Arry[i]<minValue)  
            {  
                minValue=Arry[i];  
            }  
        }  
        return minValue;  
    }  
}  
  
public class DifferenceArry  
{  
    public static void main(String[] args)  
    {  
        int n;  
  
        //It creates scanner object  
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter the array elements:" );  
        n=sc.nextInt();  
  
        int arr[]=new int[n];  
  
        for(int i=0;i<arr.length;i++)  
        {  
            System.out.print("Enter ["+(i+1)+"] element :" );  
            arr[i]=sc.nextInt();  
        }  
  
        TestArray obj=new TestArray();  
        System.out.println("Maximum value in the array is :" +obj.MAX(arr));  
        System.out.println("Minimum value in the array is :" +obj.MIN(arr));  
        int diff=obj.MAX(arr)-obj.MIN(arr);  
        System.out.print("Difference between max and min elements is : " +diff );     
    }  
}  
