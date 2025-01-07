package assignment_1;

import java.util.ArrayList;
import java.util.HashSet;

public class Q_68 {
	public static void main(String[] args) {
		/* Write a Java program to convert a hash set to an array. */

		HashSet<String> nameSet = new HashSet<>();

		nameSet.add("Manish");
		nameSet.add("Hariom");
		nameSet.add("Tarun");
		nameSet.add("Rahul");
		nameSet.add("Dhoni");
		
		ArrayList<String> nameList = new ArrayList<>(nameSet);
		
		System.out.println("HashSet converting into ArrayList : "+nameList);
	}
}
