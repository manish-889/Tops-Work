package assignment_1;

import java.util.Collections;
import java.util.HashSet;

public class Q_58 {
	public static void main(String[] args) {
		/*Write a Java program to append the specified element to the end of a hash set.*/
		
		HashSet<String> nameList = new HashSet<>();
		
		nameList.add("Manish");
		nameList.add("Hariom");
		nameList.add("Tarun");
		nameList.add("Rahul");
		
		System.out.println("Original HashSet.....");
		System.out.println(nameList);
		
		System.out.println("*****************************************");
		
		System.out.println("Updated HashSet......");
		
		nameList.add("Virat");
		
		System.out.println(nameList);
	}
}
