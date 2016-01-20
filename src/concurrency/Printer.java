package concurrency;

import tools.io;

public class Printer {
	boolean toggler = false;
	public void print(String msg) {
		io.pl(msg);
	}
}
