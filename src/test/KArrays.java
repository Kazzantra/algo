package test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import tools.Pair;

public class KArrays {
	public static int[] mergeKSortedArrays(List<Integer[]> list) {
		int[] ret = null;
		if(list != null) {
			int size = 0;
			for(Integer[] iarr : list)
				if(iarr != null)
					size += iarr.length;
			ret = new int[size];
			if(size > 0 ) {
				PriorityQueue<Pair<Integer, Integer[]>> heap = new PriorityQueue<>(1,
						new Comparator<Pair<Integer, Integer[]>>() {
					@Override
					public int compare(Pair<Integer, Integer[]> p1, Pair<Integer, Integer[]> p2) {
						return - p1.y[p1.x] + p2.y[p2.x];
					}
				});
				for(Integer[] iarr : list)
					if(iarr != null && iarr.length > 0)
						heap.add(new Pair<Integer, Integer[]>(iarr.length - 1, iarr));
				int p = ret.length - 1;
				while(p >= 0) {
					Pair<Integer, Integer[]> pair = heap.poll();
					ret[p--] = pair.y[pair.x];
					if(pair.x - 1 >= 0)
						heap.add(new Pair<Integer, Integer[]>(pair.x - 1, pair.y));
				}
			}
		}
		return ret;
	}
}
