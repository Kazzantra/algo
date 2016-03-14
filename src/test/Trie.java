package test;

import java.util.LinkedList;

public class Trie {
	public TrieNode root = null;
	public Trie() {
		this.root = new TrieNode();
	}
	public boolean add(String s) {
		if(s != null && s.length() > 0) {
			char[] ca = s.toCharArray();
			for(char c : ca)
				if(c < 'a' || c > 'z')
					return false;
			TrieNode node = root;
			for(int i = 0; i < ca.length; i++) {
				if(node.next[ca[i] - 'a'] == null)
					node.next[ca[i] - 'a'] = new TrieNode(ca[i]);
				node = node.next[ca[i] - 'a'];
			}
			node.isWordEnd = true;
			return true;
		}
		return false;
	}
	public boolean containsWord(String s) throws Exception {
		if(s != null && s.length() > 0) {
			char[] ca = s.toCharArray();
			for(char c : ca)
				if(c < 'a' || c > 'z')
					throw new IllegalArgumentException("non-alphabetical character (" + c + ")");
			TrieNode node = root;
			int i = 0;
			while(i < ca.length && node != null)
				node = node.next[ca[i++] - 'a'];
			return i == ca.length && node != null && node.isWordEnd;
		} else throw new IllegalArgumentException("null or blank string");
	}
	public boolean contains(String s) {
		return searchFromNode(s, root);
	}
	private boolean searchFromNode(String s, TrieNode node) {
		if(s == null || node == null)
			return false;
		if(s.length() == 0)
			return true;
		int index = s.charAt(0) - 'a';
		if(node.next[index] != null && searchFromNode(s.substring(1, s.length()), node.next[index]))
			return true;
		for(int i = 0; i < 26; i++)
			if(node.next[i] != null && searchFromNode(s, node.next[i]))
				return true;
		return false;
	}
	public void print() {
		LinkedList<TrieNode> q = new LinkedList<>();
		for(TrieNode tn : root.next)
			if(tn != null)
				q.addLast(tn);
		while (!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				TrieNode node = q.pollFirst();
				System.out.print(node.c + (node.isWordEnd ? "*" : " "));
				for(TrieNode tn : node.next)
					if(tn != null)
						q.addLast(tn);
			}
			System.out.println();
		}
	}
}
