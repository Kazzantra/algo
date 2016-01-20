package test;

import java.util.LinkedList;
import java.util.List;

import tools.Pair;
import tools.io;

public class Tester {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		if(false){
			Trie trie = new Trie();
			//trie.add("a1");
			trie.add("abcd");
			trie.add("abce");
			trie.add("abcdd");
			System.out.println(trie.contains("abc") ? "true" : "false");
			trie.print();
		}
		if(false) {
			char[][] caa = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
			System.out.println(Grid.dfs(caa, "he") ? "true" : "false");
		}
		if(true) {
			int[][] world = {
							{1, 2, 2, 3, 5},
							{3, 2, 3, 4, 4},
							{2, 4, 5, 3, 1},
							{6, 7, 1, 4, 5},
							{5, 1, 1, 2, 4}
							};
			for(Pair<Integer, Integer> p : Oceans.connectedPoints(world))
				System.out.println(p.toString() + world[p.x][p.y]);
		}
		if(false) {
			int[][] world = {
							{0, 0, 1, 1, 0, 1, 0},
							{0, 0, 1, 0, 0, 1, 0},
							{1, 0, 0, 0, 1, 1, 0},
							{0, 0, 0, 0, 0, 0, 1}
							};
			Pair<Integer, Integer> p = Island.countIslands(world);
			System.out.println(p);
			for(int[] a : world) {
				for(int i : a)
					io.p(i + " ");
				io.pl("");
			}
		}
		if(false) {
			int p1 = 0, p2 = 0;
			while(p1 < 10 && p2 < 10) {
				p1 -= (p2 - ++p2);
				io.pl("p1 = " + p1 + " p2 = " + p2);
			}
		}
		if(false) {
			String alphabet = WildSorting.generateAlphabet();
			String[] sample = "the quick brown fox jumps over the lazy dog".split(" ");
			List<String> list = new LinkedList<>();
			for(String s : sample)
				list.add(s);
			WildSorting.wildSorting(list, alphabet);
			for(String s : list)
				io.p(s + " ");
		}
		if(false) {
			int[] a1 = {1, 2, 3, 4, 0};
			io.pl(LongestLoop.longestLoop(a1));
			int[] a2 = {3, 5, 1, 6, 2, 4, 0};
			io.pl(LongestLoop.longestLoop(a2));
			int[] a3 = {2, 2, 2, 2};
			io.pl(LongestLoop.longestLoop(a3));
			int[] a4 = {3, 2, 1, 4, 0};
			io.pl(LongestLoop.longestLoop(a4));
			int[] a5 = {1, 2, 3, 4, 2, 0};
			io.pl(LongestLoop.longestLoop(a5));
		}
		if(false) {
			io.pl(IsomorphicStrings.isIsoStr("abb", "cdd") ? "true" : "false");
		}
		if(false) {
			io.pl(InterleaveString.interleave("abcdd"));
		}
		if(false) {
			RandomArray ra = new RandomArray();
			ra.add(4);
			ra.add(3);
			ra.add(2);
			ra.add(1);
			io.pl(ra.getRandom());
			ra.remove(0);
			ra.add(5);
			ra.remove(0);
			ra.remove(0);
		}
		if(false) {
			int[][] lawn = {{1, 1, -1},
							{1, -1, 1},
							{1, 1,  1}};
			for(String path : Mower.mow(lawn))
				io.pl(path);
		}
		if(false) {
			int[] arr = {1, 1, 2, 2, 2, 2, 2, 3, 3};
			io.pl(MooreVoting.indexOfMajorityElement(arr));
		}
		if(false) {
			int[] arr = {1, 2, 3, 4, 5, 6, 7, 7};
			io.pl(NOverFourTimes.nOver4Times(arr));
		}
		if(false) {
			io.pl(Log2.log2(19));
		}
		if(false) {
			io.pl(InterleaveString.rearrange("aabbccdd"));
		}
		if(false) {
			Integer[][] matrix = {{1, 2, 3, 4},
							  {5, 6, 7},
							  {8, 9},
							  {10}};
			List<Integer[]> list = new LinkedList<>();
			for(Integer[] iarr: matrix)
				list.add(iarr);
			int[] res = KArrays.mergeKSortedArrays(list);
			for(int i : res)
				io.p(i + " ");
		}
		if(false) {
			String s = "234xxxxaaa123"; 
			io.pl(s);
			io.pl(Endec.encode(s));
		}
		if(false) {
			for(int len = 5; len < 9; len++) {
				int[] arr = RecoverArray.generateShuffledArray(len);
				int[] ranked = RecoverArray.rank(arr);
				int[] recovered = RecoverArray.recover(ranked);
				for(int i : arr)
					io.p(i + " ");
				io.pl("");
				for(int i : ranked)
					io.p(i + " ");
				io.pl("");
				for(int i : recovered)
					io.p(i + " ");
				io.pl("");
			}
		}
	}
}
