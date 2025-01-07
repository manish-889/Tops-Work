package assignment_1;
import java.util.Scanner;
class Grade{
	public void marks() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your marks to know your grade :");
		int m =sc.nextInt();
		if(m >= 81 && m <=100) {
			System.out.println("According to your marks your grade is A");
		}
		
		else if(m >= 61 && m <=80 ) {
			System.out.println("According to your marks your grade is B");
		}
		
		else if(m >= 51 && m <=60 ) {
			System.out.println("According to your marks your grade is C");
		}
		
		else if(m >= 41 && m <=50 ) {
			System.out.println("According to your marks your grade is D");
		}
		
		else  {
			System.out.println("According to your marks you are fail!!!");
		}
	}
}
public class Q_33 {
	public static void main(String[] args) {
		/*
		 * Write a program which will ask the user to enter his/her marks (out of 100).
		 * Define a method that will display grades according to the marks entered as
		 * below: Marks Grade 
		 * 91-100 A
		 * 81-90 A
		 * 71-80 B
		 * 61-70 B
		 * 51-60 C
		 * 41-50 D
		 * 40 Fail
		 */
		
		Grade s = new Grade();
		s.marks();
	}
}
