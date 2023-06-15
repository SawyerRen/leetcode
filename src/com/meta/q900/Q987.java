package com.meta.q900;

import models.TreeNode;

import java.util.*;

public class Q987 {
    class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        nodeQueue.add(root);
        colQueue.add(0);
        int min = 0, max = 0, row = 0;
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                int col = colQueue.poll();
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(new Node(row, col, node.val));
                min = Math.min(min, col);
                max = Math.max(max, col);
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    colQueue.add(col - 1);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    colQueue.add(col + 1);
                }
            }
            row++;
        }
        for (int i = min; i < max + 1; i++) {
            List<Node> nodes = map.get(i);
            nodes.sort((a, b) -> a.row == b.row ? a.val - b.val : a.row - b.row);
            List<Integer> list = new ArrayList<>();
            for (Node node : nodes) {
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }
}
