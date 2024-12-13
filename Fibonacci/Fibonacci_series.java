/* JAVA code to find the fibonacci series.The Fibonacci numbers are the numbers in the following integer sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, …….. */

class Fibonacci_series {
    public static void main(String args[]) {
        int n1 = 0, n2 = 1, n3, i, count = 20;
        System.out.print(n1 + " " + n2);// printing 0 and 1

        for (i = 2; i < count; ++i)// loop starts from 2 because 0 and 1 are already printed
        {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }

    }
}
