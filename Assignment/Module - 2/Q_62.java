package assignment_1;

import java.util.HashMap;

public class Q_62 {
	public static void main(String[] args) {
		/*Write a Java program to count the number of key-value (size) mappings in a map.*/
		

		HashMap<Integer, String> studentInfo = new HashMap<>();
		
		studentInfo.put(1, "Manish");
		studentInfo.put(2, "Dhoni");
		studentInfo.put(3, "Virat");
		studentInfo.put(4, "Jadeja");
		studentInfo.put(5, "Bumrah");
		
		System.out.println("Here the size of map : "+studentInfo.size());
	}
}
