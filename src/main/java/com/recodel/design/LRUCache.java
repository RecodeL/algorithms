package com.recodel.design;

import com.recodel.common.CacheNode;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, CacheNode> map;
    private int capacity, count;
    private CacheNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new CacheNode(0, 0);
        tail = new CacheNode(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    private void deleteNode(CacheNode CacheNode) {
        CacheNode.pre.next = CacheNode.next;
        CacheNode.next.pre = CacheNode.pre;
    }

    private void addToHead(CacheNode CacheNode) {
        CacheNode.next = head.next;
        CacheNode.next.pre = CacheNode;
        CacheNode.pre = head;
        head.next = CacheNode;
    }

    // This method works in O(1)
    public int get(int key) {
        if (map.get(key) != null) {
            CacheNode CacheNode = map.get(key);
            int result = CacheNode.value;
            deleteNode(CacheNode);
            addToHead(CacheNode);
            System.out.println("Got the value : " +
                    result + " for the key: " + key);
            return result;
        }
        System.out.println("Did not get any value" +
                " for the key: " + key);
        return -1;
    }

    // This method works in O(1)
    public void set(int key, int value) {
        System.out.println("Going to set the (key, " +
                "value) : (" + key + ", " + value + ")");
        if (map.get(key) != null) {
            CacheNode CacheNode = map.get(key);
            CacheNode.value = value;
            deleteNode(CacheNode);
            addToHead(CacheNode);
        } else {
            CacheNode CacheNode = new CacheNode(key, value);
            map.put(key, CacheNode);
            if (count < capacity) {
                count++;
                addToHead(CacheNode);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(CacheNode);
            }
        }
    }
}

class LRUCacheDemo {
     public static void main(String[] args) {
        System.out.println("Going to test the LRU " +
                " Cache Implementation");
        LRUCache cache = new LRUCache(2);

        // it will store a key (1) with value
        // 10 in the cache.
        cache.set(1, 10);

        // it will store a key (1) with value 10 in the cache.
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns 10

        // evicts key 2 and store a key (3) with
        // value 30 in the cache.
        cache.set(3, 30);

        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found)

        // evicts key 1 and store a key (4) with
        // value 40 in the cache.
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " +
                cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " +
                cache.get(4)); // return 40

    }
}
