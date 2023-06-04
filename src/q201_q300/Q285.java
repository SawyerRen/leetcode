package q201_q300;

import models.TreeNode;

public class Q285 {
    TreeNode res = null, target = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root, p);
        return res;
    }

    private void helper(TreeNode root, TreeNode p) {
        if (root == null) return;
        helper(root.left, p);
        if (target != null) {
            res = res == null ? root : res;
            return;
        }
        if (root.val == p.val) {
            target = root;
        }
        helper(root.right, p);
    }
}
