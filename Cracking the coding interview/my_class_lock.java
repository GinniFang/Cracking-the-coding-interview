/*Thread within a given process share the same memory, which is both a positive
 * and a negative. It enables threads to share data, which can be 
 * valuable. However, it also creates the opportunity for issues
 * when two threads modify a resource at the same time. Java provides synchronization
 * in order to control access to share resources*/

public class my_class_lock extends Thread{
	private String name;
	private MyObject myObject;
	
	public my_class_lock(String name, MyObject myObject) {
		this.name = name;
		this.myObject = myObject;
	}
	public void run() {
		try {
			myObject.foo(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		/*MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();
		my_class_lock thread1 = new my_class_lock("1",obj1);
		my_class_lock thread2 = new my_class_lock("2",obj2);
		thread1.start();
		thread2.start();*/
		
		MyObject obj = new MyObject();
		my_class_lock thread1 = new my_class_lock("1",obj);
		my_class_lock thread2 = new my_class_lock("2",obj);
		thread1.start();
		thread2.start();
	}
}
