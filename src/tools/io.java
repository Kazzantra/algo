package tools;

import java.util.Random;

public class io {
	private static Random random;
	public static <T> void pl(T x) {
		System.out.println(x);
	}
	public static <T> void p(T x) {
		System.out.print(x);
	}
	public static <T extends Iterable<T>> void pA(T x) {
		for(Object obj : x)
			io.p(obj.toString() + ", ");
		io.pl("");
	}
	public static int abs(int i) {
		return i > 0 ? i : -i ;
	}
	public static int rnd(int ceiling) {
		if(io.random == null)
			random = new Random();
		if(ceiling < 0)
			throw new ArithmeticException("Incorrect ceiling value (" + ceiling + ")");
		if(ceiling == 0)
			return 0;
		return abs(io.random.nextInt()) % ceiling;
	}
}
