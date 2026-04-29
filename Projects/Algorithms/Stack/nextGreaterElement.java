import java.util.*;

public class NextGreaterElement {

    /**
     * Function to find Next Greater Element for each element in the array.
     *
     * @param arr Input array of integers
     * @return Array containing next greater elements
     */
    public static int[] findNextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        // Stack to store elements
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove elements from stack that are <= current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element exists
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // Top of stack is the next greater element
                result[i] = stack.peek();
            }

            // Push current element onto stack
            stack.push(arr[i]);
        }

        return result;
    }

    /**
     * Driver method to test the function
     */
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};

        int[] result = findNextGreater(arr);

        System.out.println("Next Greater Elements:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
