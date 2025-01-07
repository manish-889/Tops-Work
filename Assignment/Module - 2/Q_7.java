package assignment_1;
import java.util.Scanner;
public class Q_7 {
	public static void main(String args[]) {
		/*Write a Java program that reads a positive integer and count the number of digits the 
number.*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the postive number :");
	
		int posNum = sc.nextInt();
		if (posNum <=0) {
			System.out.println("Pls Enter positive number!!");
			return;
		}
		int count =0;
		int num = posNum;
		while(num>0) {
			count++;
			num /=10;
		}
		System.out.println("Number of digits in " + posNum + " is  " + count);
	}
}
