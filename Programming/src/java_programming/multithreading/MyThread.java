package java_programming.multithreading;

public class MyThread extends Thread {
	
	public MyThread(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Thread" + this.getName() + "is running");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}