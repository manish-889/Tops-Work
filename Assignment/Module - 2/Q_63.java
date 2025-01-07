package assignment_1;

import java.util.ArrayList;

public class Q_63 {
	public static void main(String[] args) {
		/*Write a Java program to reverse elements in an array list.*/
		

		ArrayList<String> colorList = new ArrayList<String>();
		
		colorList.add("Red");
		colorList.add("Black");
		colorList.add("Blue");
		colorList.add("Grey");
		colorList.add("Yellow");
		
		System.out.println("Original ArrayList :");
		System.out.println(colorList);
		
		System.out.println("***********************************");
		
		System.out.println("Reversed ArrayList :");
		System.out.println(colorList.reversed());
		
		
	}
}
