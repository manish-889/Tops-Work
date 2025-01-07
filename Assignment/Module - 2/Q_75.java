package assignment_1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Q_75 {
	public static void main(String[] args) {
		/*
		 * Write a Java program to get a collection view of the values contained in this
		 * map.
		 */
		HashMap<Integer, String> nameMap = new HashMap<>();
		
		nameMap.put(1, "Manish");
		nameMap.put(2, "Hariom");
		nameMap.put(3, "Tarun");
		nameMap.put(4, "Ronny");
		
		Collection<String> value = nameMap.values(); 
		
		for(String e : value) {
			System.out.println(e);
		}
	}
}
