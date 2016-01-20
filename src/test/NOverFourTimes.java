package test;

import java.util.HashMap;
import java.util.Map;

public class NOverFourTimes {
	public static int nOver4Times(int[] arr) {
		if(arr == null || arr.length == 0)
			throw new RuntimeException("empty input");
		Map<Integer, Integer> map = new HashMap<>();
		for(int i : arr) {
			if(map.containsKey(i)) {
				if(map.get(i) + 1 >= arr.length / 4)
					return i;
				else
					map.put(i, map.get(i) + 1);
			} else
				map.put(i, 1);
		}
		throw new RuntimeException("no such element!");
	}
}
