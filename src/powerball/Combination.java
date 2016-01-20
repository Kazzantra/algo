package powerball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combination {
	public List<Integer> numbers;
	public int power;
	public Combination() {
		this.numbers = new ArrayList<Integer>();
		this.power = 0;
	}
	public Combination(List<Integer> numbers, int power) {
		this.numbers = numbers;
		this.power = power;
	}
	public Combination(Double d) {
		this.numbers = new ArrayList<Integer>();
		long l = (long) (d * 100);
		this.power = (int) (l % 100);
		do {
			l /= 100;
			this.numbers.add(0, (int) (l % 100));
		} while(l > 0);
	}
	public boolean equals(Combination c2) {
		return c2 == null ? false : this.hashCode() == c2.hashCode();
	}
	public void normalize() {
		Collections.sort(this.numbers);
	}
	@Override
	public int hashCode() {
		return this.norm().hashCode();
	}
	public String norm() {
		this.normalize();
		String s = "";
		for(int num : this.numbers)
			s += String.format("%02d", num);
		s += String.format("%02d", this.power);
		return s;
	}
	public String toString() {
		return this.norm();
	}
}
