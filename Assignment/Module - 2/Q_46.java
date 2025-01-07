package assignment_1;

class TwiceThread extends Thread{
	@Override
	public void run() {
		for(int i = 1;i <= 10 ;i++) {
			try {
				Thread.sleep(2000);
				System.out.println("Thread Name "+Thread.currentThread().getName()+" : "+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Q_46 {
	public static void main(String[] args) {
		/*
		 * W.A.J.P to start the same Thread twice by calling start () method twice. Test
		 * ThreadTwice1 t1=new TestThreadTwice1(); t1.start (); t1.start ();
		 */
		
		TwiceThread tt = new TwiceThread();
		
		tt.start();
		tt.start();
	}
}
