package test;

import java.util.*;

import tools.Pair;

public class InterleaveString {
	public static String interleave(String s) {
		if(s == null || s.length() < 3)
			return s;
		char[] ca = s.toCharArray();
		int pR = ca.length - 1;
		for(int pL = 1; pL < pR; pL++) {
			if(ca[pL - 1] == ca[pL]) {
				while(pL < pR && ca[pR] == ca[pL - 1])
					pR--;
				if(ca[pR] == ca[pL - 1]) {
					pL--;
					pR = ca.length - 1;
					continue;
				}
				char temp = ca[pL];
				ca[pL] = ca[pR];
				ca[pR] = temp;
			}
		}
		return new String(ca);
	}
	public static String rearrange(String s) {
		if(s == null)
			throw new RuntimeException("null input");
		if(s.equals(""))
			return s;
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			if(c == '\0')
				throw new RuntimeException("illegal character '\\0'");
			else {
				if(!map.containsKey(c))
					map.put(c, 1);
				else
					map.put(c, map.get(c) + 1);
			}
		}
		/*
		PriorityQueue<Map.Entry<Character, Integer>> heap = 
			new PriorityQueue<>(1,
				new Comparator<Map.Entry<Character, Integer>>() {
						@Override
						public int compare(Map.Entry<Character, Integer> e1,
							Map.Entry<Character, Integer> e2) {
						return e2.getValue() - e1.getValue();
					}
				});
				*/
		PriorityQueue<Pair<Character, Integer>> heap = 
				new PriorityQueue<>(1,
						new Comparator<Pair<Character, Integer>>() {
					@Override
					public int compare(Pair<Character, Integer> p1,
							Pair<Character, Integer> p2) {
						return p2.y - p1.y;
					}
				});
		for(Map.Entry<Character, Integer> e : map.entrySet()) {
			Pair<Character, Integer> p = new Pair<Character, Integer>(e.getKey(), e.getValue());
			heap.add(p);
		}
		char[] ca = new char[s.length()];
		for(int i = 0; i < ca.length; i++)
			ca[i] = '\0';
		while(!heap.isEmpty()) {
			Pair<Character, Integer> p = heap.poll();
			char c = p.x;
			int start = 0;
			while(start < ca.length && ca[start] != '\0')
				start++;
			for(int j = 0; j < p.y; j++) {
				if(start + j * 2 >= ca.length)
					throw new RuntimeException("cannot be rearranged");
				ca[start + j * 2] = c;
			}
		}
		return new String(ca);
	}
}
