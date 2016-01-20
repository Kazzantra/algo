package concurrency;

public class Consumer implements Runnable {
	public Lock lock;
	public int times = 10;
	public Consumer(Lock lock) {
		this.lock = lock;
	}
	public void run() {
		synchronized(lock) {
			while(!lock.ready && times > 0) {
				try {
					lock.wait();
				} catch(InterruptedException e) {}
			}
			lock.ready = false;
			times--;
			notifyAll();
		}
	}
}
