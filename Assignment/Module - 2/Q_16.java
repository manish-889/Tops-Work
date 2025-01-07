package assignment_1;
import java.util.Scanner;
public class Q_16 {
	public static void main(String args[]) {
		/*
		 * W.A.J.P to check whether a given string ends with the contents of another
		 * string. "Java Exercises" ends with "se"? False "Java Exercise" ends with
		 * "se"? True
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your string :");
		String firstString =sc.nextLine();
		
		System.out.println(firstString.endsWith("ring"));
	}
}
