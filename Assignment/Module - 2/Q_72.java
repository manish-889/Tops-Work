package assignment_1;

import java.util.ArrayList;

public class Q_72 {
	public static void main(String[] args) {
		/*
		 * Write a Java program to replace the second element of an Array List with the
		 * specified element.
		 */
		
		ArrayList<String> countryList = new ArrayList<>();
		
		countryList.add("India");
		countryList.add("America");
		countryList.add("France");
		countryList.add("Canada");
		
		System.out.println("Original List : "+countryList);
		
		countryList.set(1, "Portugal");
		
		System.out.println("After relpacement of second element : "+countryList);
	
	}
}
