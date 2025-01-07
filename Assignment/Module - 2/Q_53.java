package assignment_1;

import java.util.ArrayList;

public class Q_53 {
	public static void main(String[] args) {
		/*Write a Java program to remove the third element from an array list.*/
		
		ArrayList<String> colorList = new ArrayList<String>();
		
		colorList.add("Red");
		colorList.add("Black");
		colorList.add("Blue");
		colorList.add("Grey");
		colorList.add("Yellow");
		
		colorList.remove(2);
		
		System.out.println(colorList);
	}
}
