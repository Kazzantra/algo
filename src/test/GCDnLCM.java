package test;

import tools.io;

public class GCDnLCM {
	public static int GCD(int a, int b) {
		if(a < 1 || b < 0)
			throw new RuntimeException("invalid input");
		return b == 0 ? a : GCD(b, a % b);
	}
	public static int LCM(int a, int b) {
		if(a < 1 || b < 0)
			throw new RuntimeException("invalid input");
		return (int)((long)a * (long)b / (long)GCD(a, b));
	}
	public static void main(String[] args) {
		io.pl(GCD(24, 18));
		io.pl(LCM(Integer.MAX_VALUE >> 4, (Integer.MAX_VALUE >> 8)));
	}
}
