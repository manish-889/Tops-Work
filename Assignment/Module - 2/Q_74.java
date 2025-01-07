package assignment_1;

import java.util.HashSet;

public class Q_74 {
	public static void main(String[] args) {
		/*
		 * Write a Java program to compare two sets and retain elements which are same
		 * on both sets.
		 */
		HashSet<String> nameSet1 = new HashSet<>();

		nameSet1.add("Manish");
		nameSet1.add("Gopal");
		nameSet1.add("Shiva");
		nameSet1.add("Golu");

		HashSet<String> nameSet2 = new HashSet<>();

		nameSet2.add("Manish");
		nameSet2.add("Hariom");
		nameSet2.add("Tarun");
		nameSet2.add("Ronny");
		
		System.out.println("Name Set1 : "+nameSet1);
		
		System.out.println("Name Set2 : "+nameSet2);
		
		nameSet1.retainAll(nameSet2);
		
		System.out.println("Similar element in both set : "+nameSet1);
	}
}
