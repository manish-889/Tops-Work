package assignment_1;
class Rectangle{
	double length;
	double breadth;
	Rectangle(double length,double breadth){
		this.length=length;
		this.breadth=breadth;
		areaOfRectangle();
		perimeterOfRectangle();
	}
	public void areaOfRectangle() {
		double area = length * breadth;
		System.out.println("Here the area of rectangle : "+area);
	}
	
	public void perimeterOfRectangle() {
		double perimeter = (length + breadth ) * 2;
		System.out.println("Here the perimeter of reactangle : "+perimeter);
	}
}

class Square extends Rectangle{
	double s;
	Square(double length,double breadth){
		super(length,breadth);
		areaOfSquare();
		areaOfSquare();
	}
	public void areaOfSquare() {
		double area = length * length;
		System.out.println("Here the area of square : "+area);
	}
	public void perimeterOfSquare() {
		double perimeter = length * 4;
		System.out.println("Here the perimeter of Square : "+perimeter);
	}
}
public class Q_25 {
	public static void main(String[] args) {
		/*
		 * Create a class named 'Rectangle' with two data members 'length' and 'breadth'
		 * and two methods to print the area and perimeter of the rectangle
		 * respectively. Its constructor having parameters for length and breadth is
		 * used to initialize the length and breadth of the rectangle. Let class
		 * 'Square' inherit the 'Rectangle' class with its constructor having a
		 * parameter for its side (suppose s) calling the constructor of its parent
		 * class as 'super (s, s)'. Print the area and perimeter of a rectangle and a
		 * square.
		 */
		
		//Rectangle R = new Rectangle(4,5);
		Square s = new Square(2,2);
	}
}
