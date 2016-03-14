package test;

import java.util.HashMap;
import java.util.Map;

import tools.io;

public class LRUCache {
    private class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private Node popNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
    
    private void addLast(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    
    int capacity;
    Node head, tail;
    Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        if(capacity > 0) {
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0); 
            head.next = tail;
            tail.prev = head;
            map = new HashMap<Integer, Node>();
        }
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        addLast(popNode(node));
        return node.val;
    }
    
    public void set(int key, int value) {
        Node node;
        if(map.containsKey(key)) {
            node = popNode(map.get(key));
            node.val = value;
        } else {
            node = new Node(key, value);
            if(map.size() == capacity)
                map.remove(popNode(head.next).key);
        }
        map.put(key, node);
        addLast(node);
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache(1);
    	cache.set(2, 1);
    	io.pl(cache.get(2));
    	cache.set(3, 2);
    	io.pl(cache.get(2));
    	io.pl(cache.get(3));
    }
}