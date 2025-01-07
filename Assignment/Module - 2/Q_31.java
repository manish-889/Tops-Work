package assignment_1;
class Factorial{
	double a;

	public Factorial(int a) {
		this.a = a;
	}

	public void factorial() {
		double result = 1;
		while(a >0) {
			result *= a;
			a--;
		}
		System.out.println("Here the factorial :"+result);
	}
}
public class Q_31 {
	public static void main(String[] args) {
		/*
		 * Write a program to print the factorial of a number by defining a method named
		 * 'Factorial'. Factorial of any number n is represented by n! And is equal to
		 * 1*2*3*. (n-1) *n. E.g.- 
		 * 4! = 1*2*3*4 = 24 
		 * 3! = 3*2*1 = 6 
		 * 2! = 2*1 = 2 
		 * Also,1!= 1 
		 * 0! = 0
		 */
		
		Factorial f = new Factorial(3);
		f.factorial();
	}
}
