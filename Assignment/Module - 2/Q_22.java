package assignment_1;
class Area{
	public void printingArea(int l, int b) {
		int area = l * b ;
		System.out.println("Here the area of rectangle : "+area);
	}
	public void printingArea(int r) {
		int area = r * r;
		System.out.println("Here the area of square : "+area);
	}
}
public class Q_22 {
	public static void main(String[] args) {
		/*
		 * Create a class to print the area of a square and a rectangle. The class has
		 * two methods with the same name but different number of parameters. The method
		 * for printing area of a rectangle has two parameters which are length and
		 * breadth respectively while the other method for printing area of square has
		 * one parameter which is side of square.
		 */
		Area a = new Area();
		a.printingArea(4);
		a.printingArea(4, 2);
	}
}
