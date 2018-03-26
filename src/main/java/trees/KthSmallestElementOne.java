package trees;

public class KthSmallestElementOne {

    public int kthsmallest(TreeNode A, int B) {
        return solve(A, B);
    }

    private int solve(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int sizeLeft = size(root.left);
        if (sizeLeft == k - 1) {
            return root.val;
        } else if (sizeLeft > k - 1) {
            return solve(root.left, k);
        } else {
            return solve(root.right, k - 1 - sizeLeft);
        }
    }

    private int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1;
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
