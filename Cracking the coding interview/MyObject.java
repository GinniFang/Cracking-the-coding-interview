/*public class MyObject{
		public synchronized void foo(String name) {
			try {
				System.out.println("Thread "+name+" has started");
				Thread.sleep(3000);
				System.out.println("Thread "+name+" has ended");
			}catch(InterruptedException exc){
				System.out.println("Thread "+name+": interrupted.");
			}
		}
}*/

public class MyObject{
	public void foo(String name) throws InterruptedException {
		synchronized(this) {
			if(name.equals("1")) {
				System.out.println("Thread "+name+" has started");
			}else {
				System.out.println("Thread "+name+" has started");
			}
		}
		Thread.sleep(3000);
		System.out.println("Thread "+name+" has ended");
	}
}