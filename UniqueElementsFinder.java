import java.util.HashSet;
import java.util.Arrays;

public class UniqueElementsFinder {

    public static int[] findUniqueElements(int[] arr) {
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int element : arr) {
            uniqueElements.add(element);
        }

        int[] uniqueArray = new int[uniqueElements.size()];
        int index = 0;

        for (int element : uniqueElements) {
            uniqueArray[index] = element;
            index++;
        }

        return uniqueArray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5, 6, 6};

        int[] uniqueArr = findUniqueElements(arr);

        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Unique elements: " + Arrays.toString(uniqueArr));
    }
}
