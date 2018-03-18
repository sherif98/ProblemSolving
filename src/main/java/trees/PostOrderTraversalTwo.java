package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PostOrderTraversalTwo {

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> ans = new ArrayDeque<>();
        if (A != null) {
            stack.push(A);
        }
        while (!stack.isEmpty()) {
            TreeNode root = stack.pop();
            ans.push(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        return new ArrayList<>(ans);
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
