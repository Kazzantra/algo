package tools;

public class Pair<T1 extends Object, T2 extends Object> {
	public T1 x;
	public T2 y;
	public Pair(T1 x, T2 y) {
		this.x = x;
		this.y = y;
	}
	public Pair() {
		x = null;
		y = null;
	}
	@Override
	public String toString() {
		return "[" + x.toString() + "," + y.toString() + "]";
	}
}
