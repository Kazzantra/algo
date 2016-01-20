package test;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public static boolean isIsoStr(String a, String b) {
		if(a == null && b == null)
			return true;
		if(a == null || b == null || a.length() != b.length())
			return false;
		Map<Character, Character> mapA = new HashMap<>();
		Map<Character, Character> mapB = new HashMap<>();
		String newA = "", newB = "";
		char cA = 'a', cB = 'a';
		for(int i = 0; i < a.length(); i++) {
			if(!mapA.containsKey(a.charAt(i))) {
				newA += cA;
				mapA.put(a.charAt(i), cA++);
			} else {
				newA += mapA.get(a.charAt(i));
			}
			if(!mapB.containsKey(b.charAt(i))) {
				newB += cB;
				mapB.put(b.charAt(i), cB++);
			} else {
				newB += mapB.get(b.charAt(i));
			}
		}
		return newA.equals(newB);
	}
}
