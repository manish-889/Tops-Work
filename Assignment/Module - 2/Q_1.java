package assignment_1;

import java.util.Scanner;

public class Q_1 {
	public static void main(String[] args) {
		/*
		 * Write a Java program to Take three numbers from the user and print the
		 * greatest number.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of num1:");
		int a = sc.nextInt();
		System.out.println("Enter the value of num2:");
		int b = sc.nextInt();
		System.out.println("Enter the value of num3:");
		int c = sc.nextInt();
		
		int max = a;
		
		if(b > max) {
			max = b;
		}
		if (c > max) {
			max = c ;
		}
		System.out.println("The greatest number is " + max);
	}
}