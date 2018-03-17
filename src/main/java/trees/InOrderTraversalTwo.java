package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class InOrderTraversalTwo {


    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = A;
        while (!stack.isEmpty() || root != null) {
            if (root == null) {
                root = stack.pop();
                ret.add(root.val);
                root = root.right;
                continue;
            }
            stack.push(root);
            root = root.left;
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
