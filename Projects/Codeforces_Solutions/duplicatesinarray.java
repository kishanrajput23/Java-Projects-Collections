import java.util.Scanner;

public class duplicatesinarray {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
         //   int n=sc.nextInt();
           // int arr[]=new int[n];
            int[] arr={2,2,3};
        System.out.println(removedup(arr));
        sc.close();
    }
    public static int[] removedup(int[] nums)
    {   int arr[]=new int[nums.length];
        int k=0;
        for(int i=1;i<nums.length;i++)
            if(nums[i]!=nums[k])
            {
                k++;
                arr[k]=nums[i];
            }
        return arr; 
    }
}
