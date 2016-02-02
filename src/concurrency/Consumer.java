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
		synchronized(q) {
			while(q.isEmpty()) {
				io.pl("No food!");
				q.wait();
				Thread.sleep(10);
			}
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
