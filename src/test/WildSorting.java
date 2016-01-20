package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class WildSorting {
	public static void wildSorting(List<String> list, String std) {
		if(!list.isEmpty() && list.size() > 0 && std != null && std.length() == 26) {
			int[] alphabet = new int[26];
			for(int p = 0; p < std.length(); p++)
				alphabet[std.charAt(p) - 'a'] = p;
			Comparator<String> cmp = new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1 == null && o2 == null)
						return 0;
					if(o1 == null || o2 == null)
						return o1 == null ? -1 : 1;
					if(o1.length() == 0 || o2.length() == 0)
						return o1.length() - o2.length();
					int p1 = 0, p2 = 0;
					for(;p1 < o1.length() && p2 < o2.length(); p1 -= (p2 - ++p2))
						if(o1.charAt(p1) != o2.charAt(p2))
							return alphabet[o1.charAt(p1) - 'a'] - alphabet[o2.charAt(p2) - 'a'];
					return (o1.length() - p1) - (o2.length() - p2);
				}	
			};
			Collections.sort(list, cmp);
		}
	}
	public static String generateAlphabet() {
		Set<Character> set = new HashSet<>();
		Random rand = new Random();
		String ret = "";
		int counter = 26;
		char c = '\0';
		while(counter-- > 0) {
			while(c == '\0' || set.contains(c)) {
				int r = rand.nextInt();
				r = r > 0 ? r : -r;
				c = (char)((r % 26) + 97);
			}
			set.add(c);
			ret += c;
		}
		return ret;
	}
}
