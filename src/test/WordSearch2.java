package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tools.io;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if(board != null && board.length > 0 && board[0].length > 0 && words != null && words.length > 0) {
            Set<String> set = new HashSet<>();
            TrieNode dummy = new TrieNode();
            for(String s : words)
                addWord(dummy, s);
            final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            boolean[][] visiting = new boolean[board.length][board[0].length];
            for(int row = 0; row < board.length; row++)
                for(int col = 0; col < board[0].length; col++)
                    if(dummy.next[board[row][col] - 'a'] != null)
                        helper(board, row, col, String.valueOf(board[row][col]), dummy.next[board[row][col] - 'a'], list, visiting, dirs, set);
        }
        return list;
    }
    void helper(char[][] board, int row, int col, String s, TrieNode node, List<String> list, boolean[][] visiting, final int[][] dirs, Set<String> set) {
        if(node.isEnd && set.add(s))
            list.add(s);
        visiting[row][col] = true;
        for(int d = 0; d < dirs.length; d++) {
            int newRow = row + dirs[d][0], newCol = col + dirs[d][1];
            if(0 <= newRow && newRow < board.length && 0 <= newCol && newCol < board[0].length
                && !visiting[newRow][newCol] && node.next[board[newRow][newCol] - 'a'] != null)
                    helper(board, newRow, newCol, s + board[newRow][newCol], node.next[board[newRow][newCol] - 'a'], list, visiting, dirs, set);
        }
        visiting[row][col] = false;
    }
    class TrieNode {
        boolean isEnd = false;
        TrieNode[] next;
        TrieNode() { next = new TrieNode[26]; }
    }
    void addWord(TrieNode dummy, String s) {
        if(s != null && s.length() > 0) {
            TrieNode node = dummy;
            for(int i = 0; i < s.length(); i++) {
                if(node.next[s.charAt(i) - 'a'] == null)
                    node.next[s.charAt(i) - 'a'] = new TrieNode();
                node = node.next[s.charAt(i) - 'a'];
            }
            node.isEnd = true;
        }
    }
    public static void main(String[] args) {
    	String[] dict = {"a"};
    	char[][] board = {{'a', 'a'}};
    	for(String s : new WordSearch2().findWords(board, dict))
    		io.pl(s);
    }
}
