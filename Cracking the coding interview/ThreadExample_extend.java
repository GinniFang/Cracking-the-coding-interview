
public class ThreadExample_extend extends Thread{
	int count = 0;
	public void run() {
		System.out.println("Thread starting extends");
		try {
			while(count<5) {
				Thread.sleep(500);
				System.out.println("In Thread, count is "+count);
				count++;
			}
		}catch(InterruptedException exc) {
			System.out.println("Thread Interrupted");
		}
		System.out.println("RunnableThread terminating");
	}
	public static void main(String[] args) {
		ThreadExample_extend obj = new ThreadExample_extend();
		obj.start();
		
		while(obj.count!=5) {
			try {
			Thread.sleep(150);
			}catch(InterruptedException exc) {
				System.out.println("RunnableThread interrupted");
			}
		}
	}
}
