
public class RunnableThreadExample implements Runnable{
	public int count = 0;
	public void run() {
		System.out.println("RunnableThread starting.");
		try {
			while(count<5) {
				Thread.sleep(150);
				count++;
				System.out.println(count);
			}
		}catch(InterruptedException exc) {
			System.out.println("RunnableThread interrupted");
		}
		System.out.println("RunnableThread terminating");
	}
	public static void main(String[] args) {
		RunnableThreadExample obj = new RunnableThreadExample();
		Thread thread = new Thread(obj);
		thread.start();
		
		while(obj.count!=5) {
			try {
			Thread.sleep(150);
			}catch(InterruptedException exc) {
				System.out.println("RunnableThread interrupted");
			}
		}
	}
}
