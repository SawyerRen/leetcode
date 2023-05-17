package q101_q200;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
    class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        DoubleLinkedList list = new DoubleLinkedList();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            put(node.key, node.value);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                list.remove(map.get(key));
                list.addFirst(node);
            } else {
                if (list.len == capacity) {
                    int lastKey = list.removeLast();
                    map.remove(lastKey);
                }
                list.addFirst(node);
            }
            map.put(key, node);
        }
    }

    class DoubleLinkedList {
        Node head;
        Node tail;
        int len;

        public DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            len = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
            len++;
        }

        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            len--;
        }

        int removeLast() {
            Node node = tail.pre;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            len--;
            return node.key;
        }
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
