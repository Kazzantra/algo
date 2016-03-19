package test;

import java.util.LinkedList;

import tools.io;

public class Trie {
	public TrieNode dummy = null;
	public Trie() {
		this.dummy = new TrieNode();
	}
	private int indexOf(char c) {
		if('a' <= c && c <= 'z')
			return c - 'a';
		if('A' <= c && c <= 'Z')
			return c - 'A' + 26;
		return -1;
	}
	public boolean add(String s) {
		if(s != null && s.length() > 0) {
			char[] ca = s.toCharArray();
			for(char c : ca)
				if(indexOf(c) == -1)
					return false;
			TrieNode node = dummy;
			for(int i = 0; i < ca.length; i++) {
				int index = indexOf(ca[i]);
				if(node.next[index] == null)
					node.next[index] = new TrieNode(ca[i]);
				node = node.next[index];
			}
			node.isEnd = true;
			return true;
		}
		return false;
	}
	public boolean containsWord(String s) throws Exception {
		if(s != null && s.length() > 0) {
			char[] ca = s.toCharArray();
			for(char c : ca)
				if(indexOf(c) == -1)
					throw new IllegalArgumentException("non-alphabetical character (" + c + ")");
			TrieNode node = dummy;
			int i = 0;
			while(i < ca.length && node != null)
				node = node.next[indexOf(ca[i++])];
			return i == ca.length && node != null && node.isEnd;
		} else throw new IllegalArgumentException("null or blank string");
	}
	public boolean contains(String s) {
		return searchFromNode(s, dummy);
	}
	private boolean searchFromNode(String s, TrieNode node) {
		if(s == null || node == null)
			return false;
		if(s.length() == 0)
			return true;
		int index = indexOf(s.charAt(0));
		if(index == -1)
			throw new IllegalArgumentException("non-alphabetical character (" + s.charAt(0) + ")");
		if(node.next[index] != null && searchFromNode(s.substring(1, s.length()), node.next[index]))
			return true;
		for(int i = 0; i < TrieNode.CHAR_NUM; i++)
			if(node.next[i] != null && searchFromNode(s, node.next[i]))
				return true;
		return false;
	}
	public boolean containsAbbr(String s) {
		return searchAbbrFromNode(s, dummy);
	}
	private boolean searchAbbrFromNode(String s, TrieNode node) {
		if(s == null || node == null)
			return false;
		if(s.length() == 0)
			return true;
		char c = s.charAt(0);
		int index = indexOf(c);
		if(index >= 26) {
			if(node.next[index] != null
					&& searchAbbrFromNode(s.substring(1, s.length()), node.next[index]))
				return true;
			for(int i = 0; i < 26; i++)
				if(node.next[i] != null && searchAbbrFromNode(s, node.next[i]))
					return true;
			return false;
		} else {
			return node.next[index] != null
					&& searchAbbrFromNode(s.substring(1, s.length()), node.next[index]);
		}
	}
	public void print() {
		LinkedList<TrieNode> q = new LinkedList<>();
		for(TrieNode tn : dummy.next)
			if(tn != null)
				q.addLast(tn);
		while (!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				TrieNode node = q.pollFirst();
				System.out.print(node.c + (node.isEnd ? "*" : " "));
				for(TrieNode tn : node.next)
					if(tn != null)
						q.addLast(tn);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("RuntimeException");
		io.pl(trie.containsAbbr("RE"));
	}
}
