package assignment_1;
import java.util.Scanner;
public class Q_9 {
	public static void main(String args[]) {
		/*Write a Java program to print the ASCII value of a given character. */
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter your character :");
		char ch =sc.next().charAt(0);
		int asciiValue =(int)ch;
		System.out.println("ASCII value of " + ch + " is: " + asciiValue);
		}

}
