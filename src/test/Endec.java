package test;

import java.util.HashSet;
import java.util.Set;

public class Endec {
	static Set<Character> nums;
	public static String encode(String s) {
		if(s == null || s.length() < 3)
			return s;
		int p = -1, counter = 1;
		char prev = s.charAt(0);
		String ret = "";
		if(nums == null) {
			nums = new HashSet<>();
			for(char c = '0'; c <= '9'; c++)
				nums.add(c);
		}
		while(++p <= s.length()) {
			if(p < s.length()) {
				char c = s.charAt(p);
				if(nums.contains(c)) {
					ret += "1x" + String.valueOf(c);
					counter = 1;
					prev = c;
				} else if(prev != c) {
					if(counter >= 3) {
						ret += counter;
						ret += "x";
						ret += prev;
						counter = 1;
						prev = c;
					} else {
						for(int j = 0; j < counter; j++)
							ret += prev;
						prev = c;
						counter = 1;
					}
				} else {
					counter++;
				}
			} else {
				if(!nums.contains(prev)) {
					if(counter < 3) {
					for(int j = 0; j < counter; j++)
						ret += prev;
					} else {
						ret += counter;
						ret += 'x';
						ret += prev;
					}
				}
			}
		}
		return ret;
	}
	public static String decode(String s) {
		if(s == null || s.length() == 0)
			return s;
		if(nums == null) {
			nums = new HashSet<>();
			for(char c = '0'; c <= '9'; c++)
				nums.add(c);
		}
		String ret = "";
		boolean afterNum = false, afterX = false;
		int p = 0, counter = 0;
		char prev = s.charAt(0);
		while(++p <= s.length()) {
			if(p < s.length()) {
				char c = s.charAt(p);
				if(nums.contains(c)) {
					if(!afterX) {
						afterNum = true;
						afterX = false;
						counter = counter * 10 + c - '0';
					} else {
						ret += repeat(counter, prev);
					}
				} else if(c == 'x') {
					
				}
			}
		}
		return ret;
	}
	public static <T> String repeat(int times, T s) {
		if(times < 0 || s == null)
			throw new RuntimeException("invalid input");
		String ret = "";
		for(int i = 0; i < times; i++)
			ret += String.valueOf(s);
		return ret;
	}
}
