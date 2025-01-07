package assignment_1;

import java.util.ArrayList;

public class Q_56 {
	public static void main(String[] args) {
		/* Write a Java program to copy one array list into another.*/
		
		ArrayList<String> originalList = new ArrayList<String>();
		
		originalList.add("Manish");
		originalList.add("Hariom");
		originalList.add("Tarun");
		originalList.add("Rahul");
		
		ArrayList<String> copiedList = new ArrayList<String>(originalList);
		
		System.out.println(copiedList);
	}
}
