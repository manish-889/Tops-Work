package assignment_1;

import java.util.ArrayList;

public class Q_73 {
	public static void main(String[] args) {
		/*
		 * Write a Java program to print all the elements of an Array List using the
		 * position of the elements.
		 */

		ArrayList<String> countryList = new ArrayList<>();

		countryList.add("India");
		countryList.add("America");
		countryList.add("France");
		countryList.add("Canada");
		
		for (int i = 0; i < countryList.size(); i++) {
			System.out.println("Element at position "+i+" : "+countryList.get(i));
		}
	}
}
