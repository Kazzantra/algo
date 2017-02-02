package test;

import tools.io;

public class MaxPathSum {
	/*
	 * Complete the function below.
	 */
	    static int max(int a, int b) {
	        return a > b ? a : b;
	    }
	    static int min(int a, int b) {
	        return a < b ? a : b;
	    }
	    static int clip(int l, int val, int h) {
	        return max(l, min(val, h));
	    }
	    static int maxPathSum(int[][] board, int p, int q) {
	        if(board == null || board.length == 0 || board[0].length == 0 || p < 0 || p >= board[0].length || q < 0 || q >= board[0].length)
	            return 0;
	        final int MIN = Integer.MIN_VALUE;
	        
	        int[][] score = new int[board.length][board[0].length];
	        int leftBound = p, rightBound = p, l = MIN, m = MIN, r = MIN;
	        int pMax = MIN;
	        for(int row = 0; row < board.length; row++) {
	            for(int col = leftBound; col <= rightBound; col++) {
                    l = (row - 1 >= 0 && col - 1 >= 0) ? score[row - 1][col - 1] : 0;
                    m = (row - 1 >= 0) ? score[row - 1][col] : 0;
                    r = (row - 1 >= 0 && col + 1 < score[0].length) ? score[row - 1][col + 1] : 0;
                    score[row][col] = max(l, max(m, r)) + board[row][col];
	            }
	            if(leftBound > 0)
	                leftBound--;
	            if(rightBound < score[0].length - 1)
	                rightBound++;
	        }
	        for(int col = 0; col < score[0].length; col++) {
	            if(score[score.length - 1][col] > pMax)
	                pMax = score[score.length - 1][col];
	        }
	        
	        score = new int[board.length][board[0].length];
	        leftBound = q; rightBound = q; l = MIN; m = MIN; r = MIN; pMax = MIN;
	        int qMax = MIN;
	        for(int row = score.length - 1; row >= 0; row--) {
	            for(int col = leftBound; col <= rightBound; col++) {
                    l = (row + 1 < score.length && col - 1 >= 0) ? score[row + 1][col - 1] : 0;
                    m = (row + 1 < score.length) ? score[row + 1][col] : 0;
                    r = (row + 1 < score.length && col + 1 < score[0].length) ? score[row + 1][col + 1] : 0;
                    score[row][col] = max(l, max(m, r)) + board[row][col];
	            }
	            if(leftBound > 0)
	                leftBound--;
	            if(rightBound < score[0].length - 1)
	                rightBound++;
	        }
	        for(int col = 0; col < score[0].length; col++) {
	            if(score[0][col] > pMax)
	                pMax = score[0][col];
	        }
	        return max(pMax, qMax);
	    }
    public static void main(String[] args) {
    	int[][] board = {{9, 4, 7}, {2, 1, 3}, {1, 4, 2}};
    	io.pl(MaxPathSum.maxPathSum(board, 2, 1));
    }
}
