package test;

public class MooreVoting {
	public static int indexOfMajorityElement(int[] arr) {
		if(arr == null || arr.length == 0)
			return -1;
		int ret = 0, counter = 0;
		for(int i : arr) {
			if(counter == 0) {
				ret = i;
				counter = 1;
			} else
				counter += (i == ret ? 1 : - 1); 
		}
		counter = 0;
		for(int i : arr)
			if(i == ret)
				counter++;
		return counter >= (arr.length + 1) / 2 ? ret : -1;
	}
}
