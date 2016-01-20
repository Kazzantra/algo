package test;

import java.util.LinkedList;
import java.util.List;

public class Mower {
	public static List<String> mow(int[][] lawn) {
		// negatives: obstacles; 0: grass; positives: mowed ground
		if(lawn == null || lawn.length == 0 || lawn[0].length == 0)
			return null;
		List<String> ret = new LinkedList<>();
		helper(lawn, ret, new StringBuilder(), 0, 0);
		return ret;
	}
	private static void helper(int[][] lawn, List<String> ret, StringBuilder bt, int x, int y) {
		if(x == lawn.length - 1 && y == lawn[0].length - 1) {
			bt.reverse();
			ret.add(bt.toString());
			bt.reverse();
			return;
		}
		if(bt.length() > lawn.length * lawn[0].length)
			return;
		int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		char[] mv = {'L', 'R', 'U', 'D'};
		for(int i = 0; i < 4; i++) {
			int newx = x + dirs[i][0];
			int newy = y + dirs[i][1];
			bt.append(mv[i]);
			if(newx >= 0 && newy >= 0 && newx < lawn.length && newy < lawn[0].length)
				if(lawn[newx][newy] >= 0)
					helper(lawn, ret, bt, newx, newy);
			bt.deleteCharAt(bt.length() - 1);
		}
	}
}
