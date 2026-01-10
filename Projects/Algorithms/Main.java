public class Main{

    public static int binarySearch(int array[], int left, int right, int item){

        if (right >= left){

            // calculation of new mid
            int mid = left + (right - left)/2;

            // returns position where found
            if (array[mid] == item)
                return mid+1;

            // goes to recursive calls in left half
            if (array[mid] > item)
                return binarySearch(array, left, mid-1, item);

                // goes to recursive calls in right half
            else
                return binarySearch(array, mid+1, right, item);
        }
        return -1;
    }
}
