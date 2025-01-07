package assignment_1;
class Triangle{
	Triangle(){
		double l =3;
		double b =4;
		double h = 5;
		double area = 0.5 * ( b * h);
		System.out.println("Here the area of trianlge : "+area);
		double perimeter = l + b + h;
		System.out.println("Here the perimeter of triangle :"+perimeter);
	}
}
public class Q_26 {
	public static void main(String[] args) {
		/*
		 * Write a program to print the area and perimeter of a triangle having sides of
		 * 3, 4 and 5 units by creating a class named 'Triangle' without any parameter
		 * in its constructor.
		 */
		Triangle t = new Triangle();
	}
}
