package concurrency;

public class Lock {
	public boolean ready = false;
	public static void main(String[] args) {
		Lock l = new Lock();
		Thread c = new Thread(new Consumer(l));
		Thread p = new Thread(new Producer(l));
		c.run();
		p.run();
	}
}
