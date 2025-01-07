package assignment_1;

import java.util.ArrayList;
import java.util.Collections;

public class Q_66 {
	public static void main(String[] args) {
		/*Write a Java program of swap two elements in an array list. */
		

		ArrayList<String> colorList1 = new ArrayList<String>();
		
		colorList1.add("Red");
		colorList1.add("Black");
		colorList1.add("Blue");
		colorList1.add("Grey");
		colorList1.add("Yellow");
		
		System.out.println("Original ArrayList :");
		System.out.println(colorList1);
		
		System.out.println("**************************************");
		
		Collections.swap(colorList1, 2, 3);
	    
		System.out.println("After swapping :");
		System.out.println(colorList1);
	}
}
