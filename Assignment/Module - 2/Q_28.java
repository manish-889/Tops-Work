package assignment_1;
abstract class  Parent{
	abstract void message();
}
class Child1 extends Parent{
	public void message() {
		System.out.println("This is first subclass !!!");
	}
}
class Child2 extends Parent{
	public void message() {
		System.out.println("This is second subclass !!!");
	}
}
public class Q_28 {
	public static void main(String[] args) {
		/*
		 * Create an abstract class 'Parent' with a method 'message'. It has two
		 * subclasses each having a method with the same name 'message' that prints
		 * "This is first subclass" and "This is second subclass" respectively. Call the
		 * methods 'message' by creating an object for each subclass.
		 */
		Child1 c1 = new Child1();
		c1.message();
		
		Child2 c2 = new Child2();
		c2.message();
	}
}
