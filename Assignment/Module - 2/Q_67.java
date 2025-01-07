package assignment_1;

import java.util.ArrayList;

public class Q_67 {
	public static void main(String[] args) {
		/* Write a Java program to join two array lists */

		ArrayList<String> nameList1 = new ArrayList<>();

		nameList1.add("Manish");
		nameList1.add("Rohit");
		nameList1.add("Vishal");
		nameList1.add("Sahil");

		ArrayList<String> nameList2 = new ArrayList<>();

		nameList2.add("Vicky");
		nameList2.add("Salman");
		nameList2.add("Viraj");
		nameList2.add("Shiva");

		nameList1.addAll(nameList2);
		
		System.out.println(nameList1);
	}
}
