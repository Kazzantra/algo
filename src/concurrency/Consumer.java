package concurrency;

import java.util.List;

import tools.io;

public class Consumer implements Runnable {
	public int limit;
	public List<Integer> q;
	public Consumer(List<Integer> q, int limit) {
		this.limit = limit;
		this.q = q;
	}
	public int consume() throws InterruptedException {
		while(q.isEmpty()) {
			synchronized(q) {
				io.pl("No food!");
				q.wait();
			}
			Thread.sleep(50);
		}
		synchronized(q) {
			q.notifyAll();
			return q.remove(0);
		}
	}
	public void run() {
		while(true) {
			try {
				io.pl("Consumed " + consume());
				Thread.sleep(50);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
