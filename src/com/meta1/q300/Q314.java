package com.meta1.q300;

import models.TreeNode;

import java.util.*;

public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        Queue<Integer> colQueue = new LinkedList<>();
        colQueue.add(0);
        int min = 0, max = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int col = colQueue.poll();
            min = Math.min(min, col);
            max = Math.max(max, col);
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);
            if (node.left != null) {
                nodeQueue.add(node.left);
                colQueue.add(col - 1);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                colQueue.add(col + 1);
            }
        }
        for (int i = min; i < max + 1; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
