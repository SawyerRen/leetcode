package q101_q200;

import models.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preIndex++];
        int inIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, inorder, left, inIndex - 1);
        root.right = helper(preorder, inorder, inIndex + 1, right);
        return root;
    }
}
