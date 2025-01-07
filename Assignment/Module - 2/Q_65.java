package assignment_1;

import java.util.ArrayList;

public class Q_65 {
	public static void main(String[] args) {
		/* Write a Java program to compare two array lists. */
		
		ArrayList<String> colorList1 = new ArrayList<String>();
		
		colorList1.add("Red");
		colorList1.add("Black");
		colorList1.add("Blue");
		colorList1.add("Grey");
		colorList1.add("Yellow");
		
		ArrayList<String> colorList2 = new ArrayList<String>();
		
		colorList2.add("Red");
		colorList2.add("Black");
		colorList2.add("Blue");
		colorList2.add("Grey");
		colorList2.add("Yellow");
	
		System.out.println(colorList1.equals(colorList2));
	}
}
