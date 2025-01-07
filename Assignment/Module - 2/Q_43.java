package assignment_1;

class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println("This Runnable Thread...");
	}
	
}
public class Q_43 {
	public static void main(String[] args) {
		/*
		 * W.A.J. P to create one thread by implementing Runnable interface in Class.
		 */
		
		MyThread th = new MyThread();
		Thread t1 = new Thread(th);
		
		t1.start();
	}
}
