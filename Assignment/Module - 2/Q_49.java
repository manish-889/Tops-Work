package assignment_1;

import java.util.ArrayList;

public class Q_49 {
	public static void main(String[] args) {
		/*Write a Java program to iterate through all elements in an array list*/
		ArrayList<String> nameList = new ArrayList<String>();
		
		nameList.add("Manish");
		nameList.add("Hariom");
		nameList.add("Tarun");
		nameList.add("Rahul");
		
		for(String e : nameList) {
			System.out.println("Name : "+e);
		}
	}
}
