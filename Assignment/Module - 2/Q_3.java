package assignment_1;

import java.util.Scanner;

public class Q_3 {
	public static void main(String[] args) {
		/*
		 * Write a Java program that takes a year from user and print whether that year
		 * is a leap year or not. B19. Write a program in Java to display the first 10
		 * natural numbers using while loop.
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your year:");
		int year = sc.nextInt();
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			System.out.println("This year is leap year!!");
		} else {
			System.out.println("This year is not a leap year!!");
		}
		/*
		 * Write a program in Java to display the first 10 natural numbers using while
		 * loop.
		 */
		int n =10;
		int i=1;
		while(i<=10) {
			System.out.println(i);
			i++;
		}
	}
}
