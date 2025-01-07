package assignment_1;

class SleepingThread extends Thread{
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
public class Q_45 {
	public static void main(String[] args) {
		/*
		 * W.A.J.P to create 2 threads and execute that threads by providing sleep time
		 * as 2000ms and check the execution.
		 */
		
		SleepingThread st = new SleepingThread();
		st.start();
		
		SleepingThread st1 = new SleepingThread();
		st1.start();
	}
}
