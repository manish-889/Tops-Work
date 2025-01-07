package assignment_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q_69 {
	public static void main(String[] args) {
		/*Write a Java program to convert a hash set to a List/Array List.*/
		
		HashSet<String> nameSet = new HashSet<>();

		nameSet.add("Manish");
		nameSet.add("Hariom");
		nameSet.add("Tarun");
		nameSet.add("Rahul");
		
		ArrayList<String> nameArrayList = new ArrayList<>(nameSet);
		
		List<String> nameList = new ArrayList<>(nameSet);
		
		System.out.println("Converting HashSet into ArrayList : "+nameArrayList);
		
		System.out.println("Converting HashSet into List : "+nameList);
	}
}
