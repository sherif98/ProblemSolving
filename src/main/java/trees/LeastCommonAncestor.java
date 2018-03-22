package trees;

public class LeastCommonAncestor {

    public int lca(TreeNode A, int B, int C) {
        if (!contains(A, B) || !contains(A, C)) {
            return -1;
        }
        return solve(A, B, C);
    }

    private boolean contains(TreeNode root, int a) {
        if (root == null) {
            return false;
        }
        return root.val == a || contains(root.left, a) || contains(root.right, a);
    }

    private int solve(TreeNode root, int a, int b) {
        if (root == null) {
            return -1;
        }
        if (root.val == a || root.val == b) {
            return root.val;
        }
        int left = solve(root.left, a, b);
        int right = solve(root.right, a, b);
        if (left != -1 && right != -1) {
            return root.val;
        }
        if (left == -1) {
            return right;
        }
        return left;
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
