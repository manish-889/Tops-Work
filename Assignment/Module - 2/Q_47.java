package assignment_1;

class DaemonThread extends Thread {
	@Override
	public void run() {
		if (Thread.currentThread().isDaemon()) {
			System.out.println("daemon thread work");
		} else {
			System.out.println("user thread work");
		}
	}
}

public class Q_47 {
	public static void main(String[] args) {
		/*
		 * W.A.J.P to create 2 threads and make one thread as Daemon Thread by using set
		 * Daemon () method of Thread class and check whether the thread is set daemon
		 * or not by using is Daemon () method. TestDaemonThread2 t1=new
		 * TestDaemonThread2(); TestDaemonThread2 t2=new TestDaemonThread2(); t1.start
		 */

		DaemonThread dt = new DaemonThread();
		DaemonThread dt1 = new DaemonThread();
		
		dt.start();
		dt1.setDaemon(true);
		dt1.start();
		
	}
}
