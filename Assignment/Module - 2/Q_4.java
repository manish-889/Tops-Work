package assignment_1;

import java.util.*;

public class Q_4 {
	/*
	 * Write a program in Java to input 5 numbers from keyboard and find their sum
	 * and average using for loop.
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int avg;
		System.out.println("Enter 5 numnbers :");
		for (int i = 0; i < 5; i++) {
			int num = sc.nextInt();
			sum += num;
		}
		avg = sum / 5;
		System.out.println("Here the sum of 5 numbers " + sum);
		System.out.println("Here the average of 5  numbers " + avg);
	}
}
