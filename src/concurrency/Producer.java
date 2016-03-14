package concurrency;

import java.util.List;

import tools.io;

public class Producer implements Runnable {
	public int limit;
	public List<Integer> q;
	public Producer(List<Integer> q, int limit) {
		this.limit = limit;
		this.q = q;
	}
	public void produce(int i) throws InterruptedException {
		synchronized(q) {
			while(q.size() >= limit) {
				io.pl("Overstock!");
				q.wait();
				Thread.sleep(50);
			}
			if(q.size() < limit) {
				q.add(i);
				q.notifyAll();
			}
		}
	}
	public void run() {
		int i = 0;
		while(true) {
			i++;
			io.pl("Produced " + i);
			try {
				produce(i);
				Thread.sleep(10);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
