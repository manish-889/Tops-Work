package assignment_1;

import java.util.HashMap;

public class Q_70 {
	public static void main(String[] args) {
		/*
		 * Write a Java program to check whether a map contains key-value mappings
		 * (empty) or not.
		 */
		
		HashMap<Integer, String> nameMap = new HashMap<>();
		
		nameMap.put(null, "Manish");
		nameMap.put(1, "Hariom");
		nameMap.put(2, "Tarun");
		nameMap.put(3, "Ronny");
		
		if(nameMap.containsKey(null)) {
			System.out.println("This Map contains null key-value...");
		}
		else {
			System.out.println("This Map not contains null key-value...");
		}
	}
}
