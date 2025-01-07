package assignment_1;
abstract class Bank{
	abstract int getBalance();
} 

class BankA extends Bank{
	public int a = 100;
	int getBalance() {
		return a;
	}
}

class BankB extends Bank{
	public int b = 150;
	int getBalance() {
		return b;
	}
}

class BankC extends Bank{
	public int c = 200;
	int getBalance() {
		return c;
	}
}

public class Q_29 {
	public static void main(String[] args) {
		/*
		 * Create an abstract class 'Bank' with an abstract method 'getBalance'. $100,
		 * $150 and $200 are deposited in banks A, B and C respectively. 'BankA',
		 * 'BankB' and 'BankC' are subclasses of class 'Bank', each having a method
		 * named 'getBalance'. Call this method by creating an object of each of the
		 * three classes.
		 */
		BankA a = new BankA();
		BankB b = new BankB();
		BankC c = new BankC();
		
		System.out.println("Here is the Bank balance of BankA : $"+a.getBalance());
		System.out.println("Here is the Bank balance of BankB : $"+b.getBalance());
		System.out.println("Here is the Bank balance of BankC : $"+c.getBalance());
	
	}
}
