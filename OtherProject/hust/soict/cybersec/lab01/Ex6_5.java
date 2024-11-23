package Lab1.Lab1;
import java.util.Scanner;

public class Ex6_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of element:");
        int n = scanner.nextInt();
        double[] a = new double[n];
        for(int i = 0; i<n; i++){
            a[i] = scanner.nextDouble();
        }

        double sum = 0;
        double ave = 0;

        for(int i = 0; i<n; i++){
            sum += a[i];
            for(int j = 0; j<i; j++){
                if(a[j] > a[i]){
                    double tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }

        ave = sum / n;

        System.out.print("The sorted array is: ");
        for(int i = 0; i<n; i++){
            System.out.print(a[i] + " ");
        }

        System.out.println("\nThe sum of array is: " + sum);
        System.out.println("The average of array is: "+ ave);
    }
}
