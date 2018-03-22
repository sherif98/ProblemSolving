package trees;

import java.util.ArrayList;

public class RooToLeafPathsWithSum {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        solve(ret, new ArrayList<>(), A, B);
        return ret;
    }

    private void solve(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> p, TreeNode root,
                       int left) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (left - root.val == 0) {
                p.add(root.val);
                ret.add(new ArrayList<>(p));
                p.remove(p.size() - 1);
            } else {
                return;
            }
        }
        p.add(root.val);
        solve(ret, p, root.left, left - root.val);
        solve(ret, p, root.right, left - root.val);
        p.remove(p.size() - 1);
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
