package test;

public class Log2 {
	public static int log2(int i) {
		if(i <= 0)
			throw new RuntimeException("invalid input (" + i + ")");
		if(i == 1)
			return 0;
		return 1 + log2(i / 2);
	}
}
