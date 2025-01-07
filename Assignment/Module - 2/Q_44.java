package assignment_1;

class MyThread1 extends Thread{
	@Override
	public void run() {
		System.out.println("This is extended Thread class...");
	}
}
public class Q_44 {
	public static void main(String[] args) {
		/* W.A.J. P to create one thread by extending Thread class in another Class*/
		
		MyThread1 t1 = new MyThread1();
		t1.start();
	}
}
