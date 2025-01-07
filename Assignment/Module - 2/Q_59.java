package assignment_1;

import java.util.HashSet;

public class Q_59 {
	public static void main(String[] args) {
		/* Write a Java program to iterate through all elements in a hash list. */
		
		HashSet<Integer> numSet = new HashSet<>();
		
		numSet.add(11);
		numSet.add(22);
		numSet.add(33);
		numSet.add(44);
		numSet.add(55);
		
		for(Integer e : numSet) {
			System.out.println(e);
		}
	}
}
