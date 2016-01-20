package test;

import java.util.*;

import tools.Pair;

public class Oceans {
	public static List<Pair<Integer, Integer>> connectedPoints(int[][] world) {
		List<Pair<Integer, Integer>> ret = new LinkedList<>();
		if(world != null && world.length > 0 && world[0].length > 0) {
			boolean[][] topLeft = new boolean[world.length][world[0].length];
			boolean[][] bottomRight = new boolean[world.length][world[0].length];
			for(int row = 0; row < world.length; row++) {
				searchHigher(world, row, 0, topLeft);
				searchHigher(world, row, world[0].length - 1, bottomRight);
			}
			for(int col = 0; col < world[0].length; col++) {
				searchHigher(world, 0, col, topLeft);
				searchHigher(world, world.length - 1, col, bottomRight);
			}
			for(int row = 0; row < world.length; row++)
				for(int col = 0; col < world[0].length; col++)
					if(topLeft[row][col] && bottomRight[row][col])
						ret.add(new Pair<Integer, Integer>(row, col));
		}
		return ret;
	}
	private static void searchHigher(int[][] world, int row, int col, boolean[][] visited) {
		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		visited[row][col] = true;
		for(int i = 0; i < 4; i++) {
			int newRow = row + dirs[i][0];
			int newCol = col + dirs[i][1];
			if(newRow < 0 || newCol < 0 || newRow >= world.length || newCol >= world[0].length)
				continue;
			if(visited[newRow][newCol] || world[newRow][newCol] < world[row][col])
				continue;
			searchHigher(world, newRow, newCol, visited);
		}
	}
}
