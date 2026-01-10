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
        // if element is not found we return -1
        else
            return -1;
    }
    public static void main(String args[]){

        int[ ] array = {10, 20, 30, 40, 50, 60, 70, 80};
        int item = 70;
        int size = array.length;

        int position = binarySearch(array, 0, size-1, item);

        if(position == -1)
            System.out.println("Element not found");
        else
            System.out.println("The value " + item + " found at position: " + position);

    }
}
