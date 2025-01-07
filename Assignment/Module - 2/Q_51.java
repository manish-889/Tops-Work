package assignment_1;

import java.util.ArrayList;

public class Q_51 {
	public static void main(String[] args) {
		/*
		 * Write a Java program to retrieve an element (at a specified index) from a
		 * given array list.
		 */
		
		ArrayList<String> subjectList = new ArrayList<String>();
		
		subjectList.add("Java");
		subjectList.add("Kotil");
		subjectList.add("Python");
		subjectList.add("Dart");
		subjectList.add("C++");
		
		System.out.println("Subject : "+subjectList.get(1));
	}
}
