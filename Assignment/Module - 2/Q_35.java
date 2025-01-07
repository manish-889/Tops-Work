package assignment_1;

public class Q_35 {
	public static void main(String[] args) {
		/*W.A.J. P to demonstrate try catch block,*/
		try {
			int[] num = { 1, 2 , 3 , 4};
			System.out.println(num[5]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error!! "+e.getMessage());
		}
	}
}
