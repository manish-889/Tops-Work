package assignment_1;

public class Q_37 {
	public static void main(String[] args) {
		/*
		 * W.A.J. P to demonstrate multiple catch blocks, (one is to handle divide by
		 * zero exception and another one is to handle ArrayIndexOutOfBoundException)
		 * int a [] =new int [5]; a [5]=30/0;
		 */
		int a[] = new int [5];
		
		
		try {
			a[0] = 10/0;
			a[1] = 20;
			a[2] = 30;
			a[3] = 40;
			a[4] = 50;
			System.out.println(a[6]);
		}catch(ArithmeticException e) {
			System.out.println("Error !!"+e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error !!"+e.getMessage());
		}
	}
}
