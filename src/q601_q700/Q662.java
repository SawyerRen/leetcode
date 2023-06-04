package q601_q700;

import models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        nodeQueue.add(root);
        colQueue.add(1);
        int res = 0;
        while (!nodeQueue.isEmpty()) {
            Integer min = null, max = null;
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                int col = colQueue.poll();
                min = min == null ? col : min;
                max = col;
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    colQueue.add(col * 2);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    colQueue.add(col * 2 + 1);
                }
            }
            res = Math.max(res, max - min + 1);
        }
        return res;
    }
}
