package trees;

import java.util.ArrayList;

public class PostOrderTraversalOne {

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> ret = new ArrayList<>();
        solve(A, ret);
        return ret;
    }

    private void solve(TreeNode root, ArrayList<Integer> ret) {
        if (root != null) {
            solve(root.left, ret);
            solve(root.right, ret);
            ret.add(root.val);
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
