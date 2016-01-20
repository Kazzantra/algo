package concurrency;

public class Counter implements Runnable {
	public Printer prt;
	public void run() {
		synchronized(prt) {
			while(prt.toggler) {
				try { prt.wait();} catch(InterruptedException e){}
			}
			prt.print(String.valueOf(prt.toggler));
			prt.toggler = !prt.toggler;
			prt.notifyAll();
		}
	}
	public Counter(Printer p) {
		prt = p;
	}
}
