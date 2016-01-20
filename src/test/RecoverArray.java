package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RecoverArray {
	static Random rand;
	public static int[] recover(int[] arr) {
        if(arr == null || arr.length == 0)
        	return arr;
        int[] ret = new int[arr.length];
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= arr.length; i++)
            list.add(i);
        for(int i = arr.length - 1; i >= 0; i--)
    		ret[i] = list.remove(i - arr[i]);
        return ret;
	}
	public static int[] generateShuffledArray(int len) {
		if(len < 1)
			throw new RuntimeException("invalid initial length");
		rand = new Random();
		int[] ret = new int[len];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < len; i++)
			list.add(i + 1);
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return rand.nextInt();
			}
		});
		for(int i = 0; i < ret.length; i++)
			ret[i] = list.get(i);
		return ret;
	}
	public static int[] rank(int[] arr) {
		if(arr == null || arr.length == 0)
			return arr;
		int[] ret = new int[arr.length];
		for(int curr = 0; curr < arr.length; curr++)
			for(int prev = 0; prev < curr; prev++)
				if(arr[prev] > arr[curr])
					ret[curr]++;
		return ret;
	}
}
