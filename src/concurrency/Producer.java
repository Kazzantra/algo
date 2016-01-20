package concurrency;

public class Producer implements Runnable {
	public Lock lock;
	public int times = 10;
	public Producer(Lock lock) {
		this.lock = lock;
	}
	public void run() {
		synchronized(lock) {
			while(lock.ready && times > 0) {
				try {
					lock.wait();
				} catch(InterruptedException e) {}
			}
			lock.ready = true;
			times--;
			notifyAll();
		}
	}
}
