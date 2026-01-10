import java.util.Scanner;

class Bino {
    int p, m, e, w;
    int comb;
    Scanner sc = new Scanner(System.in);

    Bino() {
        p = 0;
        m = 0;
    }

    void input() {
        System.out.println("Enter the first number (p): ");
        p = sc.nextInt();
        System.out.println("Enter the second number (m): ");
        m = sc.nextInt();
        System.out.println("Enter the highest power (w): ");
        w = sc.nextInt();
        System.out.println("Enter the lowest power (e): ");
        e = sc.nextInt();
    }

    int fact(int x) {
        int s = 1;
        for (int i = 1; i <= x; i++) {
            s = s * i;
        }
        return s;
    }

    int compute() {
        int a = fact(p);
        int b = fact(m);
        int k = fact(p - m);
        comb = a / (b * k);
        return comb;
    }

    void bmial() {
        int d = compute();
        System.out.print(d + " * " + Math.pow(p, w) + " * " + Math.pow(m, e));
        w--;
        e++;
    }

    public static void main(String[] args) {
        Bino ob = new Bino();
        ob.input();
        ob.bmial();
    }
}
