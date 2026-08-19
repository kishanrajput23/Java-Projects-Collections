
public class C01BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0, 1, 6, 12, 14, 19, 22, 27, 28, 38, 49};
        int target = 27;
        System.out.println(binarySearch(arr,target));
    }
//    return the index
//    return -1 if it does not exist.
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            //find the middle element
//          int mid = (start + end) / 2; //int has a fixed size, problem for bigger elements
            int mid = start + (end-start) / 2; //end-start ensures that int is always in range

            if(arr[mid] > target){
                end = mid-1;
            }
            else if (arr[mid] < target){
                start = mid+1;
            }
            else{
                // ans found
                return mid;
            }
        }
        return -1;
    }
}
