package assignment_1;

class InvalidAmountException extends Exception {
	String message;
	public InvalidAmountException(String message) {
		super(message);
		this.message = message;
	}
}

class Account {
	double accBalance = 5000;
	
	void withdraw(double amount) throws InvalidAmountException{
		if( amount <= accBalance) {
			accBalance -= amount ;
			System.out.println("Current Balance : "+accBalance);
		}
		else {
			throw new InvalidAmountException("Your amount greater than bank balance...");
		}
	}
}
public class Q_41 {
	public static void main(String[] args) throws InvalidAmountException {
		/*
		 * • W.A.J.P to create a custom exception if Customer withdraw amount which is
		 * greater than account balance then program will show custom exception
		 * otherwise amount will deduct from account balance. Account balance is: 2000
		 * Enter withdraw amount: 2500
		 */
		Account ac = new Account();
		ac.withdraw(500);
	}
}
