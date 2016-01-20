package test;

public class KMP {
	public static int find(String haystack, String needle) {
		if(haystack == null || needle == null || haystack.length() < needle.length())
			return -1;
		if(needle.equals(""))
			return 0;
		int[] next = new int[needle.length()];
		int curr = -1, start = 0;
		next[0] = -1;
		while(start < needle.length() - 1) {
			if(curr == -1 || needle.charAt(start) == needle.charAt(curr)) {
				start++;
				curr++;
				next[start] = curr;
			} else {
				curr = next[curr];
			}
		}
		int pH = 0, pN = 0;
		while(pH < haystack.length() && pN < needle.length()) {
			if(pN == -1 || haystack.charAt(pH) == needle.charAt(pN)) {
				pN++;
				pH++;
				// pH -= (pN - ++pN);
			} else {
				pN = next[pN];
			}
		}
		if(pN == needle.length()) {
			return pH - pN;
		}
		return -1;
	}
	@SuppressWarnings("unused")
	private static int template(String haystack, String needle) {
        // sanity checks
        if(haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;  // nulls or when haystack cannot accomodate needle
        } else if(needle.length() == 0) {
            return 0;   // when needle is "", any non-null haystack will have it
        } else {
            // KMP algorithm: building the table
            int[] next = new int[needle.length()];  // declaring the table
            next[0] = -1;   // for the initial char in needle, nowhere to fall back to, hence -1
            int start = 0, curr = -1;   // "start" actually starts from second char, while -1 marks "raw" curr
            while(start < next.length - 1) {    // this is similar to searching needle for itself
                if(curr == -1 || needle.charAt(start) == needle.charAt(curr)) { // if first run or char match
                    start++;    // move pointer at left forward by one char
                    curr++;     // move pointer at right forward by one char
                    next[start] = curr; // if not match, pause here and take note of curr
                    //}
                } else {
                    curr = next[curr];      // if not match, fall back according to the table
                }
            }   // finishing building the table
            int pH = 0, pN = 0, Lh = haystack.length(), Ln = needle.length();   // defining the pointers and limits
            while(pN < Ln && pH < Lh) {     // cannot run out of range
                if(pN == -1 || needle.charAt(pN) == haystack.charAt(pH)) {      // if first run or char match
                    pN++;   // move needle pointer forward by one char
                    pH++;   // move haystack pointer forward by one char
                } else {    // if not char match
                    pN = next[pN];  // fall back according to the table
                }
            }
            if(pN == Ln) {          // when needle pointer runs out of range, needle has been completely matched
                return pH - pN;     // return the position of needle initial match in haystack
            }
            return -1;              // if haystack has been thoroughly searched but not needle, declaring failure
        }
    }
}
