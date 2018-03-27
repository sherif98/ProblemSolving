package trees;

public class SumRootToLeafMod {

    private long ret;

    public int sumNumbers(TreeNode A) {
        solve(A, 0);
        return (int) ret;
    }

    private void solve(TreeNode root, int p) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            p *= 10;
            p += root.val;
            ret = (ret % 1003 + p % 1003) % 1003;
        }
        p *= 10;
        p += root.val;
        solve(root.left, p % 1003);
        solve(root.right, p % 1003);
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
