package test;

import java.util.HashMap;
import java.util.Map;

import tools.io;

public class MaxSubarrayLength {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> sums = new HashMap<>(), sum2index = new HashMap<>();
        sums.put(-1, 0);
        sum2index.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            int sum = nums[i] + sums.get(i - 1);
            sums.put(i, sum);
            if(!sum2index.containsKey(sum))
                sum2index.put(sum, i);
        }
        int max = 0;
        for(int end = 0; end < nums.length; end++)
            if(sum2index.containsKey(sums.get(end) - k))
                if(end - sum2index.get(sums.get(end) - k) > max)
                    max = end - sum2index.get(sums.get(end) - k);
        return max;
    }
    public static void main(String[] args) {
    	int[] arr = {1,-1,5,-2,3}; 
    	io.pl(new MaxSubarrayLength().maxSubArrayLen(arr, 3));
    }
}
