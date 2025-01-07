package assignment_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_54 {
	public static void main(String[] args) {
		/* Write a Java program to search an element in an array list. */
		
		ArrayList<String> nameList = new ArrayList<String>();
		
		nameList.add("Manish");
		nameList.add("Hariom");
		nameList.add("Tarun");
		nameList.add("Rahul");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name for search : ");
		String searchName = sc.next();
		
		if(nameList.contains(searchName)) {
			System.out.println("Yes, this name is present in this list...");
		}else {
			System.out.println("No, this name is not present in this list...");
		}
	}
}
