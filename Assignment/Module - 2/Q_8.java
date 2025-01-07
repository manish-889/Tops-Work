package assignment_1;

import java.util.Scanner;

public class Q_8 {
	public static void main(String args[]) {
		/*
		 * Write a Java program to count the letters, spaces, numbers and other
		 * characters of an input string.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your String :");
		String input = sc.nextLine();

		int letterCount = 0;
		int spaceCount = 0;
	    int numberCount = 0;
		int otherCount = 0;
		
		for(int i =0;i<input.length();i++) {
			char ch = input.charAt(i);
			if(Character.isLetter(ch)) {
				letterCount++;
			}else if (Character.isSpaceChar(ch)){
				spaceCount++;
			}else if (Character.isDigit(ch)) {
				numberCount++;
			}
			else{
				otherCount++;
			}
		}
		System.out.println("Number of letters: " + letterCount);
        System.out.println("Number of spaces: " + spaceCount);
        System.out.println("Number of numbers: " + numberCount);
        System.out.println("Number of other characters: " + otherCount);

	}
}
