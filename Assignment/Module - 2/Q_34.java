package assignment_1;
class Shape1{
	public void shape() {
		System.out.println("This is Shape Method!!");
	}
}

class Rectangle1 extends Shape1{
	public void rectengular() {
		System.out.println("This is Rectangluar Shape method!!");
	}
}

class Circle1 extends Shape1{
	public void circular() {
		System.out.println("This is Circular shape method!");
	}
}

class Square1 extends Rectangle1{
	public void square() {
		System.out.println("Square is rectangle!!");
	}
}
public class Q_34 {
	public static void main(String[] args) {
		/*
		 * Create a class named 'Shape' with a method to print "This is this is shape".
		 * Then create two other classes named 'Rectangle', 'Circle' inheriting the
		 * Shape class, both having a method to print "This is rectangular shape" and
		 * "This is circular shape" respectively. Create a subclass 'Square' of
		 * 'Rectangle' having a method to print "Square is a rectangle". Now call the
		 * method of 'Shape' and 'Rectangle' class by the object of 'Square' class.
		 */
		
		Square1 s = new Square1();
		s.shape();
		s.rectengular();
	}
}
