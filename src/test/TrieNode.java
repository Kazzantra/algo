package test;

public class TrieNode {
	public static int CHAR_NUM = 26;
	public char c = '\0';
	public TrieNode[] next;
	public boolean isWordEnd = false;
	public TrieNode() {
		next = new TrieNode[CHAR_NUM];
	}
	public TrieNode(char c) {
		this.c = c;
		next = new TrieNode[CHAR_NUM];
	}
}
