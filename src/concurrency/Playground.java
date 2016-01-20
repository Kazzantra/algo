package concurrency;

public class Playground {
	public static void main(String[] args) {
		Printer prt = new Printer();
		Thread t1 = new Thread(new Counter(prt));
		Thread t2 = new Thread(new Counter(prt));
		t1.start();
		t2.start();
	}
}
