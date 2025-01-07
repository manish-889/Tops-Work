package assignment_1;
class Print{
	public void printIntChar(int i , char c) {
		System.out.println("The first value is integer "+i+" second value is character "+c);
	}
	public void printCharInt(char c , int i) {
		System.out.println("The first value is character "+c+" second value is integer "+i);
	}

}
public class Q_21 {
	public static void main(String[] args) {
		/*
		 * • Create a class to print an integer and a character with two methods having
		 * the same name but different sequence of the integer and the character
		 * parameters. For example, if the parameters of the first method are of the
		 * form (int n, char c), then that of the second method will be of the form
		 * (char c, int n).
		 */
		Print p = new Print();
		p.printIntChar(1, 'm');
		p.printCharInt('h', 2);
	}
}
