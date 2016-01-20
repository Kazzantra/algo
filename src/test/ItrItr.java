package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tools.io;

public class ItrItr<T> {
	private List<Iterator<T>> list;
	private List<Iterator<T>> trashcan;
	public ItrItr(List<Iterator<T>> list) {
		this.list = list;
		trashcan = new LinkedList<Iterator<T>>();
	}
	public ItrItr() {
		list = null;
		trashcan = new LinkedList<Iterator<T>>();
	}
	public boolean hasNext() {
		if(list == null || list.size() == 0)
			return false;
		int size = list.size();
		for(int i = 0; i < size; i++) {
			Iterator<T> itr = list.remove(0);
			if(itr == null || !itr.hasNext()) {
				trashcan.add(itr);
			} else {
				list.add(list.size(),itr);
				return true;
			}
		}
		return false;
	}
	public T next() {
		if(hasNext()) {
			T ret = list.get(list.size() - 1).next();
			list.add(list.size() - 1, list.remove(0));
			return ret;
		}
		throw new RuntimeException("no next");
	}
	public static void main(String[] args) {
		Integer[] arr1 = {1, 2};
		Integer[] arr2 = {3, 4};
		Iterator<Integer> itr1 = new ArrayList<Integer>(Arrays.asList(arr1)).iterator();
		Iterator<Integer> itr2 = new ArrayList<Integer>(Arrays.asList(arr2)).iterator();
		List<Iterator<Integer>> list = new ArrayList<Iterator<Integer>>();
		list.add(itr1);
		list.add(itr2);
		ItrItr<Integer> itr = new ItrItr<Integer>(list);
		io.pl(itr.hasNext());
		io.pl(itr.next());
		io.pl(itr.hasNext());
		io.pl(itr.next());
		io.pl(itr.hasNext());
		io.pl(itr.next());
		io.pl(itr.hasNext());
		io.pl(itr.next());
		io.pl(itr.hasNext());
		io.pl(itr.next());
	}
}
