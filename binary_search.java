public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the target is found at the middle index, return it.
            if (arr[mid] == target) {
                return mid;
            }

            // If the target is smaller, search the left half.
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // If the target is larger, search the right half.
            else {
                left = mid + 1;
            }
        }

        // If the target element is not found, return -1.
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int targetElement = 7;

        int result = binarySearch(sortedArray, targetElement);

        if (result != -1) {
            System.out.println("Element " + targetElement + " found at index " + result + ".");
        } else {
            System.out.println("Element " + targetElement + " not found in the array.");
        }
    }
}
