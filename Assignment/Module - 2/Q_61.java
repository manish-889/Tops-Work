package assignment_1;

import java.util.HashMap;

public class Q_61 {
	public static void main(String[] args) {
		/*
		 * Write a Java program to associate the specified value with the specified key
		 * in a Hash Map.
		 */
		
		HashMap<Integer, String> studentInfo = new HashMap<>();
		
		studentInfo.put(1, "Manish");
		studentInfo.put(2, "Dhoni");
		studentInfo.put(3, "Virat");
		studentInfo.put(4, "Jadeja");
		studentInfo.put(5, "Bumrah");
		
		System.out.println(studentInfo);
	}
}
