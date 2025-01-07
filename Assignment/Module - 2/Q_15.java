package assignment_1;
import java.util.Scanner;
public class Q_15 {
	public static void main(String args[]) {
		/*
		 * W.A.J.P to compare a given string to the specified character sequence.
		 * Comparing topsint.com and topsint.com: true Comparing Topsint.com and
		 * topsint.com: false
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your first string :");
		String firstString =sc.nextLine();
		System.out.print("Enter your second string :");
		String secondString =sc.nextLine();
		System.out.println(firstString.equalsIgnoreCase(secondString));
	}
}
