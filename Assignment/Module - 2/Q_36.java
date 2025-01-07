package assignment_1;
import java.util.Scanner;

public class Q_36 {
	public static void main(String[] args) {
		/*
		 * Take two numbers from the user and perform the division operation and handle
		 * Arithmetic Exception. O/P- Enter two numbers: 10 0 Exception in thread main
		 * java.lang.ArithmeticException:/ by zero
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value of num1 :");
		int num1 = sc.nextInt();
		System.out.print("Enter the value of num2 :");
		int num2 = sc.nextInt();
		try {
			int result = num1 /num2 ;
			System.out.println(result);
		}catch(ArithmeticException e) {
			System.out.println("Error!! "+e);
		}
	}
}
