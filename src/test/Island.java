package test;

import tools.Pair;

public class Island {
	public static Pair<Integer, Integer> countIslands(int[][] world) {
		Pair<Integer, Integer> ret = new Pair<>(0, 0);
		if(world != null && world.length > 0 && world[0].length > 0) {
			int max = 0, curr = 2, target = 1;
			for(int row = 0; row < world.length; row++) {
				for(int col = 0; col < world[0].length; col++) {
					if(world[row][col] == target) {
						ret.x++;
						int[] size = new int[1];
						helper(world, row, col, curr++, target, size);
						max = size[0] > max ? size[0] : max;
					}
				}
			}
			ret.y = max;
		}
		return ret;
	}
	private static void helper(int[][] w, int r, int c, int newVal, int target, int[] size) {
		w[r][c] = newVal;
		size[0]++;
		int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for(int i = 0; i < 4; i++) {
			int newR = r + dirs[i][0], newC = c + dirs[i][1];
			if(newR >= 0 && newC >= 0 && newR < w.length && newC < w[0].length && w[newR][newC] == target)
				helper(w, newR, newC, newVal, target, size);
		}
	}
}
