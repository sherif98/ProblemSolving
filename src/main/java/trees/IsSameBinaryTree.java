package trees;

public class IsSameBinaryTree {

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null) {
            return B == null ? 1 : 0;
        }
        if (B == null) {
            return A == null ? 1 : 0;
        }
        return A.val == B.val && isSameTree(A.left, B.left) == 1
                && isSameTree(A.right, B.right) == 1 ? 1 : 0;
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
