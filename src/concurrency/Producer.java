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
		while(q.size() >= limit) {
			synchronized(q) {
				io.pl("Overstock!");
				q.wait();
			}
		}
		synchronized(q) {
			q.add(i);
			q.notifyAll();
		}
	}
	public void run() {
		for(int food = 1; food < limit; food++) {
			io.pl("Produced " + food);
			try {
				produce(food);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
