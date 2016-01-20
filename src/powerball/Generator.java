package powerball;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;

public class Generator implements Consumer<String> {
	public List<Combination> list;
	public Generator() {
		this.list = new ArrayList<Combination>();
	}
	public Generator(List<Combination> list) {
		this.list = list;
	}
	public void accept(String s) {
		if(this.list == null)
			this.list = new ArrayList<>();
		Combination c = new Combination();
		long l = (long) (Double.valueOf((java.lang.String) s) * 100);
		c.power = (int) (l % 100);
		do {
			l /= 100;
			c.numbers.add(0, (int) (l % 100));
		} while(l > 99);
		list.add(list.size(), c);
	}
	public static int abs(int i) {
		return i > 0 ? i : -i ;
	}
	public static void main(String[] args) {
		if(args != null && args.length > 0) {
			List<Combination> purchased = new ArrayList<>();
			Generator generator = new Generator(purchased);
			try {
				Files.lines(Paths.get(args[0])).forEach(generator);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Set<String> set = new HashSet<>();
			for(Combination c : generator.list)
				set.add(c.norm());
			Random rnd = new Random();
			Combination chosen = new Combination();
			do {
				for(int i = 0; i < 5; i++) {
					chosen.numbers.add(abs(rnd.nextInt()) % 69 + 1);
				}
				chosen.power = abs(rnd.nextInt()) % 26 + 1;
			} while(set.contains(chosen));
			System.out.println(chosen);
		}
	}
}
