package test;

import tools.io;

public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int max = 1;
        int[][] mem = new int[matrix.length][matrix[0].length];
        final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                int len = helper(matrix, row, col, mem, dirs, 1);
                if(max < len)
                    max = len;
            }
        }
        return max;
    }
    private int helper(int[][] matrix, int row, int col, int[][] mem, int[][] dirs, int len) {
        if(mem[row][col] > 0)
            return mem[row][col] + len - 1;
        int ret = len, newLen = len;
        for(int dir = 0; dir < dirs.length; dir++) {
            int newRow = row + dirs[dir][0], newCol = col + dirs[dir][1];
            if(0 <= newRow && newRow < matrix.length && 0 <= newCol && newCol < matrix[0].length
                && matrix[row][col] < matrix[newRow][newCol]) {
                newLen = helper(matrix, newRow, newCol, mem, dirs, len + 1);
                if(ret < newLen)
                    ret = newLen;
            }
        }
        mem[row][col] = ret - len + 1;
        return ret;
    }
    public static void main(String[] args) {
    	LongestIncreasingPathInMatrix path = new LongestIncreasingPathInMatrix();
    	int[][] matrix = {{3,4,5},
    					  {3,2,6},
    					  {2,2,1}};
    	io.pl(path.longestIncreasingPath(matrix));
    }
}
