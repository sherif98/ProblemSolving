package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenBinaryTreeToList {

    public TreeNode flatten(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        }
        TreeNode current = new TreeNode(-1);
        TreeNode ret = current;
        while (!stack.isEmpty()) {
            current.right = stack.pop();
            current = current.right;
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            current.left = null;
        }
        return ret.right;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

}
