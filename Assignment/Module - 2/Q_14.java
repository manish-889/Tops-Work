package assignment_1;
import java.util.Scanner;
public class Q_14 {
	public static void main(String args[]) {
		/*W.A.J.P to concatenate a given string to the end of another string.*/
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your first string :");
		String firstName =sc.nextLine();
		System.out.print("Enter your second string :");
		String lastName =sc.nextLine();
		System.out.println(firstName.concat(lastName));
		}
}
