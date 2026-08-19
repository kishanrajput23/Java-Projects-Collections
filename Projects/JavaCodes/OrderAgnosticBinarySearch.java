
/*How do we know if array is ascending or descending
 * We need to use one code only.
 * solution:- take any 2 elements and compare. iF 2nd element>1st element => ascending else descending
 * what if nos are equal? => problem
 *best way =>
 * if start < end => increasing
 * else decreasing => this is best case.
 *
 * */
public class CO2OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr1 = {90, 75, 18, 12, 6, 4, 3, 1}; //descending
        int[] arr = {-18, -12, -4, 0, 1, 6, 12, 14, 19, 22, 27, 28, 38, 49}; //ascending
        int target = 6;
        System.out.println("ascending: " + orderAgnosticBinarySearch(arr,target));
        System.out.println("descending: " + orderAgnosticBinarySearch(arr1,target));
    }

    static int orderAgnosticBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        //find if array is sorted in ascending or descending
        boolean isAscending;
        if (arr[start]<arr[end])
            isAscending = true;
        else
            isAscending = false;



        while (start <= end){
            //find the middle element
//          int mid = (start + end) / 2; //int has a fixed size, problem for bigger elements
            int mid = start + (end-start) / 2; //end-start ensures that int is always in range

            if (arr[mid] == target)
                return mid;

            if (isAscending){
                if(arr[mid] > target){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(arr[mid] < target){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }

        }
        return -1;
    }

}
