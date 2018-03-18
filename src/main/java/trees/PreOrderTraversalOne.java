package trees;

import java.util.ArrayList;

public class PreOrderTraversalOne {

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> ret = new ArrayList<>();
        solve(A, ret);
        return ret;
    }

    private void solve(TreeNode root, ArrayList<Integer> ret) {
        if (root != null) {
            ret.add(root.val);
            solve(root.left, ret);
            solve(root.right, ret);
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
