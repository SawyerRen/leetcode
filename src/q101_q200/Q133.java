package q101_q200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        helper(node);
        return map.get(node);
    }

    private Node helper(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(helper(neighbor));
        }
        return newNode;
    }
}
