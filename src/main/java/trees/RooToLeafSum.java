package trees;

public class RooToLeafSum {

    public int hasPathSum(TreeNode A, int B) {
        return solve(A, 0, B) ? 1 : 0;
    }

    private boolean solve(TreeNode root, int sum, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum + root.val == target) {
            return true;
        }
        return solve(root.left, sum + root.val, target) ||
                solve(root.right, sum + root.val, target);
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
