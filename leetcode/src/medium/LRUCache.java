package medium;

import java.util.HashMap;

/**
 * leetcode: 146*/
public class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;
    HashMap<Integer,Node> m = new HashMap<>();
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    //头插
    private void addNode(Node newNode){
        Node temp = head.next;

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    private void deleteNode(Node delNode){
        Node pre = delNode.prev;
        Node next = delNode.next;

        pre.next = next;
        next.prev = pre;
    }
    public int get(int key) {
        if (m.containsKey(key)){
            Node resNode = m.get(key);
            int resVal = resNode.val;

            m.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            m.put(key, head.next);
            return resVal;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)){
            Node curr = m.get(key);
            m.remove(key);
            deleteNode(curr);
        }
        if (m.size() == cap){
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key,value));
        m.put(key,head.next);
    }
}
