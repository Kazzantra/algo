package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import tools.io;

public class WordBreak {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<List<String>> all = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        if(s != null && s.length() > 0 && wordDict != null && wordDict.size() > 0) {
            TrieNode dummy = new TrieNode();
            for(String str : wordDict)
                addWord(dummy, str);
            helper(s, all, new LinkedList<String>(), dummy);
        }
        if(all.size() > 0)
            for(List<String> list : all)
                ret.add(concatAll(list));
        return ret;
    }
    private void helper(String s, List<List<String>> all, LinkedList<String> bag, TrieNode dummy) {
        if(s.equals("")) {
            all.add(new LinkedList<String>(bag));
            bag = new LinkedList<String>();
            return;
        }
        for(int i = 0; i <= s.length(); i++) {
        	String curr = s.substring(0, i);
            if(contains(dummy, curr)) {
                bag.addLast(curr);
                helper(s.substring(i), all, bag, dummy);
                bag.pollLast();
            }
        }
    }
    private String concatAll(List<String> list) {
        String ret = "";
        if(list != null && list.size() > 0) {
            ret = list.get(0);
            for(int i = 0; i < list.size(); i++)
                if(list.get(i) != null && list.get(i).length() > 0)
                    ret += (" " + list.get(i));
        }
        return ret;
    }
    class TrieNode {
        boolean isEnd = false;
        TrieNode[] next;
        TrieNode() { next = new TrieNode[26]; }
    }
    private void addWord(TrieNode dummy, String s) {
        if(s != null) {
            TrieNode node = dummy;
            for(int i = 0; i < s.length(); i++) {
                if(node.next[s.charAt(i) - 'a'] == null)
                    node.next[s.charAt(i) - 'a'] = new TrieNode();
                node = node.next[s.charAt(i) - 'a'];
            }
            node.isEnd = true;
        }
    }
    private boolean contains(TrieNode dummy, String s) {
        if(s == null)
            return false;
        TrieNode node = dummy;
        int i = 0;
        for(; i < s.length() && node != null; i++)
            node = node.next[s.charAt(i) - 'a'];
        return i == s.length() && node != null && node.isEnd;
    }
    public static void main(String[] args) {
    	String s = "abcdef";
    	String[] arr = {"abc", "bcd", "def"};
    	Set<String> set = new HashSet<String>(Arrays.asList(arr));
    	for(String str : new WordBreak().wordBreak(s, set))
    		io.pl(str);
    }
}
