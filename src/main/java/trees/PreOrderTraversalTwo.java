package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PreOrderTraversalTwo {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = A;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ret.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return ret;
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
