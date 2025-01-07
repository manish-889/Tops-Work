package assignment_1;

import java.util.ArrayList;

public class Q_50 {
	public static void main(String[] args) {
		/*Write a Java program to insert an element into the array list at the first position. */
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		intList.add(34);
		intList.add(88);
		intList.add(44);
		intList.add(90);
		intList.add(21);
		intList.add(56);
		
		intList.addFirst(78);
		
		System.out.println(intList);
	}
}
