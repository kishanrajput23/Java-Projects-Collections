import java.util.*;
public class stack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                int operation = scanner.nextInt();

                if (operation == 0) {
                    int element = scanner.nextInt();
                    stack.push(element);
                    System.out.print(element + " ");
                } else {
                    if (stack.isEmpty()) {
                        System.out.print("-1 ");
                    } else {
                        System.out.print(stack.pop() + " ");
                    }
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
