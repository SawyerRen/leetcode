package com.meta1.q400;

public class Q426 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head = new Node();
    Node pre = head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        pre.right = head.right;
        head.right.left = pre;
        return head.right;
    }

    private void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        pre.right = root;
        root.left = pre;
        pre = root;
        helper(root.right);
    }
}
