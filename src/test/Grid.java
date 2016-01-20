package test;

public class Grid {
	public static boolean dfs(char[][] board, String s) {
		if(board == null || board.length == 0 || board[0].length == 0 || s == null) {
			return false;
		} else if(s.equals("")) {
			return true;
		} else {
			for(int row = 0; row < board.length; row++)
				for(int col = 0; col < board[0].length; col++)
					if(board[row][col] == s.charAt(0))
						if(dfsHelper(board, s, 1, row, col, new boolean[board.length][board[0].length]))
							return true;
			return false;
		}
	}
	private static boolean dfsHelper(char[][] board, String s, int pos, int R, int C, boolean[][] visited) {
		if(pos >= s.length()) {
			return true;
		} else {
			visited[R][C] = true;
			int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
			for(int i = 0; i < 4; i++) {
				int newR = R + dirs[i][0], newC = C + dirs[i][1];
				if(newR >= 0 && newC >= 0 && newR < board.length && newC < board[0].length
					&& !visited[newR][newC] && board[newR][newC] == s.charAt(pos)
					&& dfsHelper(board, s, pos + 1, newR, newC, visited)) {
					return true;
				}
			}
			return false;
		}
	}
}
