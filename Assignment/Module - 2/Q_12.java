package assignment_1;

public class Q_12 {
	public static void main(String args[]) {
		/*
		 * Write a Java program to print numbers between 1 to 100 which are divisible by
		 * 3, 5 and by both.
		 */
		int n =100;
		System.out.println("The number which is divisible by 3");
		for(int i =1;i<=n;i++) {
			if(i %3 == 0) {
				System.out.print(i+",");
			}
		}
		System.out.println("\n\nThe number which is divisible by 5");
		for(int i =1;i<=n;i++) {
			if(i % 5 == 0) {
				System.out.print(i+",");
			}
		}
		System.out.println("\n\nThe number which is divisible by both 3 & 5");
		for(int i =1;i<=n;i++) {
			if(i % 3 == 0 && i %5 == 0) {
				System.out.print(i+",");
			}
		}
	}
}
