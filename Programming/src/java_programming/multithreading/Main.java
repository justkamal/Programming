package java_programming.multithreading;

public class Main {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		
		t1.start();
		t2.start();
		
		Thread t3 = new Thread(()-> {
			while(true) {
				System.out.println(t1.getName() + " is running");
				try {
					Thread.sleep(900);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t3");
		
		t3.start();
	}
}
