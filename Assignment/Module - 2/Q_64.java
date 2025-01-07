package assignment_1;

import java.util.ArrayList;
import java.util.List;

public class Q_64 {
	public static void main(String[] args) {
		/* Write a Java program to extract a portion of an array list. */
		

		ArrayList<String> colorList = new ArrayList<String>();
		
		colorList.add("Red");
		colorList.add("Black");
		colorList.add("Blue");
		colorList.add("Grey");
		colorList.add("Yellow");
	
		System.out.println("Original ArrayList :");
		System.out.println(colorList);
		
		System.out.println("**************************************");
		
		List<String> subList= colorList.subList(0,3);
		
		System.out.println("SubList :");
		System.out.println(subList);
	}
}
