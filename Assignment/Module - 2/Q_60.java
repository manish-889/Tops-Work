package assignment_1;

import java.util.HashSet;

public class Q_60 {
	public static void main(String[] args) {
		/* Write a Java program to get the number of elements in a hash set. */
		
		HashSet<String> nameSet = new HashSet<>();
		
		nameSet.add("Manish");
		nameSet.add("Hariom");
		nameSet.add("Tarun");
		nameSet.add("Rahul");
		nameSet.add("Dhoni");
		
		System.err.println("Here the size of HashSet : "+nameSet.size());
	}
}
