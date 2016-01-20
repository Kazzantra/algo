package test;
import java.util.Arrays;

public class Solution {
	private static <T> void print(T v) {
		System.out.println(v);
	}
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        } else if(s1.equals(s2)) {
            return true;
        } else {
            char[] ca1 = s1.toCharArray(), ca2 = s2.toCharArray();
            Arrays.sort(ca1);
            Arrays.sort(ca2);
            String t1 = new String(ca1), t2 = new String(ca2);
            if(!t1.equals(t2))
                return false;
            int L = s1.length();
            for(int i = 1; i < L; i++) {
            	String head1 = s1.substring(0, i),
            			head2 = s2.substring(0, i),
            			body1 = s1.substring(i, L),
            			body2 = s2.substring(i, L),
            			tail1 = s1.substring(L - i, L),
            			tail2 = s2.substring(L - i, L),
            			rem1 = s1.substring(0, L - i),
            			rem2 = s2.substring(0, L - i);
            	print(head1+" "+head2+" "+body1+" "+body2+" "+tail1+" "+tail2+" "+rem1+" "+rem2);
                if(isScramble(head1, head2) &&
                    isScramble(body1, body2))
                    return true;
                if(isScramble(rem1, rem2) &&
                    isScramble(tail1, tail2))
                    return true;
                if(isScramble(head1, tail2) &&
                	isScramble(head2, tail1))
                	return true;
                if(isScramble(rem1, body2) &&
                	isScramble(rem2, body1))
                	return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isScramble("abc", "bca") ? "true" : "false");
    }
}
