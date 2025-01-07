package assignment_1;

import java.util.Scanner;

class Complex{
	double a;
	double b;
	Complex(double a, double b){
		this.a=a;
		this.b=b;
		sum();
		difference();
		product();
	}
	public void sum() {
		double sum = a + b;
		System.out.println("Here the sum of two complex number :"+sum);
	}
	public void difference() {
		double diff = a - b;
		System.out.println("Here the difference between two complex number :"+diff);
	}
	public void product() {
		double pro =a *b ;
		System.out.println("Here the product of two complex number :"+pro);
	}
}
public class Q_27 {
	public static void main(String[] args) {
		/*
		 * Print the sum, difference and product of two complex numbers by creating a
		 * class named 'Complex' with separate methods for each operation whose real and
		 * imaginary parts are entered by user.
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the real part of Complex number : ");
		double real = sc.nextDouble();
		
		System.out.print("Enter the imaginary part of complex number : ");
		double imaginary = sc.nextDouble();
		
		Complex c = new Complex(real,imaginary);
	}
}
