package test;

import java.util.ArrayList;
import java.util.List;

import tools.io;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return !(num == null || num.length() < 3) && helper(num, new ArrayList<Integer>(), 0);
    }
    private boolean helper(String num, List<Integer> segments, int prevLen) {
        if(segments.isEmpty() || (!segments.isEmpty() && segments.get(segments.size() - 1) + prevLen < num.length())) {
            int pos = segments.isEmpty() ? 0 : segments.get(segments.size() - 1);
            for(int p = prevLen; p + pos < num.length(); p++) {
                segments.add(segments.size(), p);
                if(isAdditiveSequence(segmenter(num, segments)) || helper(num, segments, p))
                    return true;
                segments.remove(segments.size() - 1);
            }
        }
        return false;
    }
    private List<Integer> segmenter(String num, List<Integer> segments) {
        List<Integer> list = new ArrayList<>();
        if(num != null && num.length() >= 3 && segments != null && segments.size() > 1) {
            int start = 0;
            for(int i = 1; i <= segments.size(); i++) {
                int end = i == segments.size() ? num.length() : segments.get(i) ;
                try {
                    list.add(Integer.valueOf(num.substring(start, end)));
                } catch(NumberFormatException nfe) {
                    throw new RuntimeException(num + ": " + start + ", " + end, nfe);
                }
                start = end;
            }
        }
        return list;
    }
    private boolean isAdditiveSequence(List<Integer> nums) {
        if(nums == null || nums.size() < 3)
            return false;
        for(int i = 2; i < nums.size(); i++)
            if(nums.get(i - 2) + nums.get(i - 1) != nums.get(i))
                return false;
        return true;
    }
    
    public static void main(String[] args) {
    	AdditiveNumber an = new AdditiveNumber();
    	io.pl(an.isAdditiveNumber("112358"));
    }
}
