package concurrency;

import java.util.ArrayList;
import java.util.List;

public class Playground {
	public static void main(String[] args) {
		List<Integer> pantry = new ArrayList<>();
		Thread t1 = new Thread(new Consumer(pantry, 100));
		Thread t2 = new Thread(new Producer(pantry, 100));
		t1.start();
		t2.start();
	}
}
