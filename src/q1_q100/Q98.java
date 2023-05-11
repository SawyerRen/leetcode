package q1_q100;

import models.TreeNode;

public class Q98 {
    boolean res = true;

    public boolean isValidBST(TreeNode root) {
        helper(root, null, null);
        return res;
    }

    private void helper(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) return;
        if (minNode != null && root.val <= minNode.val) res = false;
        if (maxNode != null && root.val >= maxNode.val) res = false;
        helper(root.left, minNode, root);
        helper(root.right, root, maxNode);
    }
}
