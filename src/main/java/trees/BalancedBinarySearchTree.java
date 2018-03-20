package trees;

public class BalancedBinarySearchTree {

    private boolean answer = true;

    public int isBalanced(TreeNode A) {
        solve(A);
        return answer ? 1 : 0;
    }

    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + solve(root.left);
        int right = 1 + solve(root.right);
        answer = answer && Math.abs(left - right) <= 1;
        return Math.max(left, right);
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
