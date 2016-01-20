package test;

public class LongestLoop {
	public static int longestLoop(int[] graph) {
		int[] max = new int[1];
		if(graph != null && graph.length > 0) {
			int[] lengths = new int[graph.length];
			for(int i = 0; i < graph.length; i++)
				if(lengths[i] == 0)
					helper(graph, max, i, 1, lengths);
		}
		return max[0];
	}
	private static void helper(int[] graph, int[] max, int i, int len, int[] lengths) {
		if(i != graph[i]) {	// remove "infinite loop"
			if(lengths[i] == 0) {
				lengths[i] = len;
				helper(graph, max, graph[i], len + 1, lengths);
			} else {
				max[0] = len - lengths[i] > max[0] ? len - lengths[i] : max[0];
			}
		}
	}
}
