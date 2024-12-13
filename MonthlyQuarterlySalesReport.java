import java.util.Arrays;

public class MonthlyQuarterlySalesReport {

    public static void main(String[] args) {

        // Create an array to store the monthly sales report
        int[] monthlySalesReport = new int[]{125000, 93000, 80000, 75000,
                105000, 120000, 90000, 115000, 84000, 90000, 123000, 150000};

        // Create an array to store the quarterly sales report
        int[] quarterlySalesReport = new int[4];

        // Calculate the quarterly sales report
        for (int i = 0; i < 4; i++) {
            for (int j = i * 3; j < (i + 1) * 3; j++) {
                quarterlySalesReport[i] += monthlySalesReport[j];
            }
        }

        // Display the monthly sales report
        System.out.println("Monthly sales report:");
        for (int i = 0; i < monthlySalesReport.length; i++) {
            System.out.println("Month " + (i + 1) + ": " + monthlySalesReport[i]);
        }

        // Display the quarterly sales report
        System.out.println("Quarterly sales report:");
        for (int i = 0; i < quarterlySalesReport.length; i++) {
            System.out.println("Quarter " + (i + 1) + ": " + quarterlySalesReport[i]);
        }

        // Calculate the total sales
        int totalSales = 0;
        for (int sale : monthlySalesReport) {
            totalSales += sale;
        }

        // Display the total sales
        System.out.println("Total sales: " + totalSales);
    }
}