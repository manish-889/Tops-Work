package assignment_1;

import java.util.ArrayList;

public class Q_71 {
	public static void main(String[] args) {
		/* Write a Java program to increase the size of an array list. */

		ArrayList<Integer> idList = new ArrayList<>();

		idList.add(1);
		idList.add(2);
		idList.add(3);
		idList.add(4);
		idList.add(5);

		System.out.println("Original size of ArrayList: " + idList.size());

		idList.ensureCapacity(6);
		
		idList.add(6);
		
		System.out.println("New size of ArrayList: " + idList.size());
	}
}
