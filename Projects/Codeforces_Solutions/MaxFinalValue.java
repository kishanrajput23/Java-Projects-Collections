import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxFinalValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  // number of test cases

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();  // length of the array
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            
            for (int j = 0; j < n; j++) {
                pq.add(scanner.nextInt());
            }
            
            while (pq.size() > 1) {
                int x = pq.poll();
                int y = pq.poll();
                pq.add((x + y) / 2);
            }
            
            System.out.println(pq.poll());  // the final element
        }
        
        scanner.close();
    }
}