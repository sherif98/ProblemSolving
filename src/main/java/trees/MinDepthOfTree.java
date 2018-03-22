package trees;

public class MinDepthOfTree {

    private int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode A) {
        solve(A, 1);
        return min;
    }

    private void solve(TreeNode root, int depth) {
        if (depth > min) {
            return;
        }
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            min = depth;
            return;
        }
        solve(root.left, depth + 1);
        solve(root.right, depth + 1);
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
