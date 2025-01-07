package assignment_1;
class ParentClass{
	void printParentMessage() {
		System.out.println("This is parent class!!");
	}
}
class ChildClass extends ParentClass{
	void printChildMessgae() {
		System.out.println("This is child class!!");
	}
}
public class Q_23 {
	public static void main(String[] args) {
		/*
		 * Create a class with a method that prints "This is a parent class" and its
		 * subclass with another method that prints "This is child class". Now, create
		 * an object for each of the class and call 1 - method of parent class by object
		 * of parent class 2 - method of child class by object of child class 3 - method
		 * of parent class by object of child class
		 */
		System.out.println("Print by Parent class");
		ParentClass pc  = new ParentClass();
		pc.printParentMessage();
		
		System.out.println("**************************");
		
		System.out.println("Print by child class");
		ChildClass cc = new ChildClass();
		cc.printChildMessgae();
		
		System.out.println("**************************");
		System.out.println("Printing the parent method by child class");
		cc.printParentMessage();
	}
}
