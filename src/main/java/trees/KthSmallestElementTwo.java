package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementTwo {

    public int kthsmallest(TreeNode A, int B) {
        return solve(A, B);
    }

    private int solve(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            if (cur.right != null) {
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return -1;
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
