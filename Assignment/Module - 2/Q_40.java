package assignment_1;

class Voting{
	
	public void votingMethod(int age) throws ArithmeticException{
		if(age > 18) {
			System.out.println("Welcome to vote...");
		}
		else {
		throw new ArithmeticException("Your can't vote...");
		}
	}
}
public class Q_40 {
	public static void main(String[] args) {
		/*
		 * W.A.J.P to create the validate method that takes integer value as a
		 * parameter. If the age is less than 18, then throw an Arithmetic Exception
		 * otherwise print a message welcome to vote
		 */
		
		Voting v = new Voting();
		v.votingMethod(19);
	}
}
