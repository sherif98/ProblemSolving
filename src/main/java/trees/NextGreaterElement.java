package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElement {

    public TreeNode getSuccessor(TreeNode root, int t) {
        BSTIterator iter = new BSTIterator(root);
        TreeNode prev = null;
        TreeNode cur = null;
        while (iter.hasNext()) {
            cur = iter.next();
            if (prev != null && prev.val == t) {
                return cur;
            }
            prev = cur;
        }
        if (prev.val == cur.val) {
            return null;
        }
        return prev;
    }

    class BSTIterator {
        Deque<TreeNode> stack;

        BSTIterator(TreeNode root) {
            stack = new ArrayDeque<>();
            TreeNode cur = root;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }

        boolean hasNext() {
            return !stack.isEmpty();
        }

        TreeNode next() {
            TreeNode cur = stack.pop();
            TreeNode ret = cur;
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            return ret;
        }
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
