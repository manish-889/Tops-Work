package assignment_1;
class PrintNumber{
	public void printn(int i) {
	System.out.println("This is integer value "+i);
	}
	public void printn(float f) {
		System.out.println("This is float value "+f);
	}
	public void printn(String s) {
		System.out.println("This is string character "+s);
	}
	public void printn(boolean b) {
		System.out.println("This is boolean value "+b);
	}
}
public class Q_20 {
	public static void main(String args[]) {
		/*
		 * Create a class named 'Print Number' to print various numbers of different
		 * data types by creating different methods with the same name 'printn' having a
		 * parameter for each data type.
		 */
		PrintNumber pn = new PrintNumber();
		pn.printn(1);
		pn.printn(5);
		pn.printn(false);
		pn.printn("Hi ");
		
	}
}
