
import java.util.Scanner;

public class majorityelement {
    public static int majorityElement(int[] nums) {
            int count=0;
            for(int i=0;i<nums.length;i++)
            {
                for(int j=0;j<nums.length;j++)
                {
                    if(nums[i]==nums[j])
                    {
                        count++;
                    }
                }
                if(count*2>=nums.length)
                {
                    return nums[i];
                }
        
            }
            return 0;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
         //   int n=sc.nextInt();
           // int arr[]=new int[n];
            int[] arr={3,2,3};
            int ans=majorityElement(arr);
        System.out.println(ans);
        sc.close();
    }
}
