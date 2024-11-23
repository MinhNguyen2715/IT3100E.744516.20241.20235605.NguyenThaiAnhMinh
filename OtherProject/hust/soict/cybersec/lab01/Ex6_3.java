package Lab1.Lab1;
import java.util.Scanner;

public class Ex6_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = scanner.nextInt();
        for(int i = 1; i<=n; i++){
            System.out.print(" ".repeat(n-i));
            System.out.print("*".repeat(2*i-1));
            if(i != n){
                System.out.println();
            }
        }
    }
}
