package test;

import java.util.HashMap;
import java.util.Random;

public class RandomArray {
	private int[] arr;
	private int pos;
	private HashMap<Integer, Integer> map;
	RandomArray() {
		arr = new int[1];
		pos = 0;
		map = new HashMap<Integer, Integer>();
	}
	RandomArray(int capacity) {
		if(capacity <= 0)
			throw new IndexOutOfBoundsException("initial capacity is " + capacity);
		arr = new int[capacity];
		pos = 0;
		map = new HashMap<Integer, Integer>();
	}
	public int get(int i) {
		if(i >= pos || i < 0)
			throw new IndexOutOfBoundsException("i = " + i + ", size = " + (pos));
		return arr[i];
	}
	public int getIndex(int val) {
		if(!map.containsKey(val))
			throw new NullPointerException("no such value (" + val + ")");
		return map.get(val);
	}
	public boolean add(int i) {
		if(!map.containsKey(i)) {
			if(pos >= arr.length) {
				int[] newArr = new int[arr.length * 2];
				for(int j = 0; j < arr.length; j++)
					newArr[j] = arr[j];
				arr = newArr;
			}
			arr[pos++] = i;
			map.put(i, pos);
			return true;
		} else {
			return false;
		}
	}
	public int set(int index, int value) {
		if(index >= pos || index < 0)
			throw new IndexOutOfBoundsException("i = " + index + ", size = " + pos);
		int prev = arr[index];
		map.remove(prev);
		arr[index] = value;
		map.put(value, pos);
		return prev;
	}
	public int remove(int index) {
		if(index >= pos || index < 0)
			throw new IndexOutOfBoundsException("i = " + index + ", size = " + pos);
		int prev = arr[index];
		map.remove(prev);
		if(index + 1 < pos)
			arr[index] = arr[pos - 1];
		pos--;
		map.put(arr[index], index);
		if(pos < (arr.length + 1) / 2) {
			int[] newArr = new int[(arr.length + 1) / 2];
			//map = new HashMap<Integer, Integer>();
			for(int i = 0; i < newArr.length; i++) {
				newArr[i] = arr[i];
				//map.put(arr[i], i);
			}
			arr = newArr;
		}
		return prev;
	}
	public int getRandom() {
		if(pos == 0)
			throw new IndexOutOfBoundsException("size = " + pos);
		Random rnd = new Random();
		int r = rnd.nextInt();
		if(r < 0)
			r = -r;
		return get(r % pos);
	}
}
