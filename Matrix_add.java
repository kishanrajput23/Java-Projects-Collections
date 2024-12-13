import java.util.*;
public class matrixAdd {
	public static void main(String[] args) {
		int m,n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the rows of matrix: ");
		m = s.nextInt();
		System.out.println("Enter the columns of matrix: ");
		n = s.nextInt();
		
		int a[][] = new int[m][n];
		int b[][] = new int[m][n];
		int c[][] = new int[m][n];
		
		System.out.println("Enter the elements of 1st matrix ");
		 for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                a[i][j]=s.nextInt();
	            }
	        }
		 
		 System.out.println("Enter the elements of 2nd matrix ");
		 for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                b[i][j]=s.nextInt();
	            }
	        }
		 System.out.println("The addition of the above matrices is: ");		 
		 for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                c[i][j]=a[i][j]+b[i][j];
	                System.out.print(c[i][j]+ " ");
	            }
	            System.out.println();   
	        }
		 	
	}
}
