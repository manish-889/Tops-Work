package assignment_1;

import java.util.ArrayList;
import java.util.Collections;

public class Q_57 {
	public static void main(String[] args) {
		/* Write a Java program to shuffle elements in an array list. */
		
		ArrayList<Integer> numList = new ArrayList<>();
		
		numList.add(11);
		numList.add(22);
		numList.add(33);
		numList.add(44);
		numList.add(55);
		
		Collections.shuffle(numList);
		
		System.out.println("After the shuffling the list :"+numList);
	}
}
