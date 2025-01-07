package assignment_1;

import java.util.Scanner;

public class Q_10 {
	public static void main(String args[]) {
		/*
		 * Write a Java program that accepts an integer (n) and computes the value of
		 * n+nn+nnn. Input number: 5 5 + 55 + 555
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your integer :");
		int n = sc.nextInt();
		int m = n + (n * 11) + (n * 111);
		System.out.println(m);
	}
}
