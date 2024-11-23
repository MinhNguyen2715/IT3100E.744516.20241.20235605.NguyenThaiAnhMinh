package Lab1.Lab1;
import java.util.Scanner;

public class Ex6_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = scanner.nextInt();
        System.out.println("Enter number of column: ");
        int m = scanner.nextInt();
        double[][] a = new double[n][m];
        double[][] b = new double[n][m];
        double[][] c = new double[n][m];

        System.out.println("Enter first matrix:");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                a[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Enter second matrix:");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                b[i][j] = scanner.nextDouble();
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println("The sum of 2 matrix is: ");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

    }
}
