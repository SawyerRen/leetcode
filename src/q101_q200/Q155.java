package q101_q200;

import java.util.Stack;

public class Q155 {
    class MinStack {
        class Node {
            Node next;
            int val;
            int min;

            public Node(Node next, int val, int min) {
                this.next = next;
                this.val = val;
                this.min = min;
            }
        }

        Node head;

        public MinStack() {

        }

        public void push(int val) {
            if (head == null) {
                head = new Node(null, val, val);
            } else {
                head = new Node(head, val, Math.min(head.min, val));
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

    class MinStack1 {
        Stack<Integer> vals = new Stack<>();
        Stack<Integer> mins = new Stack<>();

        public MinStack1() {

        }

        public void push(int val) {
            vals.push(val);
            if (mins.isEmpty() || mins.peek() >= val) {
                mins.push(val);
            }
        }

        public void pop() {
            int pop = vals.pop();
            if (pop == mins.peek()) mins.pop();
        }

        public int top() {
            return vals.peek();
        }

        public int getMin() {
            return mins.peek();
        }
    }
}
