package leetcode.Design;

import java.util.HashMap;
import java.util.Map;

//LRU缓存机制
public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        DLinkedNode(){};
        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> map = new HashMap<>();
    private int capacity;
    private DLinkedNode head;
    private int size;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            removeToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node == null) { //map中没有该节点
            node = new DLinkedNode(key, value);
            addToHead(node);
            map.put(key, node);
            size++;
            if (size > capacity) {
                DLinkedNode res = removeTail();
                map.remove(res.key);
                size--;
            }
        } else {//map中存在，先定位，再修改，移到头部
            node.value = value;
            removeToHead(node);
        }
    }

    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void removeToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
