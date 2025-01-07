package assignment_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Q_55 {
	public static void main(String[] args) {
		/*Write a Java program to sort a given array list. */
		ArrayList<String> nameList = new ArrayList<String>();
		
		nameList.add("Manish");
		nameList.add("Hariom");
		nameList.add("Tarun");
		nameList.add("Rahul");
		
		Collections.sort(nameList);
		System.out.println(nameList);
	}
}
